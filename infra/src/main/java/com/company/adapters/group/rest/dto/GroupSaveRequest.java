package com.company.adapters.group.rest.dto;

import com.company.adapters.qualification.jpa.QualificationAdapter;
import com.company.group.usecase.SaveGroup;
import com.company.qualification.usecase.RetrieveQualification;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class GroupSaveRequest {

    private final QualificationAdapter qualificationAdapter;
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer year;
    @NotNull
    private Long qualificationId;

    public SaveGroup toUseCase() throws Exception {
        return SaveGroup.builder()
                .id(id)
                .name(name)
                .year(year)
                .qualification(qualificationAdapter.retrieve(RetrieveQualification.builder().id(id).build()))
                .build();
    }

}
