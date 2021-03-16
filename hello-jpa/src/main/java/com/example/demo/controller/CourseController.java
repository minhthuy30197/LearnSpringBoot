package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private  CourseService courseService;

    @ApiOperation(value = "Get list course", response = Course.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code=500,message = "")
    })
    @GetMapping("/courses")
    public ResponseEntity<?> getListUser() {
        List<Course> result = courseService.getListCourse();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
