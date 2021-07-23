/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : MyCollections
    Date    : 07/15/2021
 */
package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class MyCollections {
    /**
     * Implements a public static method to print a collection of files.
     * The method prints the files from the first to the last. For each file,
     * this method prints its content, then delete it from the collection,
     * so that the next file becomes the first file. *** is printed to the
     * console to indicate the end of file.
     *
     * @param filesQueue
     *      {@code Queue<File>}: a queue of files
     */
    public static void printFiles(Queue<File> filesQueue) {
        while (!filesQueue.isEmpty()) {
            File current = filesQueue.peek();
            printFile(current);
            filesQueue.poll();
        }
    }

    /**
     * A private helper method that prints one file to the console
     *
     * @param file
     *      A {@code File} object for the input file
     */
    private static void printFile(File file) {
        // Using scanner
        try(Scanner scanner = new Scanner(file)) {
            // while has next line, print next line
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            // print *** at last
            System.out.println("***");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    /**
     *
     * @param employees
     * @param n
     */
    public static void downsize(LinkedList<String> employees, int n) {
        ListIterator<String> iterator = employees.listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % n == 0) {
                iterator.remove();
                index++;
            }
        }

    }


    public static void isBalanced() {

    }
}
