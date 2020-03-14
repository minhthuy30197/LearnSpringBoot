package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class TestMockitoInit {
    @Mock
    List<String> mockList;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        Mockito.when(mockList.size()).thenReturn(2);

        Assert.assertEquals(2, mockList.size());
    }
}
