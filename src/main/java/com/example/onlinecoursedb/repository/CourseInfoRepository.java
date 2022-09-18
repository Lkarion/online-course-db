package com.example.onlinecoursedb.repository;

import com.example.onlinecoursedb.entity.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {

}
