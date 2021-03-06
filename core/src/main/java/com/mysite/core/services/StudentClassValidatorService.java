package com.mysite.core.services;

import java.util.List;

public interface StudentClassValidatorService {
	public boolean isClassLimitReached(List l);
	
	public int getPassingMarks(int a);
	

}
