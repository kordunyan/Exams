package com.exams.validator;

import com.exams.entity.Subject;
import com.exams.exception.IncorectDateException;
import com.exams.exception.IncorectSubjectTitleException;
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
	public void testValidSubjectValidator(String title) throws IncorectSubjectTitleException {
		new SubjectValidator().vlidate(new Subject(title));
	}

	@Test(expectedExceptions = {IncorectSubjectTitleException.class})
	public void testInvalidSubjectValidator() throws IncorectSubjectTitleException {
		new SubjectValidator().vlidate(new Subject("English language subject"));
	}

	@Test(dataProvider = "invalidLocalDate", expectedExceptions={IncorectDateException.class})
	public void testInvalidLocalDate(LocalDate date) throws IncorectDateException {
		new LocalDateValidator().vlidate(date);
	}

	@Test
	public void testValidLocalDate() throws IncorectDateException {
		new LocalDateValidator().vlidate(LocalDate.now());
	}
}
