package com.studentapp;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main3 {
	
	private static List<Student> studentList;

	public static void main(String[] args) {
		
		System.out.println("********** School Management System ********** ");
		System.out.println("********** Welcome ********** ");
		
		
		studentList = new ArrayList<Student>();
		
		//Scanner class use to read user input
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Student Name...");
		String name =  scanner.next();
		System.out.println("You have enter the name "+ name );
		
		//
		//read int
		System.out.println("Enter your Age... ");
		int age = scanner.nextInt();
		System.out.println("The student age is "+age);
		
		
		

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
