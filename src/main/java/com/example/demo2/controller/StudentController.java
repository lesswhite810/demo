package com.example.demo2.controller;

import com.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo2")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getStudent/{id}")
    public String getStudent(@PathVariable int id){
        return studentService.Sel(id).toString();
    }
}

