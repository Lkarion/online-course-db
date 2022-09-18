package com.example.onlinecoursedb.service;

import com.example.onlinecoursedb.dto.CourseRequestDTO;
import com.example.onlinecoursedb.dto.CourseResponseDTO;

public interface CourseInfoService {
    void createCourse(CourseRequestDTO request);
    CourseResponseDTO findCourseById(Long courseId);
    CourseResponseDTO updateCourseById(Long courseId, CourseRequestDTO request);

}
