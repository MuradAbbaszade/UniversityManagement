package com.company.auth.controller;

import com.company.auth.dto.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {

    @GetMapping("login")
    public String showLoginForm(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("user", loginRequest);
        return "login";
    }
}
