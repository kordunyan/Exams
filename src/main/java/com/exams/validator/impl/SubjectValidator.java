package com.exams.validator.impl;

import com.exams.entity.Subject;
import com.exams.validator.Validator;


/**
 * Created by sanya on 25.07.2017.
 */
public class SubjectValidator implements Validator<Subject> {
	@Override
	public boolean vlidate(Subject subject) {
		return subject.getTitle().matches("^[A-Za-z]{3,}([\\s][A-Za-z]{3,}){0,1}$");
	}
}
