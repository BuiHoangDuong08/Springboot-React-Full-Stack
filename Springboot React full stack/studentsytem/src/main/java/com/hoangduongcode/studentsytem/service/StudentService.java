package com.hoangduongcode.studentsytem.service;

import com.hoangduongcode.studentsytem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
    public Student updateStudent(int id, Student newStudent);
    public void deleteStudent(int id);
}
