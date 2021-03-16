package com.example.demo.service;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CourseService {
    List<Course> getListCourse();
}
