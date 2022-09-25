package com.company.adapters.qualification.jpa.repository;

import com.company.adapters.qualification.jpa.entity.QualificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationJpaRepository extends JpaRepository<QualificationEntity,Long> {
}
