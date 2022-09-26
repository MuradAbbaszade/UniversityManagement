package com.company.teacher.port;

import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.DeleteTeacher;
import com.company.teacher.usecase.RetrieveTeacher;
import com.company.teacher.usecase.SaveTeacher;

public interface TeacherPort {
    Teacher retrieve(RetrieveTeacher retrieveTeacher) throws Exception;
    Teacher delete(DeleteTeacher deleteTeacher) throws Exception;
    Teacher save(SaveTeacher saveTeacher);
}
