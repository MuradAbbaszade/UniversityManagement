package com.company.adapters.faculty.jpa.repository;

import com.company.adapters.faculty.jpa.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyJpaRepository extends JpaRepository<FacultyEntity,Long> {
}
