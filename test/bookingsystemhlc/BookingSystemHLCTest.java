/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abdul
 */
public class BookingSystemHLCTest {

    ArrayList<Coach> coachesAL;
    ArrayList<Student> studentsAL;
    ArrayList<Lessons> lessonsAL;
    ArrayList<Bookings> bookingsAL;
    GraphicsFrame testFrame;
    JPanel panel;
    Student testStudent = new Student("TestStudent", "Street 99", "+44 7700 909090");
    Coach testCoach = new Coach("TestCoach", "Worcester", "+44 7700 909090", new String[]{"TestExpertise"}, "2021-03-04 16:00:00");
    Lessons testLesson = new Lessons("TestLesson", "Swimming Pool", "2021-03-01 15:00:00", testCoach, 3);
    DateTime dt;

    public BookingSystemHLCTest() {
        DataGeneration data = new DataGeneration();
        coachesAL = data.generateCoachData();
        studentsAL = data.generateStudentData();
        lessonsAL = data.generateLessonsData(coachesAL);
        bookingsAL = data.generateBookingsData(studentsAL, lessonsAL, coachesAL);
        testFrame = new GraphicsFrame(coachesAL, studentsAL, lessonsAL, bookingsAL, "Test");
        dt = new DateTime();
    }

    @Test
    public void testStudentLessonSearchByExpertise() {
        int testResult = testFrame.studentLessonSearch("Swimming", "Expertise").size();
        int expectedResult = 12;
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testStudentLessonSearchByCoach() {
        int testResult = testFrame.studentLessonSearch("Negan", "Coach").size();
        int expectedResult = 12;
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testParentCoachSearchByName() {
        int testResult = testFrame.parentCoachSearch("Glenn", "Name").size();
        int expectedResult = 1;
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testParentCoachSearchByExpertise() {

        int testResult = testFrame.parentCoachSearch("Swimming", "Expertise").size();
        int expectedResult = 2;
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testGetBookingSlot() {
        int testResult = dt.getBookingSlot("16:00 - 16:40");
        int expectedResult = 2;
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testGetBookingWeek() {
        int testResult = dt.getBookingWeek("2021-03-06 15:00:00");
        int expectedResult = 1;
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testGetOfficeHourString() {
        String testResult = dt.getOfficeHourString("2021-03-06 17:00:00");
        String expectedResult = "Sat, 2021-03-06 17:00 - 18:00";
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testGetDateTimeString() {
        String testResult = dt.getOfficeHourString("2021-03-01 15:00:00");
        String expectedResult = "Mon, 2021-03-01 15:00 - 16:00";
        assertEquals(expectedResult, testResult);
    }

}
