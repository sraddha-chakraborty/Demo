package com.example.demo.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {

	StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//http://localhost:8080/Student/setStudent
	@GetMapping("/setStudent")
	public List<Student> setStudentInfo()
	{
		return studentService.setStudentInfo();
	}
	
	//http://localhost:8080/Student/setStudent/Atty/atty@gmail.com
	@GetMapping("/setStudent/{name}/{email}")
	public Student setStudentInfoFromPathVariable(@PathVariable String name, @PathVariable String email)
	{
		return studentService.setStudentInfoFromPathVariable(name, email);
	}
	
	//http://localhost:8080/Student/setStudent/query?name=Soumi&email=soumi@gmail.com
	@GetMapping("/setStudent/query")
	public Student setStudentInfoFromRequestParam(@RequestParam String name, @RequestParam String email)
	{
		return studentService.setStudentInfoFromRequestParam(name, email);
	}
	
	//http://localhost:8080/Student/getStudent
	@GetMapping("/getStudent")
	public List<Student> getStudentInfo()
	{
		return studentService.getStudentInfo();
	}
	
	//http://localhost:8080/Student/deleteStudent
	@GetMapping("/deleteStudent")
	public void deleteStudentInfo()
	{
		studentService.deleteStudentInfo();
	}
	
	//http://localhost:8080/Student/deleteStudentById/2
	@DeleteMapping("/deleteStudentById/{id}")
	public void deleteStudentInfoById(@PathVariable Integer id)
	{
		studentService.deleteStudentInfoById(id);
	}
	
	//http://localhost:8080/Student/getStudentInfoFromRequestParam/query?id=3
	@GetMapping("/getStudentInfoFromRequestParam/query")
	public Student getStudentInfoFromRequestParam(@RequestParam Integer id)
	{
		return studentService.getStudentInfoFromRequestParam(id);
	}
	
	//http://localhost:8080/Student/updateStudentInfoFromPathVariable/4/Bella/bella@gmail.com
	@GetMapping("/updateStudentInfoFromPathVariable/{id}/{name}/{email}")
	public Student updateStudentInfoFromPathVariable(@PathVariable Integer id,@PathVariable String name, @PathVariable String email)
	{
		return studentService.updateStudentInfoFromPathVariable(id,name,email);
	}
	
	@PostMapping("/setStudentInfoFromClient")
	public void setStudentInfoFromClient(@RequestBody Student student)
	{
		studentService.setStudentInfoFromClient(student);
	}
	
	//http://localhost:8080/Student/updateStudentInfoUsingPostMapping/4?name=Monkey&email=screamingMonkey@gmail.com
	@PutMapping("/updateStudentInfoUsingPostMapping/{id}")
	public void updateStudentInfoUsingPostMapping(@PathVariable Integer id,@RequestParam String name, @RequestParam String email)
	{
		studentService.updateStudentInfoUsingPostMapping(id,name,email);
	}
}
