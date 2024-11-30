package com.example.SpringJDBCTemplate.service;

import com.example.SpringJDBCTemplate.model.Student;
import com.example.SpringJDBCTemplate.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class StudentService {
    
    @Autowired
    private StudentRepo studentRepo;

    public Student insertStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepo.getById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepo.getAllStudent();
    }

    public Student updateStudentById(Student student, int id) {
        return studentRepo.update(student,id);
    }

    public Object deleteById(int id) {
        return studentRepo.deleteById(id);
    }


}
