package com.exams.validator;

import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;


public class SubjectValidator{

	private static final String TITLE_PATTERN = "^[A-Za-z]{3,32}([\\s][A-Za-z]{2,32}){0,1}$";

	public void vlidate(Subject subject) throws IncorectSubjectTitleException {
		if(subject.getTitle() == null || !subject.getTitle().matches(TITLE_PATTERN)){
			throw new IncorectSubjectTitleException("Title must contain between 2 and 35 characters");
		}
	}
}
