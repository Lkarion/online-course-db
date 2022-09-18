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
public class CourseResponseDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDate startsOn;
    private LocalDate endsOn;
    private String lecturer;
    private Boolean isActive;
}
