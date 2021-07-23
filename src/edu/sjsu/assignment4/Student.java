/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : Student
    Date    : 07/20/2021
 */
package edu.sjsu.assignment4;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id) {
        this.id = id;
        this.name = "Unnamed";
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
