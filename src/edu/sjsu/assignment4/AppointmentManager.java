/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : AppointmentManager
    Date    : 07/24/2021

    To-do   : - Check if there are other ways to avoid waste of memory
                caused by using description as a key when it is already
                in the Appointment object;
              - Modify the add and delete methods to be case insensitive
              - Add more tests
              - Add print method
                - implement toString() in Appointment and its subclasses
                - how to get the type? -> modify the Appointment
                - order ->
 */
package edu.sjsu.assignment4;

import java.util.TreeMap;

public class AppointmentManager extends TreeMap<String, Appointment> {

    /**
     * A method that can add an appointment to the collection.
     * It should not accept any duplicates. Here, duplicate means
     * two appointments have identical description. That is, even
     * if the appointment has different type, start/end date, as
     * long as the description are the same, they are considered
     * as the same appointment. This also means that, even if two
     * appointments have the same type, same start and end date,
     * as long as the appointments' descriptions are different,
     * they are considered as different appointments.
     *
     * @param appointment
     *      An {@code Appointment}
     *
     * @return
     *      Returns true if appointment is successfully added
     *      to the AppointmentManager, otherwise false.
     */
    public boolean addAnAppointment(Appointment appointment) {
        if (this.isEmpty() || this.containsKey(appointment.getDescription())) {
            this.put(appointment.getDescription(), appointment);
            return true;
        }
        return false;
    }

    /**
     * Deletes an appointment given its description.
     *
     * @param description
     *      {@code String}
     *
     * @return
     *      Returns true if the appointment is successfully
     *      deleted, otherwise false.
     */
    public boolean deleteAnAppointment(String description) {
        if (this.isEmpty() || !this.containsKey(description)) {
            return false;
        }
        this.remove(description);
        return true;
    }

}
