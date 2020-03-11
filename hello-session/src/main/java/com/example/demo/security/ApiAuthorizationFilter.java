package com.example.demo.security;

import com.example.demo.model.dto.UserSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ApiAuthorizationFilter extends BasicAuthenticationFilter {

    ApiAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Kiểm tra session
        UserSession userSession = (UserSession) request.getSession().getAttribute("TECHMASTER_SESSION");
        if (userSession == null) {
            chain.doFilter(request, response);
            return;
        }

        // Thêm object Authentication vào SecurityContext
        // Controller có thể lấy ra thông tin user đang đăng nhập từ đây để sử dụng
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(userSession);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(UserSession userSession) {
        // Lấy thông tin userId
        int userId = userSession.getId();

        // Lấy thông tin role
        // Convert role thành mảng GrantedAuthority để authentication manager kiểm tra
        // Trong ví dụ này user chỉ có 1 role
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userSession.getRole());
        authorities.add(authority);

        // Trả về đối tượng Authentication chứa thông tin username, thông tin đăng nhập, tập quyền
        return new UsernamePasswordAuthenticationToken(userId, userSession, authorities);
    }
}
