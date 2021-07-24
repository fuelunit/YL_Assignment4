/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : AppointmentProgram
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import java.util.Scanner;

public class AppointmentProgram {
    /**
     * Runs the program.
     */
    public static void runProgram() {
        AppointmentManager manager = new AppointmentManager();
        String prompt = "(a) for adding an appointment;\n" +
                "(d) for deleting an appointment;\n" +
                "(v) for viewing all appointments;\n" +
                "(q) for quitting the program\n" +
                "Please choose an option: ";
        boolean done = false;
        while (!done) {
            System.out.print(prompt);
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine().trim()) {
                case "a":
                    System.out.print("Please enter the type (onetime, daily or monthly): ");


                    break;
                case "d":

                    break;
                case "v":

                    break;
                case "q":
                    done = true;
                    break;
                default:
                    System.out.println("Sorry, wrong option! Please try again.");
                    break;
            }
        }
    }
}
