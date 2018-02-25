package com.school.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.school.model.Classroom;
import com.school.model.Subject;
import com.school.model.Teacher;

public class SubjectServiceImpl implements SubjectService{
	private TeacherService teacherService;
	private ClassroomService classroomService;
	private final Map<String, Subject> subList=new HashMap<>();
	private final int maxMarks=100;
	//************************************************************
	//*************************************************************
	public SubjectServiceImpl(TeacherService teacherService,ClassroomService classroomService) {
		this. teacherService = teacherService;
		this. classroomService =  classroomService;
		
	}
	public void setClassroomService(ClassroomService classroomService) {
		this.classroomService=classroomService;
	}
	@Override
	public void registerSubject(String name, String teacherreg,int standard) {
		final String code = getCode(name, standard);
		if(subList.containsKey(code)) {
			throw new RuntimeException("duplicate subject");
		}
		
		Subject subject=new Subject();
		subject.setCode(code);
		subject.setName(name);
		subject.setMaxMarks(maxMarks);
		subject.setStandard(standard);
		
		if(!"null".equals(teacherreg)) {
			Teacher t=teacherService.find(teacherreg);
			if(t != null) {
				subject.setTeacher(t);
				t.getSubjects().add(subject);
			}
		}
		
		List<Classroom> li=classroomService.find(standard);
		for (Classroom c : li) {
			c.getSubjects().add(subject);
		}
		subList.put(code, subject);
		System.out.println("Successfully Added Subject, Code: "+ code);
	}
	
	private String getCode(String name, int standard) {
		return name + "-" + standard;
	}

	@Override
	public List<Subject> getByStandard(int standard) {
		List<Subject> li=new ArrayList<>();
		Iterator<Subject> itr=subList.values().iterator();
		while (itr.hasNext()) {
			Subject s=itr.next();
			int i=s.getStandard();
			if (i==standard) {
				li.add(s);
			}
		}
		return li;
	}

}
