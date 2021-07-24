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
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
