package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        List<UserDto> result = userService.getListUser();

        model.addAttribute("users", result);
        return "index";
    }
}
