package com.company.common.usecase;

import com.company.common.model.UseCase;

public interface UseCaseHandler<E,T extends UseCase>{
    E handle(T useCase) throws Exception;
}