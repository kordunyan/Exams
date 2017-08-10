package com.exams.main;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {
	public static void main(String[] args) {


		/*List<Subject> subjects = Arrays.asList(
				new Subject("Subject1", true),
				new Subject("Subject2", true),
				new Subject("Subject3", true),
				new Subject("Subject4", true)
		);
*/
		ServiceFactory.setDataBaseConfig(DatabaseType.TEST);
		SubjectService subjectService = ServiceFactory.getSubjectService();
		ExamService examService = ServiceFactory.getExamService();
		examService.deleteAll();
		subjectService.deleteAll();

		try {
			subjectService.addSubject(new Subject("Java", true));
		} catch (IncorectSubjectTitleException e) {
			e.printStackTrace();
		}

		Subject subject = subjectService.getByTitle("Java");

		System.out.println(subject);

		List<Exam> exams = Arrays.asList(new Exam(15, LocalDate.of(2017, Month.APRIL, 2), null),
				new Exam(10, LocalDate.of(2017, Month.APRIL, 3), null),
				new Exam(11, LocalDate.of(2017, Month.APRIL, 4), null),
				new Exam(9, LocalDate.of(2017, Month.APRIL, 5), null));

		examService.addAll(exams, subject);



		/*String result = gson.toJson(subjects);

		Type type = new TypeToken<List<Subject>>() {
		}.getType();
		List<Subject> subjectsJson = gson.fromJson(result, type);

		for(Subject subject : subjectsJson){
			System.out.println(subject);
			System.out.println(subject.getExams());
		}*/



		//subjectService.insertAll(subjects);


		/*Locale locale = new Locale("ua");

		System.out.println("Locale: "+locale.getDisplayLanguage());

		//ResourceBundle messages = ResourceBundleFactory.getResourceBundle();
		ResourceBundleFactory.setLocale(locale);
		ResourceBundle messages = ResourceBundleFactory.getResourceBundle();


		System.out.println("Головна торіна");

		System.out.println(messages.getString("nav.home"));
		System.out.println(messages.getString("nav.addSubject"));
		System.out.println(messages.getString("nav.grades"));
		System.out.println(messages.getString("nav.database"));
		System.out.println(messages.getString("nav.logout"));*/




		/*ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);


		UserService  userService = ServiceFactory.getUserService();

		User user = new User();
		user.setLogin("admin");
		user.setPassword("12345");

		//userService.addUser(user);

		User search = new User();
		search.setLogin("admin");
		search.setPassword("12345");
		System.out.println(userService.getByLoginAndPassword(search));

		System.out.println(userService.isExists(search));


		SubjectService subjectService = ServiceFactory.getSubjectService();
		ExamService examService = ServiceFactory.getExamService();

		Subject subject = subjectService.getByTitle("Java");

		System.out.println("Count exams: " + examService.getCountBySubject(subject.getId()));

		List<Exam> exams = examService.getExamsForPage(3, ExamServiceImpl.PER_PAGE, subject.getId(), true);
		for(Exam exam : exams){
			System.out.println(exam);
		}
*/

		//List<Exam> exams = examService.

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