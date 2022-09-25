package com.company.adapters.role.jpa;

import com.company.adapters.role.jpa.entity.RoleEntity;
import com.company.adapters.role.jpa.repository.RoleJpaRepository;
import com.company.role.model.Role;
import com.company.role.port.RolePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleAdapter implements RolePort {

    private final RoleJpaRepository roleJpaRepository;

    @Override
    public Role retrieve(Long id) throws Exception {
        return roleJpaRepository.findById(id)
                .map(RoleEntity::toModel)
                .orElseThrow(() -> new Exception("Role not found"));
    }
}
