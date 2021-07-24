/*
    Author  : Yipeng Liu
    Project : Assignment 4
    Class   : AppointmentManagerTest
    Date    : 07/24/2021
 */
package edu.sjsu.assignment4;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentManagerTest {

    @Test
    void addAnAppointmentTest1() {
        AppointmentManager myManager = new AppointmentManager();
        LocalDate startDate = LocalDate.parse("2021-06-01");
        LocalDate endDate = LocalDate.parse("2021-08-05");
        OnetimeAppointment app1 = new OnetimeAppointment("App1", startDate);
        assertTrue(myManager.addAnAppointment(app1));
    }

    @Test
    void deleteAnAppointmentTest1() {
        AppointmentManager myManager = new AppointmentManager();
        LocalDate startDate = LocalDate.parse("2021-06-01");
        LocalDate endDate = LocalDate.parse("2021-08-05");
        DailyAppointment app1 = new DailyAppointment("App1", startDate, endDate);
        myManager.addAnAppointment(app1);
        assertTrue(myManager.deleteAnAppointment(app1.getDescription()));
    }
}