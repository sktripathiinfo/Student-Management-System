package com.studentapp;

import java.nio.channels.NonReadableChannelException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("********** School Management System ********** ");
		System.out.println("********** Welcome ********** ");
		
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
//		System.out.println(s2);
		s2.printStudentinfo();
		
		Student s3 = new Student(25, "kajal", "S-02");
		s2.enrollcource("devops");
//		System.out.println(s3);
		s3.printStudentinfo();
		
		

	}

}
