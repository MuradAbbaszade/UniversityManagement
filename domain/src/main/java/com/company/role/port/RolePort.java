package com.company.role.port;

import com.company.role.model.Role;

public interface RolePort {
    Role retrieve(Long id) throws Exception;
}
