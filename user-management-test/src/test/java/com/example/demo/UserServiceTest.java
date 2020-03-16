package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    /**
     * Đối tượng UserRepository sẽ được mock, chứ không phải bean trong context
     */
    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "mongmo@gmail.com", "0987654321", "123", "Nguyễn Thị Mộng Mơ", "img1.jpg", new Date(), "USER"));
        users.add(new User(2, "lunglinh@gmail.com", "0916164946", "abc", "Phan Thị Lung Linh", "img2.jpg", new Date(), "USER"));
        users.add(new User(3, "laclac@gmail.com", "0946551945", "def", "Bùi Như Lạc", "img3.jpg", new Date(), "USER"));
        users.add(new User(4, "daobadao@gmail.com", "0156783468", "123", "Đào Bá Đạo", "img4.jpg", new Date(), "USER"));
        users.add(new User(5, "bangha@gmail.com", "0354684687", "646", "Nguyễn Thị Rét Mướt", "img5.jpg", new Date(), "USER"));

        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.when(userRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(users.get(0)));
    }

    @Test
    public void testGetListUser() {
        Assert.assertEquals(5, userService.getListUser().size());
    }

    @Test
    public void testGetUserById() {
        Assert.assertEquals("mongmo@gmail.com", userService.getUserById(1).getEmail());
    }
}
