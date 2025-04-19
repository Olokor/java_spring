package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("student")
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @GetMapping ("/showStudentForm")
    public String showStudentForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        System.out.println("student firstName:"+student.getFirstName()+", student lastName:"+student.getLastName());
        return "student-confirmation";

    }
}
