package com.company.teacher.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Teacher {
    private Long id;
    private String name;
    private String surname;
}
