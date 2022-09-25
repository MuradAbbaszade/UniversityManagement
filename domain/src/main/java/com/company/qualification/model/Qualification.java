package com.company.qualification.model;

import com.company.faculty.model.Faculty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Qualification {
    private Long id;
    private String name;
    private Long facultyId;
}
