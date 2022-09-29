package com.company.student.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer acceptencePoint;
    private Long groupId;
    private Long roleId;
}
