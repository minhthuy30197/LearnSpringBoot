package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserRequest;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@Api(value = "User APIs")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="Create a user", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserDto user = userService.createUser(createUserRequest);

        return ResponseEntity.ok(user);
    }
}
