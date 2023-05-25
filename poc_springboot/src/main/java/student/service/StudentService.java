package student.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.dao.StudentDao;
import student.model.Student;
import student.model.StudentStatus;

@Transactional
@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	//show all the students
	public List<Student> getstudents() 
	{
		return studentDao.findAll();
	}
	
	//Show Details to a particular student using his/her PRN
	public Optional<Student> SingleSelect(int sid)
	{
		Optional<Student> b=null;
		if(studentDao.existsById(sid))
		{
			b=studentDao.findById(sid);
		}else
		{
			System.out.println("this id dosen't exists");
		}
		return b;
	}
	
	
	//Registration
	public StudentStatus insertBook(Student insertedstudent)
	{
		StudentStatus studentStatus = new StudentStatus(0,"Insert failed",insertedstudent);
		if(!studentDao.existsById(insertedstudent.getSid()))
		{
			studentDao.save(insertedstudent);
			studentStatus.setStatuscode(1);
			studentStatus.setMsg("Insert Successfull");
		}
		return studentStatus;
	}
	
	public StudentStatus updateStudent(Student updatedstudent)
	{
		StudentStatus studentStatus = new StudentStatus(0,"Update Failed",updatedstudent);
		if(studentDao.existsById(updatedstudent.getSid()))
		{
			studentDao.save(updatedstudent);
			studentStatus.setStatuscode(1);
			studentStatus.setMsg("update Succesfull");
		}
		return studentStatus;
	}
	
	
	public StudentStatus deleteStudent(int id)
	{
		StudentStatus studentStatus = new StudentStatus(0,"delete failed",new Student(0,"n",0,"n"));
		if(studentDao.existsById(id))
		{
			studentDao.deleteById(id);
			studentStatus.setStatuscode(1);
			studentStatus.setMsg("Deleted Successfully");
		}
		return studentStatus;
	}
	
	
	
	
}
