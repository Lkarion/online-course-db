package com.example.onlinecoursedb.controller;

import com.example.onlinecoursedb.dto.CourseResponseDTO;
import com.example.onlinecoursedb.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    @Autowired
    private final CourseService courseService;

    @GetMapping("/courses")
    public List<CourseResponseDTO> findCourses(@RequestParam(value = "showAll", required = false) Boolean showAll) {
        return courseService.findCourses(showAll);
    }

    @PutMapping("/courses/{id}/toggle-active")
    public void toggleCourse(@PathVariable(name = "id") Long courseId) {
        courseService.toggleCourse(courseId);
    }
}
