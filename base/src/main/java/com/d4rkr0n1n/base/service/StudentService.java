package com.d4rkr0n1n.base.service;

import com.d4rkr0n1n.base.model.Student;

public interface StudentService {
  Student createStudent();

  Student retrieveStudent(Long id);

  Student updateStudent(long id, String name, String passportNumber);

  Student modifyStudent(long id, String name);

  Student deleteStudent(long id);
}
