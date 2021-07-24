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
    private AppointmentManager myManager = new AppointmentManager();
    private LocalDate startDate = LocalDate.parse("2021-06-01");
    private LocalDate endDate = LocalDate.parse("2021-08-05");

    @Test
    void addAnAppointmentTest1() {
        OnetimeAppointment app1 = new OnetimeAppointment("App1", startDate);
        assertTrue(myManager.addAnAppointment(app1));
    }

    @Test
    void deleteAnAppointmentTest1() {
        DailyAppointment app1 = new DailyAppointment("App1", startDate, endDate);
        myManager.addAnAppointment(app1);
        assertTrue(myManager.deleteAnAppointment(app1.getDescription()));
    }

    @Test
    void deleteAnAppointmentTest2() {
        DailyAppointment app1 = new DailyAppointment("App1", startDate, endDate);
        myManager.addAnAppointment(app1);
        MonthlyAppointment app2 = new MonthlyAppointment("App2", startDate, endDate);
        assertFalse(myManager.deleteAnAppointment(app2.getDescription()));
    }

    @Test
    void deleteAnAppointmentTest3() {
        DailyAppointment app1 = new DailyAppointment("App1", startDate, endDate);
        myManager.addAnAppointment(app1);
        MonthlyAppointment app2 = new MonthlyAppointment("aPp1", startDate, endDate);
        assertTrue(myManager.deleteAnAppointment(app2.getDescription()));
    }

    @Test
    void toStringTest() {
        DailyAppointment app1 = new DailyAppointment("App1", startDate, endDate);
        MonthlyAppointment app2 = new MonthlyAppointment("apP2", startDate, endDate);
        myManager.addAnAppointment(app1);
        myManager.addAnAppointment(app2);
        String expected = "App1, from 2021-06-01 to 2021-08-05, daily\n" +
                "App2, from 2021-06-01 to 2021-08-05, monthly\n";
        String actual = myManager.toString();
        assertEquals(expected, actual);
    }
}