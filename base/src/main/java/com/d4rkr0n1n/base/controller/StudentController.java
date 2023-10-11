package com.d4rkr0n1n.base.controller;

import com.d4rkr0n1n.base.model.Student;
import com.d4rkr0n1n.base.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

  @Autowired
  StudentService studentService;

  Student student;

  @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Student> createStudent() {
    student = studentService.createStudent();
    return ResponseEntity.status(HttpStatus.CREATED).body(student);
  }

  @GetMapping("/student/{id}")
  public ResponseEntity<Student> retrieveStudent(@PathVariable("id") long id) {
    student = studentService.retrieveStudent(id);
    return getResponsiveEntity();
  }

  @PutMapping("/student/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestParam("name") String name,
      @RequestParam("passportNumber") String passportNumber) {
    student = studentService.updateStudent(id, name, passportNumber);
    return getResponsiveEntity();
  }

  @PatchMapping("/student/{id}")
  public ResponseEntity<Student> modifyStudent(@PathVariable("id") long id, @RequestParam("name") String name) {
    student = studentService.modifyStudent(id, name);
    return getResponsiveEntity();
  }

  @DeleteMapping("/student/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
    student = studentService.deleteStudent(id);
    return getResponsiveEntity();
  }

  private HttpStatus getHttpStatus() {
    return (student != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
  }

  private ResponseEntity<Student> getResponsiveEntity() {
    return ResponseEntity.status(getHttpStatus()).body(student);
  }
}