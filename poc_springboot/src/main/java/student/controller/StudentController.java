package student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import student.model.Student;
import student.model.StudentStatus;
import student.service.StudentService;

@CrossOrigin(origins="*")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//list of all students
	@GetMapping("/allstudents")
	public List<Student> getallstudents()
	{
		return studentService.getstudents();
	}
	
	//Single select
	@GetMapping("/findstudent")
	public Optional<Student> getStudent(@RequestParam int sid)
	{
		return studentService.SingleSelect(sid);
	}
	
	//Update Information
	@PutMapping("/upd")
	public StudentStatus UpdStudent(@RequestBody Student updatedStudent)
	{
		return studentService.updateStudent(updatedStudent);
	}
	
	@PostMapping("/ins")
	public StudentStatus insBook(@RequestBody Student insertStudent)
	{
		return studentService.insertBook(insertStudent);
	}
	
	@DeleteMapping("/del")
	public StudentStatus delBook(@RequestParam int id)
	{
		return studentService.deleteStudent(id);
	}
	
	
}
