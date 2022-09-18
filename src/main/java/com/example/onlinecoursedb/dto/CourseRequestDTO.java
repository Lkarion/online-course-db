package com.example.onlinecoursedb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseRequestDTO {

    private String name;
    private String description;
    private String lecturer;
    private LocalDate startsOn;
    private LocalDate endsOn;
}
