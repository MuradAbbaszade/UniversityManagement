package com.company.group.usecase;

import com.company.common.model.UseCase;
import com.company.qualification.model.Qualification;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveGroup implements UseCase {
    private Long id;
    private String name;
    private Integer year;
    private Qualification qualification;
}
