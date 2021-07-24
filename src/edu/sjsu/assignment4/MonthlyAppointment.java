/*
    Author  : Yipeng Liu
    Project : Assignment 3
    Class   : MonthlyAppointment (Subclass of Appointment)
    Date    : 07/06/2021
 */
package edu.sjsu.assignment4;

import java.time.LocalDate;

public class MonthlyAppointment extends Appointment {
    /**
     * The constructor for MonthlyAppointment
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
    public MonthlyAppointment(String description, LocalDate startDate,
                            LocalDate endDate) {
        super(description, startDate, endDate);
    }

    /**
     * Check if the input is between the start and end date (inclusive)
     * AND the day of the input date is the same as the day of the
     * start date of the appointment.
     *
     * @param date
     *      {@code LocalDate}
     *
     * @return boolean
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return (this.isInBetweenInclusive(this.startDate, this.endDate, date)
                && date.getDayOfMonth() == this.startDate.getDayOfMonth());
    }
}
