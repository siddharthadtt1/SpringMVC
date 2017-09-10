package org.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.practice.dto.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RestHomeController {

	// ************************* GET Request *************************
	@RequestMapping(value = "/studentList", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Student> studentList() {

		List<Student> studentList = getStudentList();
		return studentList;

	}

	// ************* GET Request with Path Variables ******************
	@RequestMapping(value = "/student/{name}/{age}")
	public Student student(@PathVariable("name") String name,
			@PathVariable("age") int age) {

		Student student = new Student();
		student.setName(name);
		student.setAge(age);

		return student;
	}

	// ************** Put Request with RequestBody *********************
	@RequestMapping(value = "/putStudent/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Boolean> putStudent(@PathVariable("name") String name,
			@RequestBody Student student) {

		System.out.println("Received information name : " + name
				+ " , student : " + student);

		HttpHeaders headers = new HttpHeaders();
		headers.set("key1", "value1");
		headers.set("key2", "value2");

		return new ResponseEntity<Boolean>(true, headers, HttpStatus.OK);

	}

	// ************************* POST Request *************************
	@RequestMapping(value = "/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Boolean> postStudent(@RequestBody Student student) {

		System.out.println("Student : " + student);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{name}/{age}")
				.buildAndExpand(
						new Object[]{student.getName(), student.getAge()})
				.toUriString());

		return new ResponseEntity<Boolean>(true, headers, HttpStatus.CREATED);
	}

	// ************************* DELETE Request *************************
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteStudent(@RequestBody Student student) {

		System.out.println("Student : " + student);

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);

	}

	private List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		for (int i = 1; i <= 3; i++) {
			Student student = new Student();
			student.setName("Name " + i);
			student.setAge(22 + i);
			studentList.add(student);
		}
		return studentList;
	}

}
