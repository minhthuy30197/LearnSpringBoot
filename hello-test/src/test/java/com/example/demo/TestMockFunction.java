package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

public class TestMockFunction {
    @Test
    public void test() {
        List mockList = Mockito.mock(List.class);

        Mockito.when(mockList.size()).thenReturn(2);

        Assert.assertEquals(2, mockList.size());
    }
}
