package com.example.SpringJDBCTemplate.repository;

import com.example.SpringJDBCTemplate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Student save(Student student) {
        String query="insert into student(name,age,address) values (?,?,?)";
        jdbcTemplate.update(query,student.getName(),student.getAge(),student.getAddress());
        return student;
    }

    public Student getById(int id) {
        String query="select * from student where id=?";
        return jdbcTemplate.queryForObject(query,new StudentRowMapper(),id);
    }

    public List<Student> getAllStudent() {
        String query="select * from student";
        return jdbcTemplate.query(query,new StudentRowMapper());
    }

    public Student update(Student student, int id) {
        String query="update student set name=?,age=?,address=? where id=?";
        jdbcTemplate.update(query, student.getName(), student.getAge(), student.getAddress(), id );
        return student;
    }


    public Object deleteById(int id) {
        String query="delete from student where id=?";
        jdbcTemplate.update(query,id);
        return "Id with student id " +id+" deleted Successfully ";
    }
}
