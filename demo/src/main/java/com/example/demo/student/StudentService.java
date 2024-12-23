package com.example.demo.student;

import java.util.List;

public interface StudentService {
	public List<Student> setStudentInfo();
	public List<Student> getStudentInfo();
	public Student setStudentInfoFromPathVariable(String name, String email);
	public Student setStudentInfoFromRequestParam(String name, String email);
	public void deleteStudentInfo();
	public void deleteStudentInfoById(Integer id);
	public Student getStudentInfoFromRequestParam(Integer id);
	public Student updateStudentInfoFromPathVariable(Integer id, String name, String email);
	public void setStudentInfoFromClient(Student student);
	public void updateStudentInfoUsingPostMapping(Integer id, String name, String email);
	
}
