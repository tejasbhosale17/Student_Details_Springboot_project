package student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
