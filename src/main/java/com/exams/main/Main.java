package com.exams.main;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		SubjectServiceImpl subjectService = new SubjectServiceImpl();
		ExamServiceImpl examService = new ExamServiceImpl();

		List<Exam> exams = examService.getByCreateDate(LocalDate.of(2017, Month.APRIL, 3));

		for(Exam exam : exams){
			System.out.println(exam.getSubject());
		}


		System.out.println("count : " + subjectService.getcount());


		/*Subject subject = new Subject("Philosofi");
		try {
			subjectService.addSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		//Subject subject = subjectService.getByTitle("Java");
		//System.out.println(subject);
		//subject.setTitle("Philosofi");


		//subjectService.delete(subject);




		//System.out.println(examService.getAvgBySubjectId(1));

		/*Exam exam = new Exam();
		exam.setMark(13);
		exam.setSubject(subject);
		exam.setCreateDate(LocalDate.of(2017, Month.APRIL, 10));*/
		/*try {
			examService.addExam(exam);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		//Exam exam = examService.getById(10);

		//System.out.println(exam);
		//System.out.println(exam.getSubject());


		//System.out.println(examService.getAvgBySubjectId(1));

		/*exam.setMark(10);

		try {
			examService.update(exam);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		//examService.delete(exam);


		/*//Subject subject = subjectService.getByTitle("English");

		System.out.println(service.getAvgBySubjectId(subject.getId()));


		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			Subject subject = mapper.selectSubject(1);
			System.out.println(subject);


			List<Subject> subjects = mapper.findAllSubject();
			for(Subject subject1 : subjects){
				System.out.println(subject1);
			}

			Subject subjectPhisics = new Subject();
			subjectPhisics.setTitle("Erithmetic");
			//mapper.insert(subjectPhisics);


			ExamMapper examMapper = session.getMapper(ExamMapper.class);
			Exam exam = examMapper.getById(2);
			System.out.println(exam);
			System.out.println("Find by subject id");
			List<Exam> exams = examMapper.getBySubjectId(1);
			for(Exam exam1 : exams){
				System.out.println(exam1);
			}


			List<Exam> subjectExams = examMapper.getByDate(LocalDate.of(2017, Month.APRIL, 2));

			for(Exam exam1 : subjectExams){
				System.out.println(exam1.getSubject());
			}



			session.commit();

		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}