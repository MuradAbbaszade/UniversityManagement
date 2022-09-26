package com.company.adapters.student.rest.dto;

import com.company.student.usecase.SaveStudent;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSaveRequest {

    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private Integer acceptancePoint;
    @NotNull
    private Long groupId;

    public SaveStudent toUseCase(){
        return SaveStudent.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .acceptencePoint(acceptancePoint)
                .groupId(groupId)
                .build();
    }
}
