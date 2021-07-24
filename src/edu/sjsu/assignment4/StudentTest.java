/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : StudentTest
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    public static final Student STUDENT_0 = new Student(0000, "John Doe");
    public static final Student STUDENT_1 = new Student(0001);
    public static final Student STUDENT_2 = new Student(0647, "Boris Johnson");
    public static final Student STUDENT_3 = new Student(0035, "Joe Biden");
    public static final Student STUDENT_4 = new Student(3004, "Donald Trump");

    @Test
    void compareToTest1() {
        assertTrue(STUDENT_0.compareTo(STUDENT_1) < 0);
    }
    @Test
    void compareToTest2() {
        assertTrue(STUDENT_2.compareTo(STUDENT_1) > 0);
    }
    @Test
    void compareToTest3() {
        assertTrue(STUDENT_3.compareTo(STUDENT_4) < 0);
    }
    @Test
    void compareToTest4() {
        assertTrue(STUDENT_2.compareTo(STUDENT_4) < 0);
    }
    @Test
    void compareToTest5() {
        assertEquals(0, STUDENT_0.compareTo(STUDENT_0));
    }
}