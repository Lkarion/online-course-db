package com.example.onlinecoursedb.service.impl;

import com.example.onlinecoursedb.dto.CourseRequestDTO;
import com.example.onlinecoursedb.dto.CourseResponseDTO;
import com.example.onlinecoursedb.entity.Course;
import com.example.onlinecoursedb.entity.CourseInfo;
import com.example.onlinecoursedb.repository.CourseInfoRepository;
import com.example.onlinecoursedb.repository.CourseRepository;
import com.example.onlinecoursedb.service.CourseInfoService;
import com.example.onlinecoursedb.utils.Converter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class CourseInfoServiceImpl implements CourseInfoService {
    private CourseRepository courseRepository;
    private CourseInfoRepository courseInfoRepository;

    public void createCourse(CourseRequestDTO request) {
        CourseInfo courseInfo = Converter.convertDTOToCourseInfo(request);
        Course course = Converter.convertDTOToCourse(request, courseInfo);
        courseInfoRepository.save(courseInfo);
        courseRepository.save(course);
    }

    public CourseResponseDTO findCourseById(Long courseId) {

        var course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        var courseInfo = course.getCourseInfo();

        return Converter.convertToDTOFull(course, courseInfo);
    }

    public CourseResponseDTO updateCourseById(Long courseId, CourseRequestDTO request) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        CourseInfo courseInfo = course.getCourseInfo();

        course.setName(request.getName());
        courseInfo.setDescription(request.getDescription());
        courseInfo.setLecturer(request.getLecturer());

        courseRepository.save(course);
        courseInfoRepository.save(courseInfo);
        return Converter.convertToDTOFull(course, courseInfo);
    }
}
