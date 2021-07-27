/*
    Author  : Yipeng Liu
    Project : Assignment 3
    Class   : DailyAppointment (Subclass of Appointment)
    Date    : 07/06/2021
 */
package edu.sjsu.assignment4;

import java.time.LocalDate;

/**
 * A subclass of Appointment
 */
public class DailyAppointment extends Appointment{
    /**
     * The constructor for DailyAppointment
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
    public DailyAppointment(String description, LocalDate startDate,
                            LocalDate endDate) {
        super(description, startDate, endDate);
        this.type = "daily";
    }

    /**
     * Check if the input is between the start and end date (inclusive)
     *
     * @param date
     *      {@code LocalDate}
     *
     * @return boolean
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return (this.isInBetweenInclusive(this.startDate, this.endDate, date));
    }
}
