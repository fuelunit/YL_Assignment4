/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : AppointmentManager
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import java.util.Iterator;
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
        String tempDes = appointment.getDescription();
        if (!this.containsKey(tempDes)) {
            this.put(tempDes, appointment);
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
        if (!this.containsKey(description)) {
            return false;
        }
        this.remove(description);
        return true;
    }

    /**
     * An overridden toString method.
     *
     * @return
     *      An optimized {@code String}.
     */
    @Override
    public String toString() {
        String result = "";
        Iterator<String> iterator = this.keySet().iterator();
        while (iterator.hasNext()) {
            result += this.get(iterator.next()).toString() + '\n';
        }
        return result;
    }

    /**
     * Prints all appointments to the console with a format.
     */
    public void printAllAppointments() {
        System.out.print(this.toString());
    }
}
