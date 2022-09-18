package com.example.onlinecoursedb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses")

@AllArgsConstructor
@NoArgsConstructor
@Data // why use getter and setter?
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "isActive")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "course_info_id")
    private CourseInfo courseInfo;
}
