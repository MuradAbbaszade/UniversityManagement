package com.company.group;

import com.company.common.usecase.UseCaseHandler;
import com.company.group.model.Group;
import com.company.group.port.GroupPort;
import com.company.group.usecase.SaveGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GroupSaveUseCaseHandler implements UseCaseHandler<Group, SaveGroup> {

    private final GroupPort groupPort;
    @Override
    public Group handle(SaveGroup useCase) throws Exception {
        return groupPort.save(useCase);
    }
}
