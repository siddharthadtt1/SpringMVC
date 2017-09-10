package org.practice.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"student_name", "age"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

	@JsonProperty(value = "student_name")
	@Size(min = 5, max = 20)
	private String name;

	@NotNull
	private int age;

	@Past
	private Date submissionDate;
	private List<String> skills;

	@Valid
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", submissionDate="
				+ submissionDate + ", skills=" + skills + ", address=" + address
				+ "]";
	}
	
}
