/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : MyCollectionsTest
    Date    : 07/22/2021
 */
package edu.sjsu.assignment4;


import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.*;

class MyCollectionsTest {
    private final int NUM_OF_FILES = 3;
    private final String FILE1 = "files/file1.txt";
    private final String FILE2 = "files/file2.txt";
    private final String FILE3 = "files/file3.txt";
    private static final String EXPECTED_OUT_1_1 = "Hello, welcome to class!\n" +
            "***\n" +
            "Assignment 4 is posted.\n" +
            "Please submit it before due date.\n" +
            "***\n" +
            "Never cut corners.\n" +
            "***";

    @org.junit.jupiter.api.Test
    void printFiles() {
        // Saving the original output stream
        PrintStream original = System.out;
        // Initializing new output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Setting the new output stream
        System.setOut(new PrintStream(outputStream));
        // Setting up a Queue of files for input fo the test method
        String[] fileStrArr = {FILE1, FILE2, FILE3};
        PriorityQueue<File> filesQueue = new PriorityQueue<File>(NUM_OF_FILES);
        for (int i = 0; i < fileStrArr.length; i++) {
            File currentFile = new File(fileStrArr[i]);
            filesQueue.add(currentFile);
        }
        // Calling the test method
        MyCollections.printFiles(filesQueue);
        // Slicing and joining the actual output
        String[] actual = outputStream.toString().trim().split("\r\n");
        String[] expected = EXPECTED_OUT_1_1.split("\n");
        // Assertion
        Assert.assertEquals(actual, expected);
        // Reverting to the original output stream
        System.setOut(original);
    }

    @org.junit.jupiter.api.Test
    void downsize() {
        // Assignment 4 Part 1.2
        String[] s = {"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        List<String> l = Arrays.asList(s);
        LinkedList<String> e = new LinkedList<>(l);
        System.out.println(e);
        MyCollections.downsize(e, 3);
        System.out.println(e);
    }

    @org.junit.jupiter.api.Test
    void isBalanced() {
    }
}