/*
    Author  : Yipeng Liu
    Project : Assignment 3
    Class   : DesComparator
    Date    : 07/15/2021
 */
package edu.sjsu.assignment4;

import java.util.Comparator;

/**
 * A description comparator for Appointment (Comparator<Appointment>)
 * that will compare the description first, then start date, finally
 * end date. That is, override the compare method.
 */
public class DesComparator implements Comparator<Appointment> {
    /**
     * Overriden compare method for DesComparator that will compare the
     * description first, then start date, finally end date. That is,
     * override the compare method.
     *
     * @param o1
     *      {@code Appointment}
     *
     * @param o2
     *      {@code Appointment}
     *
     * @return
     *      int
     */
    @Override
    public int compare(Appointment o1, Appointment o2) {
        if (!o1.getDescription().equals(o2.getDescription())) {
            return o1.getDescription().compareTo(o2.getDescription());
        } else if (!o1.getStartDate().equals(o2.getStartDate())) {
            return o1.getStartDate().compareTo(o2.getStartDate());
        } else {
            return o1.getEndDate().compareTo(o2.getEndDate());
        }
    }
}
