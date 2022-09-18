package com.example.onlinecoursedb.service.impl;

import com.example.onlinecoursedb.dto.CourseResponseDTO;
import com.example.onlinecoursedb.entity.Course;
import com.example.onlinecoursedb.repository.CourseRepository;
import com.example.onlinecoursedb.service.CourseService;
import com.example.onlinecoursedb.utils.Converter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public List<CourseResponseDTO> findCourses(Boolean showAll) {
        if (showAll == null || showAll) {
            return courseRepository.findAll().stream()
                    .map(Converter::convertToDTO)
                    .toList();
        }
        return courseRepository.findAll().stream()
                .filter(Course::getIsActive)
                .map(Converter::convertToDTO)
                .toList();
    }

    public void toggleCourse(Long courseId) {
        var course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        course.setIsActive(!course.getIsActive());
        courseRepository.save(course);
    }
}
