package com.company.adapters.student.rest.dto;

import com.company.student.usecase.SaveStudent;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Integer acceptancePoint;
    @NotNull
    private Long groupId;
    @NotNull
    private Long roleId;

    public SaveStudent toUseCase(){
        return SaveStudent.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .acceptancePoint(acceptancePoint)
                .groupId(groupId)
                .roleId(roleId)
                .build();
    }
}
