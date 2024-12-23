package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public List<Student> setStudentInfo()
	{
		return studentRepository.saveAll(List.of(
				new Student(1,"Sraddha","sraddha@gmail.com",LocalDate.of(1994, Month.DECEMBER, 13)),
				new Student(2,"Sraddha.Saha","sraddha.saha@gmail.com",LocalDate.of(2023, Month.NOVEMBER, 28))));
	}
	
	public Student setStudentInfoFromPathVariable(String name, String email)
	{
		return studentRepository.save(new Student(3,name,email,LocalDate.of(1970, Month.JANUARY, 1)));
	}
	
	public Student setStudentInfoFromRequestParam(String name, String email)
	{
		return studentRepository.save(new Student(4,name,email,LocalDate.of(1980, Month.JANUARY, 1)));
	}

	@Override
	public List<Student> getStudentInfo() {
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudentInfo() {
		studentRepository.deleteAll();
	}

	@Override
	public void deleteStudentInfoById(Integer id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student getStudentInfoFromRequestParam(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudentInfoFromPathVariable(Integer id, String name, String email) {
		Student existingStudent = studentRepository.findById(id).get();
		
		existingStudent.setName(name);
		existingStudent.setEmail(email);
		return studentRepository.save(existingStudent);
	}

	@Override
	public void setStudentInfoFromClient(Student student) {
		Student findStudent = studentRepository.findStudentByEmail(student.getEmail());
		if (findStudent == null)
		{
			studentRepository.save(student);
		}
		else
		{
			throw new IllegalStateException("THE EMAIL IS ALREADY TAKEN");
		}
	}

	@Override
	@Transactional 
	public void updateStudentInfoUsingPostMapping(Integer id, String name, String email) {
		Student existingStudent = studentRepository.findById(id).get();
		
		existingStudent.setName(name);
		existingStudent.setEmail(email);
	}
}
