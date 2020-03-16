package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestJunit {
    @Test
    public void testSum(){
        Assert. assertEquals(3, Integer.sum(1, 2));
    }
}