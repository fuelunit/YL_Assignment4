/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : Main
    Date    : 07/15/2021
 */
package edu.sjsu.assignment4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Assignment 4 Part 1.2
	    String[] s = {"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        List<String> l = Arrays.asList(s);
        LinkedList<String> e = new LinkedList<>(l);
        System.out.println(e);
        MyCollections.downsize(e, 3);
        System.out.println(e);
    }
}
