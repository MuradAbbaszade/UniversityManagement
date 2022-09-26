package com.company.adapters.teacher.rest.dto;

import com.company.teacher.usecase.SaveTeacher;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherSaveRequest {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    public SaveTeacher toUseCase(){
        return SaveTeacher.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }
}
