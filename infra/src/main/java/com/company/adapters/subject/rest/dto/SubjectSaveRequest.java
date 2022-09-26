package com.company.adapters.subject.rest.dto;

import com.company.subject.usecase.SaveSubject;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectSaveRequest {
    @NotNull
    private Long id;
    @NotNull
    private String name;

    public SaveSubject toUseCase(){
        return SaveSubject.builder()
                .id(id)
                .name(name)
                .build();
    }
}
