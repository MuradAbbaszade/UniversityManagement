package com.company.adapters.group.jpa.repository;

import com.company.adapters.group.jpa.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupJpaRepository  extends JpaRepository<GroupEntity,Long> {

}
