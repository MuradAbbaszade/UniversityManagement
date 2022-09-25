package com.company.qualification.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveQualification implements UseCase {
    private Long id;
}
