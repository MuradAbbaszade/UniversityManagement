package com.company.adapters.group.jpa.repository;

import com.company.adapters.group.jpa.entity.GroupEntity;
import com.company.adapters.subject.jpa.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupJpaRepository  extends JpaRepository<GroupEntity,Long> {
    @Query(value = "select * from group where name=:name",nativeQuery = true)
    public Optional<GroupEntity> findByName(@Param("name") String name);
}
