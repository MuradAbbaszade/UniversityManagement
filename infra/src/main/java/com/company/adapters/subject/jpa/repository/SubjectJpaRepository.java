package com.company.adapters.subject.jpa.repository;

import com.company.adapters.subject.jpa.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectJpaRepository extends JpaRepository<SubjectEntity,Long> {
}
