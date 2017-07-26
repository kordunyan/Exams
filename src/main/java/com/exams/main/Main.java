package com.exams.main;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.entity.mapper.ExamMapper;
import com.exams.entity.mapper.SubjectMapper;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class Main {
	public static void main(String[] args) {
		/*SubjectServiceImpl subjectService = new SubjectServiceImpl();
		ExamServiceImpl service = new ExamServiceImpl();

		Subject subject = subjectService.getByTitle("English");

		System.out.println(service.getAvgBySubjectId(subject.getId()));*/


		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			Subject subject = mapper.selectSubject(1);
			System.out.println(subject);

			Subject subjectPhisics = new Subject();
			subjectPhisics.setTitle("Erithmetic");
			//mapper.insert(subjectPhisics);


			ExamMapper examMapper = session.getMapper(ExamMapper.class);
			Exam exam = examMapper.getById(2);
			System.out.println(exam);
			session.commit();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}