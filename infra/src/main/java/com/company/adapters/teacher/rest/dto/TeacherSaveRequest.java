package com.company.adapters.teacher.rest.dto;

import com.company.teacher.usecase.SaveTeacher;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public SaveTeacher toUseCase(){
        return SaveTeacher.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
    }
}
