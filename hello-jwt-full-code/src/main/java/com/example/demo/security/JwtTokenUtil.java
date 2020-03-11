package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    public static final String PREFIX = "Bearer ";

    // Token có hạn trong vòng 24 giờ kể từ thời điểm tạo, thời gian tính theo giây
    @Value("${jwt.duration}")
    public Integer duration;

    // Lấy giá trị key được cấu hình trong file appliacation.properties
    // Key này sẽ được sử dụng để mã hóa và giải mã
    @Value("${jwt.secret}")
    private String secret;

    // Sinh token
    public String generateToken(UserDetails userDetails) {
        // Lưu thông tin Authorities của user vào claims
        Map<String, Object> claims = new HashMap<>();

        // 1. Định nghĩa các claims: issuer, expiration, subject, id
        // 2. Mã hóa token sử dụng thuật toán HS512 và key bí mật
        // 3. Convert thành chuỗi URL an toàn
        // 4. Cộng chuỗi đã sinh ra với tiền tố Bearer
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + duration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

        return PREFIX + token;
    }

    // Lấy thông tin được lưu trong token
    public Claims getClaimsFromToken(String token) {
        // Kiểm tra token có bắt đầu bằng tiền tố
        if (token == null || !token.startsWith(PREFIX)) return null;

        token = token.replace(PREFIX, "");
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
