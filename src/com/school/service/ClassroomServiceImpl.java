package com.school.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.school.model.Classroom;
import com.school.model.Subject;

public class ClassroomServiceImpl implements ClassroomService{
	private final Map<Integer, List<Classroom>> classrooms = new HashMap<>();
	private SubjectService subjectService;
	private TeacherService teacherService;
	public ClassroomServiceImpl(SubjectService subjectService,TeacherService teacherService) {
		this.subjectService=subjectService;
		this.teacherService = teacherService;
	}
	
	@Override
	public Classroom find(int standard, char section) {
		List<Classroom> cs =classrooms.get(standard);
		for (Classroom classroom : cs) {
			if (classroom.getSection()==section) {
				return classroom;
			}
		}
		return null;
	}

	@Override
	public String createClass(int standard,char section) {
		List<Classroom> cs = classrooms.get(standard);
		if(cs == null) {
			cs = new ArrayList<>();
			classrooms.put(standard, cs);
		} else {
			for(Classroom e : cs) {
				if(e.getSection() == section) {
					throw new RuntimeException("Duplicate Classroom");
				}
			}
		}
		
		Classroom c=new Classroom();
		c.setSection(section);
		c.setStandard(standard);
		c.setStudents(new ArrayList<>());
		List<Subject> subjects = subjectService.getByStandard(standard);
		c.setSubjects(subjects);
		cs.add(c);
		String s=String.valueOf(standard)+"-"+section;
		return s;
	}

	@Override
	public List<Classroom> find(int standard) {
		if(classrooms.containsKey(standard)) {
			return classrooms.get(standard);
		}
		
		return new ArrayList<>();
	}
}
