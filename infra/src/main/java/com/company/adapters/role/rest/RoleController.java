package com.company.adapters.role.rest;

import com.company.adapters.role.jpa.RoleAdapter;
import com.company.role.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleAdapter roleAdapter;

    @GetMapping("{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(roleAdapter.retrieve(id));
    }
}
