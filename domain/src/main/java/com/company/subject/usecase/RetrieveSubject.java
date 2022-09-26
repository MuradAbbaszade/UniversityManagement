package com.company.subject.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveSubject implements UseCase {
    private Long id;
}
