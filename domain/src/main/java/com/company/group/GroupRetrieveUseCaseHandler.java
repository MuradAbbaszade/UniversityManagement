package com.company.group;

import com.company.common.usecase.UseCaseHandler;
import com.company.group.model.Group;
import com.company.group.port.GroupPort;
import com.company.group.usecase.RetrieveGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupRetrieveUseCaseHandler implements UseCaseHandler<Group, RetrieveGroup> {

    private final GroupPort groupPort;
    @Override
    public Group handle(RetrieveGroup useCase) throws Exception {
        return groupPort.retrieve(useCase);
    }
}
