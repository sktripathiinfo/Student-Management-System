package com.studentapp;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Main2 {
	
	private static List<Student> studentList;

	public static void main(String[] args) {
		
		System.out.println("********** School Management System ********** ");
		System.out.println("********** Welcome ********** ");
		
		
		studentList = new ArrayList<Student>();
		
		
		
		Student s1 ;
//		s1 = new Student(122,"shubham", "Java");        #invalid age =122
		
		//Valid age input
		s1 = new Student(23,"shubham", "S-12"); 
		
		s1.enrollcource("java");
		s1.enrollcource("devops");
		s1.enrollcource("dsa");
		s1.enrollcource("c#");
		
//		System.out.println(s1);       
		
		s1.printStudentinfo();
		
		
		Student s2 = new Student(25, "shubham pandey", "S-03");
		s2.enrollcource("dsa");

		
		Student s3 = new Student(25, "kajal", "S-02");
		s2.enrollcource("devops");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		Student result =  findStudentbyId("S-13");
		System.out.println("Result " + result);

	}

	public static Student findStudentbyId(String studentId) {
		
		Student result = null;     //explicit initialization
		try {
		result= studentList
		.stream().filter(x -> x.getStudentID()
		.equalsIgnoreCase(studentId))
        .findFirst()
        .orElseThrow(()-> new RuntimeException("No Data found !!!"));
		
		}
		catch (RuntimeException e) {
			System.err.println("Student with ID "+studentId+"not found!!");
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
}
