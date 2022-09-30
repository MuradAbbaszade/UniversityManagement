package com.company.main.controller.dto;

import com.company.group.model.Group;
import com.company.role.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private String name;
    private String surname;
    private String email;
    private Integer acceptancePoint;
    private Group group;
    private String password;
    private Role role;
}
