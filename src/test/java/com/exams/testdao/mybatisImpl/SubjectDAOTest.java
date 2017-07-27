package com.exams.testdao.mybatisImpl;

import com.exams.dao.SubjectDAO;
import com.exams.dao.hibernateImpl.SubjectHDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.entity.Subject;

import org.apache.ibatis.exceptions.PersistenceException;
import org.testng.annotations.*;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;


public class SubjectDAOTest {

    private SubjectDAO dao;

    @BeforeClass
    public void beforeClass(){
        this.dao = new SubjectHDAOImpl();
        //this.dao = new SubjectMDAOImpl();
        dao.deleteAll();
    }

    @Test
    public void testAddSubject() {
        Long expected = dao.getCount() + 1;
        Subject subject = new Subject("AddSubject");
        dao.addSubject(subject);
        Long actual = dao.getCount();
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = {Exception.class}, enabled = false)
    public void testMAddSameObject() {
        Subject subject = new Subject("SameSubject");
        dao.addSubject(subject);
        subject = new Subject("SameSubject");
        dao.addSubject(subject);
    }


    @BeforeGroups(groups = "withItemGroup")
    public void beforeGetByTitle(){
        dao.addSubject(new Subject("GetByTitleSubject"));
    }

    @AfterGroups(groups = "withItemGroup")
    public void afterGetByTitle(){
        Subject subject = dao.getByTitle("GetByTitleSubject");
        dao.delete(subject);
    }

    @Test(groups = "withItemGroup")
    public void testGetByTitle() {
        Subject subject = dao.getByTitle("GetByTitleSubject");
        assertNotNull(subject);
    }

    @Test(groups = "withItemGroup")
    public void testUpdate() {
        String updateTitle = "Subject 2";
        Subject subject = dao.getByTitle("GetByTitleSubject");
        subject.setTitle(updateTitle);
        dao.update(subject);
        Subject updSubject = dao.getByTitle(updateTitle);
        assertNotNull(updSubject);
    }

    @BeforeGroups(groups = "deleteGroup")
    public void beforeTestDelete(){
        dao.addSubject(new Subject("TestDelete"));
    }

    @Test(groups = "deleteGroup")
    public void testDelete(){
        Long count = dao.getCount() - 1;
        Subject subject = dao.getByTitle("TestDelete");
        dao.delete(subject);
        assertEquals(count, dao.getCount());
    }
}