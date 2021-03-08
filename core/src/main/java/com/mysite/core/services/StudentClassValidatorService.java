package com.mysite.core.services;

import java.util.List;

public interface StudentClassValidatorService {
	boolean isClassLimitReached(List<Student> studentList);

	int getPassingMarks();
}
