package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dress")
public class Dress implements Outfit {
    @Override
    public void wear() {
        System.out.println("Đang mặc váy");
    }
}
