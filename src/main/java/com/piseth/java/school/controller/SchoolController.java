package com.piseth.java.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.piseth.java.school.dto.StudentDto;
import com.piseth.java.school.mapper.StudentMapper;
import com.piseth.java.school.model.Student;
import com.piseth.java.school.model.Subject;
import com.piseth.java.school.model.student.subject.StudentSubject;
import com.piseth.java.school.service.StudentService;
import com.piseth.java.school.service.StudentSubjectService;
import com.piseth.java.school.service.SubjectService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private StudentService service ;
	
	@Autowired
	private StudentSubjectService studentSubjectService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private StudentMapper mapper ;
	
		//1. Save a student 
		@PostMapping("/student/save")
		public ResponseEntity<Student> create(@RequestBody StudentDto studentDto) {
			Student stu =mapper.toStudent(studentDto);
			service.saveStudent(stu);
			return ResponseEntity.ok(stu);
		}
		//2.Search student by Id
		@GetMapping(path = "/student/search")
		public ResponseEntity<Student> searchById(@RequestParam int id){
			return ResponseEntity.ok(service.searchById(id));
		}
		//3.Update student()
		@PutMapping(path ="/student/update")
		public ResponseEntity<Student> updateById(@RequestParam int id,@RequestBody StudentDto studentDto) {
			Student stu=service.updateByID(id, studentDto);
			return ResponseEntity.ok(stu);
		}
		//4. Delete an student
		@RequestMapping(path="/student/delete")
		public ResponseEntity<Student> deleteById(@RequestParam(name = "id") int id){
			Student stu = service.deleteById(id);
			return ResponseEntity.ok(stu);
		}
		//5. show all student
		 @GetMapping("/student/getAll")
		 public ResponseEntity<List<Student>> getAllStudent(){
			return ResponseEntity.ok(service.getListStudent());
		 }
		 
		 //6. Input new subject
		 @PostMapping("/subject/add")
		 public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
			 subjectService.addNew(subject);
			 return ResponseEntity.ok(subject);
		 }
		 
		 //7. List range of student by month
		 @GetMapping("/student/subject/range")
		 public ResponseEntity<List<StudentSubject>> listRangStudent(@RequestParam String month){
			 List<StudentSubject> listStudentSubjects = studentSubjectService.getListStudentByMonth(month);
			 return ResponseEntity.ok(listStudentSubjects);
		 }
		 
		 //8. Show students that fall in class by month
		 public ResponseEntity<List<StudentSubject>> listStudentFall(){
			return null;
			 
		 }
		 //9. Find Student Female that study at 12'A1'
		 

}
