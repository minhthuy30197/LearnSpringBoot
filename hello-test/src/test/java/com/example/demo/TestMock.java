package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestMock {
    @Mock
    List<String> mockList;

    @Test
    public void test() {
        mockList.add("one");
        Mockito.verify(mockList).add("one");
        Assert.assertEquals(0, mockList.size());
    }
}
