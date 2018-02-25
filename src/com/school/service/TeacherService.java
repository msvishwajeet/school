package com.school.service;
import java.util.*;

import com.school.model.Teacher;

public interface TeacherService {
	String register(String name,Date dob);
	Teacher find(String regNumber);
	Iterator<Teacher> getAll();
}
