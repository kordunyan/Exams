package com.exams.main;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.service.ExamService;
import com.exams.service.PaginationService;
import com.exams.service.SubjectService;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.PaginationServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class Main {

	private static final String FILE_PATH = "examresults.json";

	public static int value = 0;

	public static void main(String[] args) {


		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		SubjectService subjectService = ServiceFactory.getSubjectService();
		ExamService examService = ServiceFactory.getExamService();

		/*List<Subject> subjects = subjectService.getAllWithExams();

		for(Subject subject :  subjects){
			subject.setExams(examService.getBySubjectId(subject.getId(), true));
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (Writer writer = new FileWriter(FILE_PATH)) {
			gson.toJson(subjects, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			List<Subject> subjects = new ArrayList<>();
			Type type = new TypeToken<List<Subject>>() {
			}.getType();
			subjects = gson.fromJson(br, type);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		/*



		long count = subjectService.getcount();
		int pages = subjectService.calculateCountPages(count, SubjectServiceImpl.PER_PAGE);

		System.out.println("Count: " + count);
		System.out.println("Pages: " + pages);

		List<Subject> subjects = subjectService.getFormPage(1, SubjectServiceImpl.PER_PAGE);

		for(Subject subject : subjects){
			System.out.println(subject);
		}
*/


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