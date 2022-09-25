package com.company.adapters.role.jpa.entity;

import com.company.common.entity.AbstractEntity;
import com.company.role.model.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="role",schema = "public")
public class RoleEntity extends AbstractEntity {
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;

    public Role toModel(){
        return Role.builder()
                .id(super.getId())
                .name(name)
                .build();
    }
}
