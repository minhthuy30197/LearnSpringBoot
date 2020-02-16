package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dress {
    @PostConstruct
    public void postConstruct(){
        System.out.println("--- Post construct ---");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("--- Pre destroy ---");
    }

    public void wear() {
        System.out.println("Đang mặc váy");
    }
}
