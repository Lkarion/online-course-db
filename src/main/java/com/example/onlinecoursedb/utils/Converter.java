package com.example.onlinecoursedb.utils;

import com.example.onlinecoursedb.dto.CourseRequestDTO;
import com.example.onlinecoursedb.dto.CourseResponseDTO;
import com.example.onlinecoursedb.entity.Course;
import com.example.onlinecoursedb.entity.CourseInfo;

public class Converter {

    public static CourseResponseDTO convertToDTO(Course course) {

        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .build();
    }
    public static CourseResponseDTO convertToDTOFull(Course course, CourseInfo courseInfo) {

        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .description(courseInfo.getDescription())
                .startsOn(courseInfo.getStartsOn())
                .endsOn(courseInfo.getEndsOn())
                .lecturer(courseInfo.getLecturer())
                .isActive(course.getIsActive())
                .build();
    }
    public static Course convertDTOToCourse(CourseRequestDTO request, CourseInfo courseInfo) {

        return Course.builder()
                .name(request.getName())
                .courseInfo(courseInfo)
                .isActive(true)
                .build();
    }

    public static CourseInfo convertDTOToCourseInfo(CourseRequestDTO request) {

        return CourseInfo.builder()
                .description(request.getDescription())
                .lecturer(request.getLecturer())
                .startsOn(request.getStartsOn())
                .endsOn(request.getEndsOn())
                .build();
    }
}
