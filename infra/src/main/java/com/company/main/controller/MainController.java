package com.company.main.controller;

import com.company.student.StudentRetrieveByEmailUseCaseHandler;
import com.company.student.model.Student;
import com.company.student.usecase.RetrieveStudent;
import com.company.teacher.TeacherRetrieveByEmailUseCaseHandler;
import com.company.teacher.model.Teacher;
import com.company.teacher.usecase.RetrieveTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class MainController {

    @Autowired
    @Qualifier("byEmailStudent")
    StudentRetrieveByEmailUseCaseHandler studentRetrieveUseCaseHandler;

    @Autowired
    @Qualifier("byEmailTeacher")
    TeacherRetrieveByEmailUseCaseHandler teacherRetrieveUseCaseHandler;

    @GetMapping("main")
    public String showMainPage(Model model, WebRequest webRequest) throws Exception {
        String email = webRequest.getRemoteUser();
        try {
            Student student = studentRetrieveUseCaseHandler.handle(
                    RetrieveStudent.builder().email(email).build());
            model.addAttribute("loggedInUser",student);
        } catch (Exception e) {
            Teacher teacher = teacherRetrieveUseCaseHandler.handle(
                    RetrieveTeacher.builder().email(email).build());
            model.addAttribute("loggedInUser",teacher);
        }
        return "main";
    }
}
