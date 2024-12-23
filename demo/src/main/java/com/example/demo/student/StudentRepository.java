package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//	@Query("SELECT s FROM student s WHERE s.email = ?1")
	public Student findStudentByEmail(String email);
}
