package com.mysite.core.services.impl;


import java.util.List;

import com.mysite.core.services.StudentClassValidatorService;
import com.mysite.core.services.ClassServiceConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;

@Component(service= StudentClassValidatorService.class)
@Designate(ocd= ClassServiceConfiguration.class)
public class StudentClassValidatorServiceImpl implements StudentClassValidatorService {

	private static Logger logger = LoggerFactory.getLogger(StudentClassValidatorServiceImpl.class);
	private int classSize;
	private int marks;
		
	@Activate
	@Modified
	protected void activate(ClassServiceConfiguration config) {
		classSize = config.noOfStudents();
		marks = config.score();
	}
	
	
	@Override
	public boolean isClassLimitReached(List l) {
		if(l.size() >= classSize)
		return true;
		else
			return false;
					
	}

	@Override
	public int getPassingMarks(int a) {
		return marks;
		

}


}
