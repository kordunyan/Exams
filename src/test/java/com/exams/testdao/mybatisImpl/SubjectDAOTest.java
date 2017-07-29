package com.exams.testdao.mybatisImpl;

import com.exams.dao.SubjectDAO;
import com.exams.dao.hibernateImpl.SubjectHDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.entity.Subject;

import org.testng.annotations.*;


import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;


public class SubjectDAOTest {

    private SubjectDAO dao;

    @BeforeClass
    public void beforeClass(){
        //this.dao = new SubjectHDAOImpl();
        this.dao = new SubjectMDAOImpl();
        dao.deleteAll();
    }

    @Test
    public void testAddSubject() {
        System.out.println("testAddSubject");
        Long expected = dao.getCount() + 1;
        Subject subject = new Subject("AddSubject");
        dao.addSubject(subject);
        Long actual = dao.getCount();
        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = {Exception.class}, enabled = true)
    public void testMAddSameObject() {
        System.out.println("testMAddSameObject");
        Subject subject = new Subject("SameSubject");
        dao.addSubject(subject);
        subject = new Subject("SameSubject");
        dao.addSubject(subject);
    }

    @BeforeGroups(groups = "withItemGroup")
    public void beforeGetByTitle(){
        System.out.println("Before Method");
        dao.addSubject(new Subject("GetByTitleSubject"));
    }

    @AfterGroups(groups = "withItemGroup")
    public void afterGetByTitle(){
        System.out.println("AFTER Method");
        dao.deleteAll();
    }

    @Test(groups = "withItemGroup")
    public void testGetByTitle() {
        System.out.println("testGetByTitle");
        Subject subject = dao.getByTitle("GetByTitleSubject");
        assertNotNull(subject);
    }

    @Test(groups = "withItemGroup")
    public void testUpdate() {
        System.out.println("testUpdate");
        String updateTitle = "Subject 2";
        Subject subject = dao.getByTitle("GetByTitleSubject");
        subject.setTitle(updateTitle);
        dao.update(subject);
        Subject updSubject = dao.getByTitle(updateTitle);
        assertNotNull(updSubject);
    }

    @BeforeGroups(groups = "deleteGroup")
    public void beforeTestDelete(){
        System.out.println("beforeTestDelete");
        dao.addSubject(new Subject("TestDelete"));
    }

    @Test(groups = "deleteGroup")
    public void testDelete(){
        System.out.println("testDelete");
        Long expected = dao.getCount() - 1;
        Subject subject = dao.getByTitle("TestDelete");
        dao.delete(subject);
        Long actual = dao.getCount();
        assertEquals(expected, actual);
    }
}