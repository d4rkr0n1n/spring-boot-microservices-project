package com.d4rkr0n1n.base.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d4rkr0n1n.base.model.Student;
import com.d4rkr0n1n.base.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  Student student = null;

  @Override
  public Student createStudent() {
    student = new Student();
    student.setName("Test Name");
    student.setPassportNumber("Passport Number");
    studentRepository.save(student);
    return student;
  }

  @Override
  public Student retrieveStudent(Long id) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      student = optionalStudent.get();
    }
    return student;
  }

  @Override
  public Student updateStudent(long id, String name, String passportNumber) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      student = optionalStudent.get();
      student.setName(name);
      student.setPassportNumber(passportNumber);
      studentRepository.save(student);
    }
    return student;
  }

  @Override
  public Student modifyStudent(long id, String name) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      student = optionalStudent.get();
      student.setName(name);
      studentRepository.save(student);
    }
    return student;
  }

  @Override
  public Student deleteStudent(long id) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isPresent()) {
      student = optionalStudent.get();
      studentRepository.deleteById(id);
    }
    return student;
  }

}
