package com.studentapp;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.management.RuntimeErrorException;

public class Main4 {
	
	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		
		System.out.println("********** School Management System ********** ");
		
		
		
		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		while(true) {
		System.out.println("********** Welcome ********** ");
		
		System.out.println(".....Select an Option.....");
		System.out.println("1. Regester a Student");
		System.out.println("2. Find Student with StudentID");
		System.out.println("3. List all Student information");
		System.out.println("4. List all Student information sorted order");
		System.out.println("5. Exit");
		int option = scanner.nextInt();
		
		switch (option) {
		case 1:
			enrollstudent(scanner);
			
			break;
			
		case 2: findStudentbyId(scanner);
		
		    break;
		    
		case 3: printAllstudentData();
		
		    break;
		    
		    
		case 4: sortByName();
		
		   break;
		   
		case 5:Exit();
			
		

		default: System.out.println("Invalid option Selected ! ...... Enter between 1 to 5 ");
			break;
			
			
		}
		
 }
		
	}

	private static void Exit() {
		System.exit(0);
		
	}

	private static void sortByName() {
		Comparator<Student>studentNameComparator = (o1,o2)-> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}

	private static void printAllstudentData() {
		if(studentList.size()>0) {
		System.out.println("------------ Print All Information ------------");
		for (Student student : studentList) {
			student.printStudentinfo();
		}
		System.out.println("------------ ********** ------------");
		}
		else {
			System.err.println("Student List is Empty!!! No Student Record found" );
		}
	}

	private static void findStudentbyId(Scanner scanner2) {
		Student studentFound = null;     //explicit initialization
		
		System.out.println("Enter the studentId");
		String studentId = scanner2.next();
		try {
			studentFound= studentList
		.stream().filter(student -> student.getStudentID()
		.equalsIgnoreCase(studentId))
        .findFirst()
        .orElseThrow(()-> new RuntimeException("No Data found !!!"));
		
		}
		catch (RuntimeException e) {
			System.err.println("Student with ID "+studentId+"not found!!");
		}
		
		studentFound.printStudentinfo();
		
	}

	private static void enrollstudent(Scanner scanner2) {
		System.out.println("Enter the Student Name");
		String studentName = scanner2.next();
		
		System.out.println("Enter the Student age");
		int studentage = scanner2.nextInt();
		
		System.out.println("Enter the Student StudentId");
		String studentId = scanner2.next();
		
		Student newStudent = new Student(studentage, studentName, studentId);
		studentList.add(newStudent);
		
		System.out.println("Enter the Course to be enrolled!!l...");
		String courseName = scanner2.next();
		while(true) {
			System.out.println("Enter the Course to be enrolled!!l... Type Done to exit");
			String courseName1 = scanner2.next();
			if(courseName1.equalsIgnoreCase("done")) {
				break; // exit from the loop 
			}
			newStudent.enrollcource(courseName1);
			
		}
		newStudent.printStudentinfo();
		
		
		
		
		
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
