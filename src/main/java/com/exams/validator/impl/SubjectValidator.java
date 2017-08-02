package com.exams.validator.impl;

import com.exams.entity.Subject;
import com.exams.validator.Validator;


public class SubjectValidator implements Validator<Subject> {
	@Override
	public boolean vlidate(Subject subject) {
		if(subject.getTitle() == null) return false;
		return subject.getTitle().matches("^[A-Za-z]{3,32}([\\s][A-Za-z]{2,32}){0,1}$");
	}
}
