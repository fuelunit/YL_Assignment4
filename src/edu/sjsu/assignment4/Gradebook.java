/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : Gradebook
    Date    : 07/20/2021
 */
package edu.sjsu.assignment4;

import java.util.HashMap;

public class Gradebook extends HashMap<Student, Character> {
    /**
     * Add a student with the id, name and grade to the map. Before putting it to the map, check if the student already exists. If not, put it to the map and return true; if yes, do NOT put it to the map and return false. If the grade is not valid (not A, B, C, D or F), put 'N' instead and return true.
     * A student with the same ID is considered as the same student. If ID is different, but name is the same, it is considered as a different student. What methods do you need to implement in Student class to achieve this? And do you need to change any logic in the method you already implement?
     * @param id
     * @param name
     * @param grade
     * @return
     */
    public boolean addStudent(int id, String name, char grade) {
        Student student = new Student(id, name);
        if (!this.containsKey(student) && isValidGrade(grade)) {
            return false;
        } else if (isValidGrade(grade)) {
            this.put(student, grade);
            return true;
        }
        return false;
    }

    private boolean isValidGrade(char grade) {
        return "ABCDF".contains(String.valueOf(grade));
    }
}
