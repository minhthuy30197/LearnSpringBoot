package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Dress implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang mặc váy");
    }
}
