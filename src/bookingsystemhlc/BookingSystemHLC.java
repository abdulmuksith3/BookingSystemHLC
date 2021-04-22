/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author abdul
 */
public class BookingSystemHLC {

    public static void main(String[] args) {

        DataGeneration data = new DataGeneration();
        ArrayList<Coach> coachesAL = data.generateCoachData();
        ArrayList<Student> studentsAL = data.generateStudentData();
        ArrayList<Lessons> lessonsAL = data.generateLessonsData(coachesAL);
        ArrayList<Bookings> bookingsAL = data.generateBookingsData(studentsAL, lessonsAL, coachesAL);


        GraphicsFrame frame = new GraphicsFrame(coachesAL, studentsAL, lessonsAL, bookingsAL);
    
}}
