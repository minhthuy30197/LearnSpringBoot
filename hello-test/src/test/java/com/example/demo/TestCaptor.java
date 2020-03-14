package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestCaptor {
    @Mock
    List<String> mockList;

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    public void testCaptor1() {
        mockList.add("one");

        // Capture lần gọi add vừa rồi có giá trị là gì
        Mockito.verify(mockList).add(captor.capture());

        System.out.println(captor.getAllValues());

        Assert.assertEquals("one", captor.getValue());
    }
}
