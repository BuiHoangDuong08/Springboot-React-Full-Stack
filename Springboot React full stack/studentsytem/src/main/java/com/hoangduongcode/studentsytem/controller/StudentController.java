package com.hoangduongcode.studentsytem.controller;

import com.hoangduongcode.studentsytem.model.Student;
import com.hoangduongcode.studentsytem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")


    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }


}
