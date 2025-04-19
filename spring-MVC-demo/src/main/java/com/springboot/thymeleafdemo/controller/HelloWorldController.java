package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return  "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld-process-form";
    }
    @RequestMapping("/processFormVersionTwo")
    public String processFormVersionTwo(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName").toUpperCase();
        String message = "Yo! "+ name;
        model.addAttribute("message", message);
        return "helloworld-process-form-version-two";
    }
}
