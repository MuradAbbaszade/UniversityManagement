package com.company.main.controller;

import com.company.adapters.role.jpa.RoleAdapter;
import com.company.common.usecase.UseCaseHandler;
import com.company.group.GroupRetrieveUseCaseHandler;
import com.company.group.usecase.RetrieveGroup;
import com.company.main.controller.dto.StudentResponse;
import com.company.main.controller.dto.TeacherResponse;
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

import java.util.List;


@Controller
public class MainController {

    @Autowired
    @Qualifier("byEmailStudent")
    UseCaseHandler<List<Student>,RetrieveStudent> studentRetrieveUseCaseHandler;

    @Autowired
    @Qualifier("byEmailTeacher")
    UseCaseHandler<List<Teacher>,RetrieveTeacher> teacherRetrieveUseCaseHandler;

    @Autowired
    GroupRetrieveUseCaseHandler groupRetrieveUseCaseHandler;

    @Autowired
    RoleAdapter roleAdapter;

    @GetMapping("main")
    public String showMainPage(Model model, WebRequest webRequest) throws Exception {
        String email = webRequest.getRemoteUser();
        try {
            Student student = studentRetrieveUseCaseHandler.handle(
                    RetrieveStudent.builder().email(email).build()).get(0);
            StudentResponse studentResponse =  StudentResponse.builder()
                    .name(student.getName())
                    .surname(student.getSurname())
                    .password(student.getPassword())
                    .email(student.getEmail())
                    .acceptancePoint(student.getAcceptancePoint())
                    .group(groupRetrieveUseCaseHandler.handle(
                            RetrieveGroup.builder().id(student.getGroupId()).build()
                    ))
                    .role(roleAdapter.retrieve(student.getRoleId()))
                    .build();
            model.addAttribute("loggedInUser",studentResponse);
        } catch (Exception e) {
            Teacher teacher = teacherRetrieveUseCaseHandler.handle(
                    RetrieveTeacher.builder().email(email).build()).get(0);
            TeacherResponse teacherResponse = TeacherResponse.builder()
                    .name(teacher.getName())
                    .password(teacher.getPassword())
                    .email(teacher.getEmail())
                    .role(roleAdapter.retrieve(teacher.getId()))
                    .build();
            model.addAttribute("loggedInUser",teacherResponse);
        }
        return "main";
    }
}
