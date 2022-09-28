package com.company.auth.dto;
import javax.validation.constraints.NotEmpty;

public class LoginRequest {
    @NotEmpty(message="Cannot be empty")
    private String email;
    @NotEmpty(message="Cannot be empty")
    private String password;
}
