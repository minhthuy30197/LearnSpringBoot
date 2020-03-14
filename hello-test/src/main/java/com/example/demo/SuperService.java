package com.example.demo;

import lombok.Data;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
public class SuperService {
    DatabaseDriver driver;

    public List<Object> getObjects() {
        System.out.println("LOG: Getting objects");
        List<Object> list = driver.getItems();

        System.out.println("LOG: Sorting");
        Collections.sort(list, Comparator.comparingInt(value -> Integer.valueOf(value.toString())));

        System.out.println("LOG: Done");
        return list;
    }
}
