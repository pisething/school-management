package com.student.java.service;

import com.student.java.entity.Student;
import com.student.java.entity.Subject;
import com.student.java.entity.enums.Level;

import com.student.java.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ModelMapper mapper;
    @Override
    public Student registerStudent(Student sbj) {

        if(sbj.getAverage() <= 100 && sbj.getAverage() > 90){
            sbj.setLevel(Level.A);
        }
        if(sbj.getAverage() <= 90 && sbj.getAverage() > 80){
            sbj.setLevel(Level.B);
        }
        if(sbj.getAverage() <= 80 && sbj.getAverage() > 70){
            sbj.setLevel(Level.C);
        }
        if(sbj.getAverage() <= 70 && sbj.getAverage() > 60){
            sbj.setLevel(Level.D);
        }
        if(sbj.getAverage() <= 60 && sbj.getAverage() > 50){
            sbj.setLevel(Level.E);
        }

        return studentRepository.save(sbj);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void removeById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean isExist(Long id) {
        return studentRepository.existsById(id);
    }


    @Override
    public List<Student> getFailStudent() {
        return studentRepository.findByLevel(Level.F);
    }

}
