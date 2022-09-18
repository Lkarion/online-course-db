package com.example.onlinecoursedb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "course_infos")

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "startsOn")
    private LocalDate startsOn;

    @Column(name = "endsOn")
    private LocalDate endsOn;

    @Column(name = "lecturer")
    private String lecturer;
}
