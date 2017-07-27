package com.exams.validator;

import com.exams.entity.Subject;
import com.exams.validator.impl.LocalDateValidator;
import com.exams.validator.impl.SubjectValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by sanya on 27.07.2017.
 */
public class ValidatorsTest {


	@DataProvider(name = "subjectTitleDataProvider")
	public Object[][] subjectTitleDataProvider() {
		return new Object[][]{
				{"English"},
				{"English language"}};
	}

	@DataProvider(name="invalidLocalDate")
	public Object[][] invalidLocalDates() {
		LocalDate date = LocalDate.now();
		return new Object[][]{
				{date.minusYears(1)},
				{date.plusDays(1)}
		};
	}

	@Test(dataProvider = "subjectTitleDataProvider")
	public void testValidSubjectValidator(String title) {
		Validator<Subject> validator = new SubjectValidator();
		assertTrue(validator.vlidate(new Subject(title)));
	}

	@Test
	public void testInvalidSubjectValidator() {
		Validator<Subject> validator = new SubjectValidator();
		assertFalse(validator.vlidate(new Subject("English language subject")));
	}

	@Test(dataProvider = "invalidLocalDate")
	public void testInvalidLocalDate(LocalDate date){
		Validator<LocalDate> validator = new LocalDateValidator();
		assertFalse(validator.vlidate(date));
	}

	@Test
	public void testValidLocalDate(){
		Validator<LocalDate> validator = new LocalDateValidator();
		LocalDate date = LocalDate.now();
		date = date.minusDays(1);
		assertTrue(validator.vlidate(date));
	}
}
