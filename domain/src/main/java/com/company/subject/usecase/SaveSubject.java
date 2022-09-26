package com.company.subject.usecase;

import com.company.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveSubject implements UseCase {
    private Long id;
    private String name;
}
