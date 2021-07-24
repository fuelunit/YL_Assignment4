/*
    Author  : Yipeng Liu
    Project : Assignment 3
    Class   : Appointment (Superclass)
    Date    : 07/06/2021
 */
package edu.sjsu.assignment4;

import java.time.LocalDate;

public abstract class Appointment implements Comparable<Appointment> {
    protected String description;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String type;

    /**
     * The constructor for Appointment
     *
     * @param description
     *      {@code String}
     *
     * @param startDate
     *      {@code LocalDate}
     *
     * @param endDate
     *      {@code LocalDate}
     */
    public Appointment(String description, LocalDate startDate,
                       LocalDate endDate) {
        this.description = this.capitalize(description);
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = "appointment";
    }

    /**
     * A helper method that capitalizes the first letter
     * of the {@code String} and force the rest to the lower
     * case.
     *
     * @param inputStr
     *      A raw {@code String}.
     *
     * @return
     *      A  capitalzied {@code String}.
     */
    private String capitalize(String inputStr) {
        return inputStr.substring(0,1).toUpperCase()
                + inputStr.substring(1).toLowerCase();
    }

    /**
     * Gets the description
     * @return A {@code String} description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the startDate
     * @return A {@code LocalDate}
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * Gets the endDate
     * @return A {@code LocalDate}
     */
    public LocalDate getEndDate() {
        return this.endDate;
    }

    /**
     * Gets the appointment type.
     *
     * @return
     *      {@code String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * This is an abstract method.
     *
     * An appointment object can check if it occurs on a date
     * using occursOn method. The detailed algorithm depends
     * on the type of appointment.
     *
     * @param date
     *      {@code LocalDate}
     *
     * @return boolean
     */
    public abstract boolean occursOn(LocalDate date);

    /**
     * Overriden compareTo method orders {@code Appointment} by the
     * start date first, then the end date, finally the description.
     * That is, if the start dates are the same, then compare the
     * end date, and so on
     *
     * @param o
     *      {@code Appointment}
     *
     * @return
     *      int
     */
    @Override
    public int compareTo(Appointment o) {
        if (!this.startDate.equals(o.getStartDate())) {
            return this.startDate.compareTo(o.getStartDate());
        } else if (!this.endDate.equals(o.getEndDate())) {
            return this.endDate.compareTo(o.getEndDate());
        } else {
            return this.description.compareTo(o.getDescription());
        }
    }

    /**
     * Checks if the date to compare (toCompare) is in between
     * startDate and endDate, inclusive.
     *
     * @param startDate
     *      {@code LocalDate} start
     *
     * @param endDate
     *      {@code LocalDate} end
     *
     * @param toCompare
     *      {@code LocalDate} in question
     *
     * @return
     *      Returns true if toCompare is indeed in between,
     *      and vice versa.
     */
    protected boolean isInBetweenInclusive(LocalDate startDate,
                                           LocalDate endDate, LocalDate toCompare) {
        return (toCompare.compareTo(startDate) >= 0
                && toCompare.compareTo(endDate) <= 0);
    }

    /**
     * An overridden toString method
     *
     * @return
     *      An optimized {@code String}.
     */
    @Override
    public String toString() {
        return this.getDescription() + ", from " +
               this.getStartDate().toString() + " to " +
               this.getEndDate().toString() + ", " +
               this.getType();
    }
}
