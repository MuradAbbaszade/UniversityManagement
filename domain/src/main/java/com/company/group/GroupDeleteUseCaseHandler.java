package com.company.group;

import com.company.common.usecase.UseCaseHandler;
import com.company.group.model.Group;
import com.company.group.port.GroupPort;
import com.company.group.usecase.DeleteGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupDeleteUseCaseHandler implements UseCaseHandler<Group, DeleteGroup> {

    private final GroupPort groupPort;
    @Override
    public Group handle(DeleteGroup useCase) throws Exception {
        return groupPort.delete(useCase);
    }
}
