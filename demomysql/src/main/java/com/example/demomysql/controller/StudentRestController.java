package com.example.demomysql.controller;


import com.example.demomysql.Student.Student;
import com.example.demomysql.logging.Logging;
import com.example.demomysql.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentRestController {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Autowired
    private StudentService studentService;

    @GetMapping(value= "/")
    public List<Student> getAllStudents() {
        logger.info("Success printed all students");
        return studentService.findAll();
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    public Student getStudentByStudentNumber(@PathVariable("studentNumber")Long studentNumber) {
        logger.info("student searched with student number");
        return studentService.findByStudentNumber(studentNumber);
    }

    @GetMapping(value = "/byEmail/{email}")
    public Student getStudentByEmail(@PathVariable("email")String email) {
        logger.info("student searched with email");
        return studentService.findByEmail(email);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student student) {
        studentService.saveOrUpdateStudent(student);
        logger.info("student saved");
        return new ResponseEntity("Student Added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable long studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        logger.info("student saved");
        return new ResponseEntity("Student deleted", HttpStatus.OK);
    }
}

