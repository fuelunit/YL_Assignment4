/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : GradebookTest
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertTrue(gradebook.updateGrade(0035, 'C'));
    }

    @Test
    void updateGradeTest2() {
        gradebook.addStudent(StudentTest.STUDENT_2, 'B');
        assertFalse(gradebook.updateGrade(0, 'C'));
    }

    @Test
    void printGradeTest() {
        gradebook.addStudent(StudentTest.STUDENT_1, 'B');
        gradebook.addStudent(StudentTest.STUDENT_0, 'A');
        // Saving the original output stream
        PrintStream original = System.out;
        // Initializing new output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Setting the new output stream
        System.setOut(new PrintStream(outputStream));
        // Assertion
        String expected = "0.Unnamed: B\n" +
                "1.John Doe: A\n";
        gradebook.printGrade();
        String actual = outputStream.toString();
        assertEquals(expected, actual);
        // Reverting to the original output stream
        System.setOut(original);
    }
}