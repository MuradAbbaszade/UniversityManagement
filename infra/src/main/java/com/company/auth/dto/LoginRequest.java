package com.company.auth.dto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {
    @NotEmpty(message="Cannot be empty")
    private String email;
    @NotEmpty(message="Cannot be empty")
    private String password;
}
