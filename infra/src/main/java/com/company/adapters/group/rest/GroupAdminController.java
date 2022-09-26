package com.company.adapters.group.rest;

import com.company.adapters.group.rest.dto.GroupSaveRequest;
import com.company.common.usecase.UseCaseHandler;
import com.company.group.model.Group;
import com.company.group.usecase.DeleteGroup;
import com.company.group.usecase.RetrieveGroup;
import com.company.group.usecase.SaveGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/group")
@RestController
public class GroupAdminController {

    @Autowired
    UseCaseHandler<Group, SaveGroup> saveGroupUseCaseHandler;

    @Autowired
    UseCaseHandler<Group, DeleteGroup> deleteGroupUseCaseHandler;

    @Autowired
    UseCaseHandler<Group, RetrieveGroup> retrieveGroupUseCaseHandler;

    @PostMapping("delete")
    public ResponseEntity<Group> delete(@RequestParam Long id) throws Exception {
        Group group = retrieveGroupUseCaseHandler.handle(RetrieveGroup.builder().id(id).build());
        deleteGroupUseCaseHandler.handle(DeleteGroup.builder().id(id).build());
        return ResponseEntity.ok(group);
    }
    @PostMapping("save")
    public ResponseEntity<Group> save(@RequestBody GroupSaveRequest groupSaveRequest) throws Exception {
        return ResponseEntity.ok(saveGroupUseCaseHandler.handle(groupSaveRequest.toUseCase()));
    }
}
