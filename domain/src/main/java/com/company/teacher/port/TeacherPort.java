package com.company.teacher.port;

import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.DeleteTeacher;
import com.company.teacher.usecase.RetrieveTeacher;
import com.company.teacher.usecase.SaveTeacher;

import java.util.List;

public interface TeacherPort {
    Teacher retrieve(RetrieveTeacher retrieveTeacher) throws Exception;
    List<Teacher> retrieveByEmail(RetrieveTeacher retrieveTeacher) throws Exception;
    Teacher delete(DeleteTeacher deleteTeacher) throws Exception;
    Teacher save(SaveTeacher saveTeacher);
    List<Teacher> retrieveBySubject(RetrieveTeacher retrieveTeacher) throws  Exception;
}
