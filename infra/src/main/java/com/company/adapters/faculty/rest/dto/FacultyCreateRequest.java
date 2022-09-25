package com.company.adapters.faculty.rest.dto;

import com.company.faculty.usecase.SaveFaculty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyCreateRequest {

    @NotNull
    private Long id;
    @NotNull
    private String name;

    public SaveFaculty toUseCase(){
        return SaveFaculty.builder()
                .id(id)
                .name(name)
                .build();
    }
}
