package com.example.SpringJDBCTemplate.controller;

import com.example.SpringJDBCTemplate.model.Student;
import com.example.SpringJDBCTemplate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.insertStudent(student));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll(){

        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateById(@RequestBody Student student, @PathVariable int id){
        return ResponseEntity.ok(studentService.updateStudentById(student,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        return ResponseEntity.ok(studentService.deleteById(id));
    }

}
