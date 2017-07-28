package com.exams.testservice;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.entity.comparator.ExamComparator;
import com.exams.exception.IncorectDateException;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;
import lombok.Data;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ExamServiceTest {

    private SubjectService subjectService;
    private ExamService examService;


    private static List<Exam> examsJavaASC = new ArrayList<>();
    private static List<Exam> examsJavaDesc = new ArrayList<>();
    private static List<Exam> examsEnglish = new ArrayList<>();


    static {
        examsJavaASC.add(new Exam(12, LocalDate.of(2017, Month.APRIL, 2), null));
        examsJavaASC.add(new Exam(14, LocalDate.of(2017, Month.APRIL, 3), null));
        examsJavaASC.add(new Exam(10, LocalDate.of(2017, Month.APRIL, 4), null));

        examsJavaDesc.add(new Exam(10, LocalDate.of(2017, Month.APRIL, 4), null));
        examsJavaDesc.add(new Exam(14, LocalDate.of(2017, Month.APRIL, 3), null));
        examsJavaDesc.add(new Exam(12, LocalDate.of(2017, Month.APRIL, 2), null));

        examsEnglish.add(new Exam(15, LocalDate.of(2017, Month.APRIL, 2), null));
        examsEnglish.add(new Exam(13, LocalDate.of(2017, Month.APRIL, 3), null));
        examsEnglish.add(new Exam(9, LocalDate.of(2017, Month.APRIL, 4), null));
        examsEnglish.add(new Exam(10, LocalDate.of(2017, Month.APRIL, 5), null));
    }

    @BeforeClass
    public void init() {
        subjectService = new SubjectServiceImpl();
        examService = new ExamServiceImpl();
        examService.deleteAll();
        subjectService.deleteAll();

        try {
            subjectService.addSubject(new Subject("Java"));
            subjectService.addSubject(new Subject("English"));

            Subject subject = subjectService.getByTitle("Java");

            for (int i = examsJavaASC.size() - 1; i >= 0; i--) {
                Exam exam = examsJavaASC.get(i);
                exam.setSubject(subject);
                examService.addExam(exam);
            }
            subject = subjectService.getByTitle("English");
            for (int i = examsEnglish.size() - 1; i >= 0; i--) {
                Exam exam = examsEnglish.get(i);
                exam.setSubject(subject);
                examService.addExam(exam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "orderTypes")
    public Object[][] getOrderTypes(){
        return new Object[][] {
                {true, examsJavaASC},
                {false, examsJavaDesc}
        };
    }

    @DataProvider(name="subjectsAVG")
    public Object[][] getSubjectsAVG(){
        return new Object[][] {
                {"Java", 12.0},
                {"English", 11.75}
        };
    }


    @DataProvider(name="invalidLocalDate")
    public Object[][] invalidLocalDates() {
        LocalDate date = LocalDate.now();
        return new Object[][]{
                {date.minusYears(1)},
                {date.plusDays(1)}
        };
    }

    @Test(dataProvider = "orderTypes")
    public void getBySubjectIdOrderAsc(boolean orderType, List<Exam> expected) {
        Subject subject = subjectService.getByTitle("Java");
        List<Exam> actual = examService.getBySubjectId(subject.getId(), orderType);
        assertEquals(actual, expected);
    }


    @Test(dataProvider = "subjectsAVG")
    public void testGetAvgScore(String title, double expected){
        Subject subject = subjectService.getByTitle(title);
        double actual = examService.getAvgBySubjectId(subject.getId());
        assertEquals(actual, expected);
    }

    @Test
    public void testGetByDate(){
        int expected = 2;
        List<Exam> exams = examService.getByCreateDate(LocalDate.of(2017, Month.APRIL, 2));
        int actual = exams.size();
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = {IncorectDateException.class}, dataProvider = "invalidLocalDate")
    public void testAddInvalidDataExam(LocalDate date) throws Exception {
        Subject subject = new Subject();
        subject.setId(1);
        examService.addExam(new Exam(12, date, subject));
    }

    @Test
    public void testAddValidExam() throws Exception {
        Subject subject = subjectService.getByTitle("Java");
        Long expected = examService.getCount() + 1;
        examService.addExam(new Exam(12, LocalDate.now(), subject));
        Long actual = examService.getCount();
        assertEquals(expected, actual);
    }

    @AfterClass
    public void clean() {
        examService.deleteAll();
        subjectService.deleteAll();
    }
}
