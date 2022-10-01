package com.company.adapters.student.jpa.repository;

import com.company.adapters.student.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity,Long> {

    @Query(value="select * from student where email=:email",nativeQuery = true)
    public Optional<StudentEntity> findByEmail(@Param("email") String email);

    @Query(value="select * from student where group_id=:group_id",nativeQuery = true)
    public Optional<StudentEntity> findByGroupId(@Param("group_id") Long groupId);
}
