package com.example.onlinecoursedb.service;

import com.example.onlinecoursedb.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    List<CourseResponseDTO> findCourses(Boolean showAll);
    void toggleCourse(Long courseId);
}
