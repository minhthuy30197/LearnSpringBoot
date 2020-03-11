package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user != null) {
            // Tạo mảng GrantedAuthority từ trường role của user
            ArrayList<GrantedAuthority> authorities = getUserAuthority(user);
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User get email " + s + " does not exist.");
        }
    }

    private ArrayList<GrantedAuthority> getUserAuthority(User user) {
        ArrayList<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole()));
        return roles;
    }
}
