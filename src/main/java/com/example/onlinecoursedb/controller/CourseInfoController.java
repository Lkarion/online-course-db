package com.example.onlinecoursedb.controller;

import com.example.onlinecoursedb.dto.CourseRequestDTO;
import com.example.onlinecoursedb.dto.CourseResponseDTO;
import com.example.onlinecoursedb.service.CourseInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CourseInfoController {

    @Autowired
    private CourseInfoService courseInfoService;

    @PostMapping("/courses")
    public void createCourse(@RequestBody CourseRequestDTO request) {
        courseInfoService.createCourse(request);
    }

    @GetMapping("/courses/{id}")
    public CourseResponseDTO findCourseById(@PathVariable(name = "id") Long courseId) {
        return courseInfoService.findCourseById(courseId);
    }

    @PutMapping("/courses/{id}")
    public CourseResponseDTO updateCourseById(@PathVariable(name = "id") Long courseId,
                                              @RequestBody CourseRequestDTO request) {
        return courseInfoService.updateCourseById(courseId, request);
    }
}
