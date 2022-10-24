package com.student.java.controller;

import com.student.java.entity.Student;
import com.student.java.entity.Subject;
import com.student.java.entity.enums.Level;
import com.student.java.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/st")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<String> registerStudent(@RequestBody Student st){
        return new ResponseEntity<>(service.registerStudent(st)+"Registered Success",HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @GetMapping("/fail")
    public ResponseEntity<List<Student>> getFailStudent(){
        return new ResponseEntity<>( service.getFailStudent(),HttpStatus.OK);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Student> removeStudentFromSchool(@PathVariable("id") Long id){
        this.service.removeById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateById(@PathVariable("id") Long id, @RequestBody Student student){
        ResponseEntity<String> resp = null;
        boolean up = service.isExist(id);
        if(up){
            service.registerStudent(student);
            resp = new ResponseEntity<>(new String("OK"+student.getId()+"Updated"),HttpStatus.OK);
        }
        else
            resp = new ResponseEntity<>(new String("Fail"+"To Update"),HttpStatus.BAD_REQUEST);

        return resp;
    }
}
