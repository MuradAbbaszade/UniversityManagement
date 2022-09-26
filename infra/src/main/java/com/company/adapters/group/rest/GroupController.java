package com.company.adapters.group.rest;

import com.company.common.usecase.UseCaseHandler;
import com.company.group.model.Group;
import com.company.group.usecase.RetrieveGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/group")
@RestController
public class GroupController {

    @Autowired
    UseCaseHandler<Group, RetrieveGroup> groupRetrieveUseCaseHandler;

    @GetMapping("{id}")
    public ResponseEntity<Group> getGroup(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(
                groupRetrieveUseCaseHandler.handle(RetrieveGroup.builder().id(id).build()));
    }
}
