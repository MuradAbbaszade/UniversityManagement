package com.company.adapters.student.jpa;

import com.company.adapters.group.jpa.repository.GroupJpaRepository;
import com.company.adapters.role.jpa.repository.RoleJpaRepository;
import com.company.adapters.student.jpa.entity.StudentEntity;
import com.company.adapters.student.jpa.repository.StudentJpaRepository;
import com.company.student.model.Student;
import com.company.student.port.StudentPort;
import com.company.student.usecase.DeleteStudent;
import com.company.student.usecase.RetrieveStudent;
import com.company.student.usecase.SaveStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentAdapter implements StudentPort {

    private final StudentJpaRepository studentJpaRepository;
    private final GroupJpaRepository groupJpaRepository;
    private final RoleJpaRepository roleJpaRepository;
    @Override
    public Student retrieve(RetrieveStudent retrieveStudent) throws Exception {
        return studentJpaRepository.findById(retrieveStudent.getId())
                .map(StudentEntity::toModel)
                .orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public Student retrieveByEmail(RetrieveStudent retrieveStudent) throws Exception {
        return studentJpaRepository.findByEmail(retrieveStudent.getEmail())
                .map(StudentEntity::toModel)
                .orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public Student delete(DeleteStudent deleteStudent) throws Exception {
        Student student = studentJpaRepository.findById(deleteStudent.getId())
                .map(StudentEntity::toModel)
                .orElseThrow(() -> new Exception("Student not found"));
        studentJpaRepository.deleteById(deleteStudent.getId());
        return student;
    }

    @Override
    public Student save(SaveStudent saveStudent) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(saveStudent.getId());
        studentEntity.setName(saveStudent.getName());
        studentEntity.setSurname(saveStudent.getSurname());
        studentEntity.setAcceptancePoint(saveStudent.getAcceptencePoint());
        studentEntity.setGroupEntity(
                groupJpaRepository.findById(saveStudent.getGroupId()).get());
        studentEntity.setEmail(saveStudent.getEmail());
        studentEntity.setPassword(passwordEncoder().encode(saveStudent.getPassword()));
        studentEntity.setRoleEntity(
                roleJpaRepository.findById(saveStudent.getRoleId()).get());
        studentJpaRepository.save(studentEntity);
        return studentEntity.toModel();
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
