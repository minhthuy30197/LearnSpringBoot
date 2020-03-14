package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestMockitoExtension {
    @Mock
    List<String> mockList;

    @Test
    public void test() {
        Mockito.when(mockList.size()).thenReturn(2);

        Assert.assertEquals(2, mockList.size());
    }
}
