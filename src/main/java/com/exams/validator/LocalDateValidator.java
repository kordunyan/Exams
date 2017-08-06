package com.exams.validator;

import com.exams.exception.IncorectDateException;
import java.time.LocalDate;


/**
 * Created by sanya on 25.07.2017.
 */
public class LocalDateValidator {
	public void vlidate(LocalDate currentDate) throws IncorectDateException {
		LocalDate date = LocalDate.now();
		if(date.isBefore(currentDate)){
			throw new IncorectDateException("This date has not yet come");
		}

		if(date.getYear() != currentDate.getYear()){
			throw new IncorectDateException("This year has already passed");
		}
	}
}
