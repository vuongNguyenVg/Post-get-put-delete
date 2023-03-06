package com.example.service.impl;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
   private StudentRepository studentRepository;

   @Override
   public List<Student> findAll() {
      return this.studentRepository.findAll();
   }

   @Override
   public void save(Student student) {
      this.studentRepository.save(student);
   }

   @Override
   public void deleteById(Integer id) {
      this.studentRepository.deleteById(id);
   }

   @Override
   public Student findById(Integer id) {
      return this.studentRepository.findById(id).orElse(null);
   }
}