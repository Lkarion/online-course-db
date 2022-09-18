package com.example.onlinecoursedb.repository;

import com.example.onlinecoursedb.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAll();
    Optional<Course> findById(Long id);
}
