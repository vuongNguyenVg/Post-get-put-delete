package com.example.service;

import com.example.entity.Student;

import java.util.List;

public interface StudentService {

   List<Student> findAll();

   void save(Student student);

   void deleteById(Integer id);

   Student findById(Integer id);
}
