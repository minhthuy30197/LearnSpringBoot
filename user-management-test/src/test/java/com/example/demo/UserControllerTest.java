package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetListUser() throws Exception {
        // Giả lập userService trả về một List<UserDto>
        List<UserDto> users = new ArrayList<UserDto>();
        users.add(new UserDto(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "img1.jpg", new Date()));
        users.add(new UserDto(2, "Phan Thị Lung Linh", "lunglinh@gmail.com", "0916164946", "img2.jpg", new Date()));
        users.add(new UserDto(3, "Bùi Như Lạc", "laclac@gmail.com", "0946551945", "img3.jpg", new Date()));
        users.add(new UserDto(4, "Đào Bá Đạo", "daobadao@gmail.com", "0156783468", "img4.jpg", new Date()));
        users.add(new UserDto(5, "Nguyễn Thị Rét Mướt", "bangha@gmail.com", "0354684687", "img5.jpg", new Date()));
        Mockito.when(userService.getListUser()).thenReturn(users);

        mvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON)) // Thực hiện GET REQUEST
                .andDo(print())
                .andExpect(status().isOk()) // Mong muốn Server trả về status 200
                .andExpect(jsonPath("$", hasSize(5))) // Hi vọng server trả về List độ dài 5
                .andExpect(jsonPath("$[0].id", is(1))) // Hi vọng phần tử trả về đầu tiên có id = 1
                .andExpect(jsonPath("$[0].name", is("Nguyễn Thị Mộng Mơ"))) // Hi vọng phần tử trả về đầu tiên có tên = "Nguyễn Thị Mộng Mơ"
                .andExpect(jsonPath("$[1].email", is("lunglinh@gmail.com"))); // Hi vọng phần tử trả về thứ hai có email = "lunglinh@gmail.com"
    }

    @Test
    public void testCreateUser() throws Exception {
        CreateUserReq req = new CreateUserReq();
        req.setEmail("mongmo@gmail.com");
        req.setPhone("0987654321");
        req.setPassword("1234");
        req.setName("Nguyễn Thị Mộng Mơ");

        UserDto user = new UserDto(1, "Nguyễn Thị Mộng Mơ", "mongmo@gmail.com", "0987654321", "", null);

        // Giả lập UserService trả về object UserDto khi createUser
        Mockito.when(userService.createUser(any(CreateUserReq.class))).thenReturn(user);

        mvc.perform(post("/users") // Thực hiện POST REQUEST
                .content(asJsonString(req))   // Request gửi đi phải được parse sang JSON
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Mong muốn Server trả về status 200
                .andExpect(jsonPath("$.id", is(1))) // Hi vọng trả về object có id = 1
                .andDo(print()); // Log nội dung request, response để kiểm tra
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
