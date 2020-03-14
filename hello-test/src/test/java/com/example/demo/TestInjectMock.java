package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class TestInjectMock {
    @Mock
    DatabaseDriver driver;

    /**
     * Inject driver vào superService.
     * Mọi người có thể liên tưởng nó giống với Spring Injection
     */
    @InjectMocks
    SuperService superService;

    @Test
    public void testInjectMock() {
        // Giả lập cho driver luôn trả về list (3,2,1) khi được gọi tới
        Mockito.doReturn(Arrays.asList(3, 2, 1)).when(driver).getItems();

        Assert.assertEquals(driver, superService.getDriver());

        // Test xem superService trả ra ngoài có đúng không?
        Assert.assertEquals(Arrays.asList(1, 2, 3), superService.getObjects());
    }
}
