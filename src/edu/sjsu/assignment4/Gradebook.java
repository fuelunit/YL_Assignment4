/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : Gradebook
    Date    : 07/20/2021
 */
package edu.sjsu.assignment4;

import java.util.*;

public class Gradebook extends HashMap<Student, Character> {
    /**
     * Adds a student with the id, name and grade to the map.
     * Before putting it to the map, check if the student already exists.
     * If not, it puts the student to the map and return true;
     * if yes, return false.
     * If the grade is not valid (not A, B, C, D or F), put 'N' instead and return true.
     * A student with the same ID is considered as the same student.
     * If ID is different, but name is the same, it is considered as a different student.
     *
     * @param id
     *      An int for student ID.
     *
     * @param name
     *      A {@code String} representing the name of the student.
     *
     * @param grade
     *      A character for the letter grade.
     *
     * @return
     *      True or false.
     */
    public boolean addStudent(int id, String name, char grade) {
        Student student = new Student(id, name);
        if (!this.containsKey(student) && isValidGrade(grade)) {
            // No matches and valid grade
            this.put(student, grade);
            return true;
        } else if (!this.containsKey(student) && !isValidGrade(grade)) {
            // Invalid grade, setting it to 'N'
            this.put(student, 'N');
            return true;
        } else {
            // Found a match
            return false;
        }
    }

    /**
     * Adds the student with the id and name to the map.
     * But the grade is set to default 'N'.
     *
     * @param id
     *      An int for student ID.
     *
     * @param name
     *      A {@code String} representing the name of the student.
     *
     * @return
     *      True or false.
     */
    public boolean addStudent(int id, String name) {
        return this.addStudent(id, name, 'N');
    }

    /**
     * Adds a {@code Student} to the {@code Gradebook} using
     * an existing {@code Student} object.
     *
     * @param student
     *      A {@code Student} object.
     *
     * @param grade
     *      A character for the letter grade.
     *
     * @return
     *      True or false.
     */
    public boolean addStudent(Student student, char grade) {
        return this.addStudent(student.getId(), student.getName(), grade);
    }

    /**
     * Adds a {@code Student} to the {@code Gradebook} using
     * an existing {@code Student} object, but no letter grade
     * is specified.
     *
     * @param student
     *      A {@code Student} object.
     *
     * @return
     *      True or false.
     */
    public boolean addStudent(Student student) {
        return this.addStudent(student.getId(), student.getName(), 'N');
    }

    /**
     * Deletes the corresponding student with the id from the map.
     *
     * @param student
     *      A {@code Student} object.
     *
     * @return
     *      Returns true if removed successfully; false otherwise.
     */
    public boolean deleteStudent(Student student) {
        if (this.containsKey(student)) {
            this.remove(student);
            return true;
        }
        return false;
    }

    /**
     * Deletes the corresponding student with the id from the map.
     *
     * @param id
     *      An integer for ID.
     *
     * @return
     *      Returns true if removed successfully; false otherwise.
     */
    public boolean deleteStudent(int id) {
        return this.deleteStudent(new Student(id));
    }

    /**
     * A helper method that determines whether a grade is valid
     * or not.
     *
     * @param grade
     *      A character for the letter grade.
     *
     * @return
     *      True if it is valid, vice versa.
     */
    private boolean isValidGrade(char grade) {
        return "ABCDF".contains(String.valueOf(grade));
    }

    /**
     * Prints the students with the grade, and the order is based
     * on the comparator. If the comparator passed in is null,
     * sort by the natural order of student objects.
     * The format will be "id.name: grade" for each student as a line.
     * Note that there's a space between : and grade.
     *
     * @param comparator
     *      A {@code Comparator} for {@code Student}
     */
    public void printGrade(Comparator<Student> comparator) {
        System.out.print(this.toString(comparator));
    }

    /**
     * Prints the students with the grade based on
     * the natural order of student objects.
     * The format will be "id.name: grade" for each
     * student as a line.
     * Note that there's a space between : and grade.
     */
    public void printGrade() {
        this.printGrade(null);
    }

    /**
     * Returns a formatted {@code String} containing the
     * students with the grade, and the order is based
     * on the comparator.
     * If the comparator passed in is null,
     * sort by the natural order of student objects.
     * The format will be "id.name: grade" for each student
     * as a line.
     * Note that there's a space between : and grade.
     *
     * @param comparator
     *      A {@code Comparator} for {@code Student}
     *
     * @return
     *      A {@code String}.
     */
    public String toString(Comparator<Student> comparator) {
        String result = "";
        //Iterator<Student> iterator;
        // Pick a correct key collection to iterate.
        /*
        if (comparator != null) {


            ArrayList<Student> students = new ArrayList<Student>(this.keySet());
            students.sort(comparator);
            iterator = students.listIterator();
        } else {
            iterator = this.keySet().iterator();
        }*/
        TreeSet<Student> set1 = new TreeSet<>(comparator);
        set1.addAll(this.keySet());
        // Iterating through the key collection and concatenate
        // to result.
        for (Student s: set1) {
            result += s.toString() + ": " + this.get(s) + "\n";
        }
        /*
        while (set1.iterator().hasNext()) {
            Student current = iterator.next();
            result += ": " + this.get(current) + "\n";

        }*/
        return result;
    }

    /**
     * Find the corresponding student with a {@code Student} object
     * from the map, and update the grade as newGrade.
     *
     * @param student
     *      A {@code Student} object.
     *
     * @param newGrade
     *      A character for the new letter grade.
     *
     * @return
     *      Returns true if the grade is updated successfully.
     *      Vice Versa.
     */
    public boolean updateGrade(Student student, char newGrade) {
        if (this.containsKey(student) && isValidGrade(newGrade)) {
            this.put(student, newGrade);
            return true;
        }
        return false;
    }

    /**
     * Find the corresponding student with the id from the map,
     * and update the grade as newGrade.
     *
     * @param id
     *      An integer for ID.
     *
     * @param newGrade
     *      A character for the new letter grade.
     *
     * @return
     *      Returns true if the grade is updated successfully.
     *      Vice Versa.
     */
    public boolean updateGrade(int id, char newGrade) {
        return this.updateGrade(new Student(id), newGrade);
    }
}
