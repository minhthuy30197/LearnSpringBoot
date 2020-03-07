package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s.equals("whoami")) {
            String password = new BCryptPasswordEncoder().encode("123456");
            // Để truy cập vào /profile cần đổi thành ADMIN
            return User.withUsername("whoami").password(password).roles("USER").build();
        } else {
            throw new UsernameNotFoundException(s + " does not exist");
        }
    }
}
