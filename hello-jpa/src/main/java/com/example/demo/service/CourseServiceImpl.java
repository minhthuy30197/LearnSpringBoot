package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getListCourse() {
        return courseRepository.findAll();
    }
}
