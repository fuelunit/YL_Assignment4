/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : MyCollections
    Date    : 07/15/2021
 */
package edu.sjsu.assignment4;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class MyCollections {
    /**
     * Implement a public static method to print a collection of files.
     * The method prints the files from the first to the last. For each file,
     * print its content, then delete it from the collection, so that the next
     * file become the first file. Use 3 consecutive *s to indicate the end of
     * the file content. You can have another method for printing the content
     * for clearer code. (Hint: use a while loop - while the collection is not empty)
     * The parameter should be Collection<File>, where Collection should be a
     * specific type of data structure based on the requirement. And you should use
     * the methods that’s most effective.
     * @param filesQueue
     */
    public static void printFiles(Queue<File> filesQueue) {
        while (!filesQueue.isEmpty()) {
            File current = filesQueue.peek();
            printFile(current);
            filesQueue.poll();
        }
    }

    public static void printFile(File file) {
        // Using scanner
        // while has next line, print next line
        // print *** at last
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
