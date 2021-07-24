/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : GradebookTest
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTest {
    public Gradebook gradebook = new Gradebook();

    @Test
    void addStudentTest1() {
        assertTrue(gradebook.addStudent(2, "Jane Doe", 'A'));
    }

    @Test
    void addStudentTest2() {
        assertTrue(gradebook.addStudent(0, "John Doe"));
    }

    @Test
    void addStudentTest3() {
        gradebook.addStudent(0, "John Doe");
        assertFalse(gradebook.addStudent(0, "John Doe", 'A'));
    }

    @Test
    void addStudentTest4() {
        assertTrue(gradebook.addStudent(StudentTest.STUDENT_0, 'A'));
    }

    @Test
    void addStudentTest5() {
        assertEquals(0, this.gradebook.size());
    }

    @Test
    void deleteStudentTest1() {
        this.gradebook.addStudent(StudentTest.STUDENT_0);
        assertTrue(gradebook.deleteStudent(0));
    }

    @Test
    void deleteStudentTest2() {
        this.gradebook.addStudent(StudentTest.STUDENT_4, 'B');
        assertTrue(gradebook.deleteStudent(StudentTest.STUDENT_4));
    }

    @Test
    void updateGradeTest1() {
        gradebook.addStudent(StudentTest.STUDENT_3, 'B');
        //assertTrue(gradebook.updateGrade(3004, 'C'));
        gradebook.updateGrade(3004, 'C');
        0System.out.println(gradebook.get(StudentTest.STUDENT_3));
    }
}