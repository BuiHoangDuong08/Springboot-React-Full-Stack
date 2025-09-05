package com.hoangduongcode.studentsytem.service;

import com.hoangduongcode.studentsytem.model.Student;
import com.hoangduongcode.studentsytem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIpml implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(int id, Student newStudent) {
        return studentRepository.findById(id).map(existingStudent ->{

            if (newStudent.getName() != null && !newStudent.getName().isEmpty()) {
                existingStudent.setName(newStudent.getName());
            }


            if (newStudent.getAddress() != null && !newStudent.getAddress().isEmpty()) {
                existingStudent.setAddress(newStudent.getAddress());
            }


            return studentRepository.save(existingStudent);
        }).orElseThrow(()->new RuntimeException("Student not found"));
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);

    }


}
