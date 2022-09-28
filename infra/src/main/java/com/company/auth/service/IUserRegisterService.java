package com.company.auth.service;

import com.company.student.model.Student;
import com.company.teacher.model.Teacher;

public interface IUserRegisterService {
    public Student registerStudent(Student student) throws Exception;
    public Teacher registerTeacher(Teacher teacher) throws Exception;
}
