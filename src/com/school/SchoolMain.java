package com.school;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.service.ClassroomService;
import com.school.service.ClassroomServiceImpl;
import com.school.service.StudentService;
import com.school.service.StudentServiceImpl;
import com.school.service.SubjectService;
import com.school.service.SubjectServiceImpl;
import com.school.service.TeacherService;
import com.school.service.TeacherServiceImpl;

public class SchoolMain {
	private StudentService studentService;
	private ClassroomService classroomService;
	private TeacherService teacherService;
	private SubjectService subjectService;
	private final Scanner scanner = new Scanner(System.in);
	
	public SchoolMain() {
		this.teacherService = new TeacherServiceImpl();
		SubjectServiceImpl subjectServiceimpl = new SubjectServiceImpl(teacherService,null);
		this.classroomService=new ClassroomServiceImpl(subjectServiceimpl,teacherService);
		subjectServiceimpl.setClassroomService(this.classroomService);
		this.subjectService = subjectServiceimpl;
		this.studentService = new StudentServiceImpl(this.classroomService);
	}
	
	public void start() {
		log("info", "starting program ...");
		// print command instructions to use the app
		System.out.println("1.Create Student");
		System.out.println("2.Create Teacher");
		System.out.println("3.Create Class");
		System.out.println("4.Create New Subject");
		System.out.println("5.Find a student");
		System.out.println("6.Find a Teacher");
		System.out.println("7.print-all student");
		System.out.println("8.print-all student");
		System.out.println("Enter -1 to Exit");
		System.out.print("Enter command Number: ");
		int input = scanner.nextInt();
		while(input!=-1) {
			try {
				executeCommand(input);
			} catch(Exception e) {
				//e.printStackTrace();
				System.out.print("Error - " + e.getMessage());
			}
			System.out.print("Enter command Number: ");
			input = scanner.nextInt();
		}
		log("info", "program stopped");
	}
	
	public void executeCommand(int input) {
		if((input>8)||(input<-1)) {
			System.out.println("please enter valid input.");
			return;
		}
		switch(input) {
		case 1:createStudent();
		case 2:createTeacher();
		case 3:createClass();
		case 4:createSubject();
		case 5:findStudent();
		case 6:findTeacher();
		case 7:printAllStudents();
		case 8:printAllTeacher();
		default : 
			System.out.println("Invalid Input Please enter valid Input");
		}
			/*if(args.length < 2) {
				System.out.println("please enter valid input.");
				return;
			}
			if(args[1].equals("student")) {
				createStudent();
			} else if (args[1].equals("teacher")) {
				createTeacher();
			} else if (args[1].equals("class")) {
				createClass();
			} else if (args[1].equals("subject")) {
				createSubject();
			} */
			/*else {
				System.out.println("please enter valid input.");
			}
			break;
			
		case "print-all":
			if(args.length < 2) {
				System.out.println("please enter valid input.");
				return;
			}
			if(args[1].equals("student")) {
				printAllStudents();
			} else if (args[1].equals("teacher")) {
				printAllTeacher();
			} else {
				System.out.println("please enter valid input.");
			}
			break;
		case "find":
			if(args.length < 2) {
				System.out.println("please enter valid input.");
				return;
			}
			if(args[1].equals("student")) {
				findStudent();
			} else if (args[1].equals("teacher")) {
				findTeacher();
			} else {
				System.out.println("please enter valid input.");
			}
			break;
		default : 
			System.out.println("Invalid Input Please enter valid Input");
		}*/
		if (input==-1) {
			log("info: ", "Program stopped");
			
		}
	}
	
	private void findTeacher() {
		System.out.println("Enter registrationNumber");
		String regNumber=scanner.next();
		Teacher t = this.teacherService.find(regNumber);
		String name = t.getName();
		String rid = t.getRegistrationId();
		Date d=t.getAddmissionDate();
		System.out.println("Name:"+name);
		System.out.println("registration id:"+rid);
		System.out.println("Date of Join:"+d);
		start();
	}

	private void findStudent() {
		System.out.println("Enter registrationNumber");
		String regNumber=scanner.next();
		Student s = this.studentService.find(regNumber);
		String name = s.getName();
		String rid = s.getRegistrationId();
		Date d=s.getAddmissionDate();
		Date d1=s.getDob();
		int standard=s.getClassroom().getStandard();
		char section=s.getClassroom().getSection();
		System.out.println("Name:"+name);
		System.out.println("registration id:"+rid);
		System.out.println("Date of admission:"+d);
		System.out.println("Date of birth:"+d1);
		System.out.println("Standard:"+standard+"-" +section);
		start();
	}

	private void printAllTeacher() {
		final Iterator<Teacher> teachers = this.teacherService.getAll();
		while(teachers.hasNext()) {
			Teacher t = teachers.next();
			System.out.println("\n------------------------------------------------");
			System.out.println("Name: "+t.getName());
			System.out.println("------------------------------------------------");
		}
		start();
	
	}

	private void createSubject() {
		System.out.print("Enter Subject Name:");
		String name = scanner.nextLine();
		System.out.print("Enter TeacherRegNo.:");
		String regNumber = scanner.next();
		System.out.print("Enter TeacherRegNo.:");
		int standard=scanner.nextInt();
		this.subjectService.registerSubject(name, regNumber, standard);
		start();
	}

	private void createClass() {
		System.out.print("Enter Standard of class: ");
		int standard = scanner.nextInt();
		System.out.print("Enter section: ");
		char section = scanner.next().charAt(0);
		String ret=classroomService.createClass(standard, section);
		System.out.println(ret);
		start();
	}

	private void createTeacher() {
		System.out.print("Enter Teacher Name: ");
		String name = scanner.next();
		System.out.print("Enter DOB in dd-MM-YYY: ");
		Date dob;
		try {
			dob=new SimpleDateFormat("dd-MM-yyyy").parse(scanner.next());
		} catch (ParseException e) {
			System.err.println("Enter a Valid date format");
			createTeacher();
			return;
		}
		
		String regNumber=this.teacherService.register(name,dob);
		System.out.println("Teacher successfully registered with Id:"+regNumber);
		start();
	}

	private void createStudent() {
		System.out.print("Enter student name: ");
		String name = scanner.next();
		System.out.print("Enter standard in Number: ");
		int standard = scanner.nextInt();
		System.out.print("Enter section: ");
		char section = scanner.next().charAt(0);
		System.out.print("Enter DOB (dd-MM-yyyy): ");
		Date dob;
		try {
			dob = new SimpleDateFormat("dd-MM-yyyy").parse(scanner.next());
		} catch (ParseException e) {
			log("error", "invalid date entered. - " + e.getMessage());
			System.out.println("Please enter valid DOB");
			createStudent();
			return;
		}
		String registrationNumber = this.studentService.register(name, dob, standard, section);
		System.out.println("Student is registered with registration number: " + registrationNumber);
		start();
	}
	
	private void printAllStudents() {
		final Iterator<Student> students = this.studentService.getAll();
		while(students.hasNext()) {
			Student s = students.next();
			System.out.println("\n------------------------------------------------");
			System.out.println("Name: "+s.getName());
			System.out.println("------------------------------------------------");
		}
		start();
	}
	
	public static void log(String level, String message) {
		System.err.println("LOG::" + level + "::" + message);
	}
	
	public static void main(String[] args) {
		final SchoolMain main = new SchoolMain();
		main.start();
	}
}
