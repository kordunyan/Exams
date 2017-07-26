package com.exams.validator.impl;


import com.exams.entity.Exam;
import com.exams.validator.Validator;

import java.time.LocalDate;

/**
 * Created by sanya on 25.07.2017.
 */
public class LocalDateValidator implements Validator<LocalDate> {
	@Override
	public boolean vlidate(LocalDate currentDate) {
		LocalDate date = LocalDate.now();
		if(date.isBefore(currentDate)) return false;
		return date.getYear() == currentDate.getYear();
	}
}
