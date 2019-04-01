package com.example.demo2.service;

import com.example.demo2.entity.Student;
import com.example.demo2.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student Sel(int id){
        return studentMapper.Sel(id);
    }
}
