package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TestSpy {
    @Test
    public void test() {
        List<String> mockList = Mockito.spy(new ArrayList<String>());

        mockList.add("one");

        Mockito.verify(mockList).add("one");

        Assert.assertEquals(1, mockList.size());

        // Vẫn có thể làm giả thông tin gọi hàm với Spy Object
        Mockito.when(mockList.size()).thenReturn(100);

        Assert.assertEquals(100, mockList.size());
    }
}
