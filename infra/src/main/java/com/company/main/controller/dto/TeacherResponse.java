package com.company.main.controller.dto;

import com.company.role.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherResponse {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;
}
