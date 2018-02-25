package com.school.service;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.school.model.Classroom;
import com.school.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private ClassroomService classroomService;
	private final Map<String, Student> students = new HashMap<>();
	private int counter = 1;
	
	public StudentServiceImpl(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}
	
	@Override
	public String register(String name, Date dob, int standard, char section) {
		Student s=new Student();
		s.setDob(dob);
		s.setName(name);
		Date addmissionDate=new Date();
		s.setAddmissionDate(addmissionDate);
		s.setMarks(new HashMap<String, Integer>());
		String registrationId=String.valueOf(Calendar.getInstance().getWeekYear())+"-"+counter++;
		s.setRegistrationId(registrationId);
		Classroom c=classroomService.find(standard, section);
		s.setClassroom(c);
		c.getStudents().add(s);
		students.put(registrationId, s);
		return registrationId;
	}

	@Override
	public Student find(String registrationNumber) {
		return students.get(registrationNumber);
	}

	@Override
	public void updateMarks(String registrationNumber, String subjectCode, int marks) {
		Student s=students.get(registrationNumber);
		s.getMarks().put(subjectCode, marks);
		
	}

	@Override
	public Iterator<Student> getAll() {
		return students.values().iterator();
	}

}
