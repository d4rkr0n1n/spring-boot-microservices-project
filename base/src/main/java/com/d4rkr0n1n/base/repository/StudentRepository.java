package com.d4rkr0n1n.base.repository;

import com.d4rkr0n1n.base.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}