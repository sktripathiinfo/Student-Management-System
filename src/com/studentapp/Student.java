package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String StudentID;

	private List<String> cources;

	public Student(int age, String name, String studentID) {
		super();

//		calling ValidateAge Method and passing age method is going to return me true
//      only then i will deal with Initialization 

		if (validateAge(age) && validateName(name) && studentID(studentID)) {
			this.name = name;
			this.age = age;

			StudentID = studentID;
			cources = new ArrayList<String>(); // Initialization of cources!!
		}

	}

	private boolean studentID(String studentId) {

		String studentIdRegexString = "S-\\d+$"; // S-123
		Pattern studentIdPattern = Pattern.compile(studentIdRegexString);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student ID..... Use the format Eg...s-123");
		}

		return false;
	}

	public void enrollcource(String course) {
		if (ValidateCourseName(course)) {

			if (!cources.contains(course)) {
				cources.add(course);
				System.out.println("Student is enrolled to " + course + " Successfully !!");

			} else {
				System.err.println("Student is Already enroll to the course" + course);
			}

		}
	}

	public void printStudentinfo() {

		System.out.println("======= Student Information =======");
		System.out.println("Sudent Name: " + name);
		System.out.println("Sudent age: " + age);
		System.out.println("Sudent id: " + StudentID);
		System.out.println("Enrolled for: " + cources);
	}
//	implemented this two string method to get one line description of the state of the instance variable

	@Override
	public String toString() {
		return "Student [ name=" + name + ",age=" + age + ", StudentID=" + StudentID + ", cources=" + cources + "]";
	}

	// Validation Method

	public boolean validateAge(int age) {
		if (age >= 18 && age <= 35) {
			return true;

		} else {
			System.err.println("Invalid Age !! student age should be between 18 and 35");
			return false;
		}
	}

	// Regex --- student name and studentID validation

	public boolean validateName(String name) {
		// shubham Shubham SHUBHAM
		String nameRegex = "^[a-zA-Z\\s]+$";

		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {

			return true;
		} else {
			System.err.println("The Name you provided is Invalid Name !! , Please enter alphabets only");
			return false;
		}

	}

	public boolean ValidateCourseName(String Course) {

		if (Course.equalsIgnoreCase("Java") || Course.equalsIgnoreCase("DSA") || Course.equalsIgnoreCase("DevOps")) {
			return true;
		}

		else {
			System.err.println("Invalid course !! , Please select valid course from the list[java/dsa/devops]");
			return false;
		}

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return StudentID;
	}

	public List<String> getCources() {
		return cources;
	}

}
