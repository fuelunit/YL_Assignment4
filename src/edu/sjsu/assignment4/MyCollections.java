/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : MyCollections
    Date    : 07/15/2021
 */
package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
     * A public static method to remove every nth element of a collection
     * of employee names (String). The method returns nothing. It uses a
     * list iterator to go over the collection and remove elements.
     *
     * @param employees
     *      A {@code LinkedList} of {@code String}s
     *
     * @param n
     *      An integer index.
     */
    public static void downsize(LinkedList<String> employees, int n) {
        ListIterator<String> iterator = employees.listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % n == 0) {
                iterator.remove();
            }
            index++;
        }

    }

    /**
     * A public static method that checks if a String has balanced
     * parentheses. For simplicity, suppose we only have ( ) and [ ]s,
     * but not { }s. However, it does not verify if the expression is
     * valid.
     *
     * @param expression
     *      An expression {@code String}.
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> charStack = new Stack<Character>();
        Character leftParentheses = '(';
        Character leftBracket = '[';
        Character rightParentheses = ')';
        Character rightBracket = ']';
        /* In a for loop, iterate through each character of the
        expression.
            If it encounters '(' or '[':
                push it to the Stack;
            Else if the iterator points to ')' or ']' and it
            matches the top of the Stack:
                pop the Stack;
            Else if the iterator points to ')' or ']' and does not
            match the top of the Stack:
                return false;
            End if
        End for loop
        Return Stack.isEmpty(): true when it is empty, and false when
        it is not, which means that no corresponding ')' or ']' is
        found.
         */
        for (int i = 0; i < expression.length(); i++) {
            boolean isRightParentheses = rightParentheses.equals(expression.charAt(i));
            boolean isRightBracket = rightBracket.equals(expression.charAt(i));
            if (leftParentheses.equals(expression.charAt(i))) {
                charStack.push(leftParentheses);
            } else if (leftBracket.equals(expression.charAt(i))) {
                charStack.push(leftBracket);
            } else if ((isRightParentheses || isRightBracket) && charStack.isEmpty()) {
                // Imbalanced, return false
                return false;
            } else if ((isRightParentheses && leftParentheses.equals(charStack.peek()))
                    || (isRightBracket && leftBracket.equals(charStack.peek()))) {
                // Matches, therefore pop
                charStack.pop();
            } else if ((isRightParentheses && !leftParentheses.equals(charStack.peek()))
                    || (isRightBracket && !leftBracket.equals(charStack.peek()))) {
                // Imbalanced, return false
                return false;
            }
        }
        return charStack.isEmpty();
    }
}
