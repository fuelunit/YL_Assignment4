/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : AppointmentProgram
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Gives user options to add an appointment, delete an appointment
 * or display all appointments.
 *
 * @author Yipeng Liu
 * @see AppointmentManager
 */
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
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            switch (scanner.nextLine().trim()) {
                case "a":
                    // Get the type
                    System.out.print("Please enter the type (onetime, daily or monthly): ");
                    String type = scanner.nextLine().trim().toLowerCase();
                    // Handle non-supported types
                    if (!type.equals("onetime") && !type.equals("daily") &&
                            !type.equals("monthly")) {
                        System.out.println("Appointment type--" + type + "--is not supported.");
                        System.out.print("Please choose an option: ");
                        break;
                    }
                    // Get description
                    System.out.print("Please enter a description: ");
                    String description = scanner.nextLine().trim();
                    // Get dates
                    LocalDate startDate;
                    LocalDate endDate = null;
                    try {
                        System.out.print("Please enter the starting date (yyyy-mm-dd): ");
                        startDate = LocalDate.parse(scanner.nextLine().trim());
                        if (!type.equals("onetime")) {
                            System.out.print("Please enter the ending date (yyyy-mm-dd): ");
                            endDate = LocalDate.parse(scanner.nextLine().trim());
                            if (endDate.compareTo(startDate) < 0) {
                                throw new DateTimeException("Error: End date comes before start date.");
                            }
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Sorry, the dates you have entered are not valid.");
                        System.out.print("Please choose and option: ");
                        break;
                    } catch (DateTimeException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Please choose and option: ");
                        break;
                    }
                    // A boolean flag to check if an appointment is successfully added.
                    boolean isAdded = false;
                    switch (type) {
                        case "onetime":
                            isAdded = manager.addAnAppointment(
                                    new OnetimeAppointment(description, startDate));
                            break;
                        case "daily":
                            isAdded = manager.addAnAppointment(
                                    new DailyAppointment(description, startDate, endDate));
                            break;
                        case "monthly":
                            isAdded = manager.addAnAppointment(
                                    new MonthlyAppointment(description, startDate, endDate));
                            break;
                        default:
                            break;
                    }
                    if (isAdded) {
                        System.out.println("Appointment added!");
                    } else {
                        System.out.println("Appointment is NOT added!");
                    }
                    System.out.print(prompt);
                    break;
                case "d":
                    System.out.print("Please enter the description of the appointment you want delete: ");
                    String typeLookUp = Appointment.capitalize(scanner.nextLine().trim());
                    while (!manager.deleteAnAppointment(typeLookUp)) {
                        System.out.println("Sorry, appointment not found! please enter again!");
                        System.out.print("Please enter the description of the appointment you want delete: ");
                        typeLookUp = Appointment.capitalize(scanner.nextLine().trim());
                    }
                    System.out.println("Appointment deleted!");
                    System.out.print(prompt);
                    break;
                case "v":
                    if (!manager.isEmpty()) {
                        manager.printAllAppointments();
                    } else {
                        System.out.println("No any appointment now.");
                    }
                    System.out.print(prompt);
                    break;
                case "q":
                    done = true;
                    System.out.println("Thank you for using the program. Have a nice day!");
                    break;
                default:
                    System.out.print("Sorry, wrong option!\nPlease enter again: ");
                    break;
            }
        }
    }
}
