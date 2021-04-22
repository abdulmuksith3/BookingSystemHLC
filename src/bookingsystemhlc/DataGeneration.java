/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import java.util.ArrayList;
import java.util.Random;

public class DataGeneration {

    public static ArrayList<Coach> generateCoachData() {
        //        Coach(String fullName, String address, String telephoneNo, String[] expertise, String officeHour)        
        //        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
        //        Coach rick = new Coach("Rick Grimes", "Hereford", "+44 7700 900140",null, LocalDateTime.of(2021,Month.MARCH,1,4,30).format(myFormatObj));

        ArrayList<Coach> coachList = new ArrayList<Coach>();

        Coach coach1 = new Coach("Rick Grimes", "Hereford", "+44 7700 900110", new String[]{"Swimming", "Badminton"}, "2021-03-01 16:00:00");
        coachList.add(coach1);

        Coach coach2 = new Coach("Glenn Rhee", "Wells", "+44 7700 900120", new String[]{"Gymnastics", "Tennis"}, "2021-03-02 17:00:00");
        coachList.add(coach2);

        Coach coach3 = new Coach("Negan ", "Southampton", "+44 7700 900130", new String[]{"Cricket", "Football"}, "2021-03-03 17:00:00");
        coachList.add(coach3);

        Coach coach4 = new Coach("Daryl Dixon", "Cambridge", "+44 7700 900140", new String[]{"Archery"}, "2021-03-04 15:00:00");
        coachList.add(coach4);

        Coach coach5 = new Coach("Maggie Greene", "Worcester", "+44 7700 900150", new String[]{"Tennis"}, "2021-03-05 18:00:00");
        coachList.add(coach5);

        Coach coach6 = new Coach("Michonne", "Hereford", "+44 7700 900160", new String[]{"Swimming", "Gymnastics"}, "2021-03-05 17:00:00");
        coachList.add(coach6);

        Coach coach7 = new Coach("Rosita Espinosa", "Worcester", "+44 7700 900170", new String[]{"Fencing"}, "2021-03-04 16:00:00");
        coachList.add(coach7);

        return coachList;

    }

    public static ArrayList<Student> generateStudentData() {
        //        Student(String fullName, String address, String telephoneNo

        ArrayList<Student> studentAL = new ArrayList<Student>();

        Student student1 = new Student("Herby Stansell", "3rd Parkway", "+44 7700 900111");
        studentAL.add(student1);

        Student student2 = new Student("Sophi Broadbear", "Kedzie Junction", "+44 7700 900220");
        studentAL.add(student2);

        Student student3 = new Student("Andres Ughini", "Myrtle Terrace", "+44 7700 900330");
        studentAL.add(student3);

        Student student4 = new Student("Sarette Mintram", "Sachs Way", "+44 7700 900440");
        studentAL.add(student4);

        Student student5 = new Student("Trent Eilhermann", "Loeprich Point", "+44 7700 900550");
        studentAL.add(student5);

        Student student6 = new Student("Janet McCosker", "", "+44 7700 900660");
        studentAL.add(student6);

        Student student7 = new Student("Mortie Fenlon", "Grover Way", "+44 7700 900770");
        studentAL.add(student7);

        Student student8 = new Student("Maurice Ritchley", "Sachs Circle", "+44 7700 900880");
        studentAL.add(student8);

        Student student9 = new Student("Rainer Naile", "Summer Ridge Road", "+44 7700 900990");
        studentAL.add(student9);

        Student student10 = new Student("Lindon Chessil", "Nancy Center", "+44 7700 900890");
        studentAL.add(student10);

        Student student11 = new Student("Reeta Staite", "Macpherson Junction", "+44 7700 900790");
        studentAL.add(student11);

        Student student12 = new Student("Jenna Trahearn", "Canary Street", "+44 7700 900590");
        studentAL.add(student12);

        Student student13 = new Student("Christine Jardine", "Jenna Center", "+44 7700 900450");
        studentAL.add(student13);

        Student student14 = new Student("Domeniga Guillon", "Menomonie Point", "+44 7700 900650");
        studentAL.add(student14);

        Student student15 = new Student("Leon Pettit", "Ridgeview Point", "+44 7700 900150");
        studentAL.add(student15);

        Student student16 = new Student("Abdul", "Ridgeview Point", "+44 7700 3701380");
        studentAL.add(student16);

        return studentAL;
    }

    public static ArrayList<Lessons> generateLessonsData(ArrayList<Coach> coachesAL) {
        //        Lessons(String name, String place, String dateTime, Coach coach, int capacity)  

        ArrayList<Lessons> lessonsAL = new ArrayList<Lessons>();

        GraphicsFrame f = new GraphicsFrame();
        DateTime dt = new DateTime();

        for (int i = 0; i < 4; i++) {

            Lessons lesson1 = new Lessons("Swimming", "Swimming Pool", dt.getOfficeHourLongDate("2021-03-01 15:00:00", i), coachesAL.get(0), 3);
            lessonsAL.add(lesson1);

            Lessons lesson2 = new Lessons("Badminton", "Badminton Court", dt.getOfficeHourLongDate("2021-03-02 15:00:00", i), coachesAL.get(0), 3);
            lessonsAL.add(lesson2);

            Lessons lesson3 = new Lessons("Badminton", "Badminton Court", dt.getOfficeHourLongDate("2021-03-04 16:00:00", i), coachesAL.get(0), 3);
            lessonsAL.add(lesson3);

            Lessons lesson4 = new Lessons("Gymnastics", "Gym", dt.getOfficeHourLongDate("2021-03-01 16:00:00", i), coachesAL.get(1), 3);
            lessonsAL.add(lesson4);

            Lessons lesson5 = new Lessons("Gymnastics", "Gym", dt.getOfficeHourLongDate("2021-03-04 15:00:00", i), coachesAL.get(1), 3);
            lessonsAL.add(lesson5);

            Lessons lesson6 = new Lessons("Tennis", "Tennis Court", dt.getOfficeHourLongDate("2021-03-04 17:00:00", i), coachesAL.get(1), 3);
            lessonsAL.add(lesson6);

            Lessons lesson7 = new Lessons("Football", "Football Field", dt.getOfficeHourLongDate("2021-03-01 18:00:00", i), coachesAL.get(2), 3);
            lessonsAL.add(lesson7);

            Lessons lesson8 = new Lessons("Cricket", "Cricket Field", dt.getOfficeHourLongDate("2021-03-03 15:00:00", i), coachesAL.get(2), 3);
            lessonsAL.add(lesson8);

            Lessons lesson9 = new Lessons("Football", "Football Field", dt.getOfficeHourLongDate("2021-03-05 17:00:00", i), coachesAL.get(2), 3);
            lessonsAL.add(lesson9);

            Lessons lesson10 = new Lessons("Archery", "Archery Arena", dt.getOfficeHourLongDate("2021-03-01 17:00:00", i), coachesAL.get(3), 3);
            lessonsAL.add(lesson10);

            Lessons lesson11 = new Lessons("Archery", "Archery Arena", dt.getOfficeHourLongDate("2021-03-03 16:00:00", i), coachesAL.get(3), 3);
            lessonsAL.add(lesson11);

            Lessons lesson12 = new Lessons("Archery", "Archery Arena", dt.getOfficeHourLongDate("2021-03-04 17:00:00", i), coachesAL.get(3), 3);
            lessonsAL.add(lesson12);

            Lessons lesson13 = new Lessons("Tennis", "Tennis Court", dt.getOfficeHourLongDate("2021-03-01 17:00:00", i), coachesAL.get(4), 3);
            lessonsAL.add(lesson13);

            Lessons lesson14 = new Lessons("Tennis", "Tennis Court", dt.getOfficeHourLongDate("2021-03-02 16:00:00", i), coachesAL.get(4), 3);
            lessonsAL.add(lesson14);

            Lessons lesson15 = new Lessons("Tennis", "Tennis Court", dt.getOfficeHourLongDate("2021-03-05 16:00:00", i), coachesAL.get(4), 3);
            lessonsAL.add(lesson15);

            Lessons lesson16 = new Lessons("Gymnastics", "Gym", dt.getOfficeHourLongDate("2021-03-02 17:00:00", i), coachesAL.get(5), 3);
            lessonsAL.add(lesson16);

            Lessons lesson17 = new Lessons("Swimming", "Swimming Pool", dt.getOfficeHourLongDate("2021-03-03 17:00:00", i), coachesAL.get(5), 3);
            lessonsAL.add(lesson17);

            Lessons lesson18 = new Lessons("Swimming", "Swimming Pool", dt.getOfficeHourLongDate("2021-03-05 15:00:00", i), coachesAL.get(5), 3);
            lessonsAL.add(lesson18);

            Lessons lesson19 = new Lessons("Fencing", "Fencing Piste", dt.getOfficeHourLongDate("2021-03-02 16:00:00", i), coachesAL.get(6), 3);
            lessonsAL.add(lesson19);

            Lessons lesson20 = new Lessons("Fencing", "Fencing Piste", dt.getOfficeHourLongDate("2021-03-03 18:00:00", i), coachesAL.get(6), 3);
            lessonsAL.add(lesson20);

            Lessons lesson21 = new Lessons("Fencing", "Fencing Piste", dt.getOfficeHourLongDate("2021-03-04 18:00:00", i), coachesAL.get(6), 3);
            lessonsAL.add(lesson21);
        }
        /////////////////TESTING DATA/////////////
//        
//        Lessons lesson111 = new Lessons("Gymnastics", "Gym", "2021-03-02T17:00:00", coachesAL.get(5), 3);
//        lessonsAL.add(lesson111);
//        
//        Lessons lesson1112 = new Lessons("Swimming", "Swimming Pool", "2021-03-03T17:00:00", coachesAL.get(5), 3);
//        lessonsAL.add(lesson1112);
//        
//        Lessons lesson1113 = new Lessons("Swimming", "Swimming Pool", "2021-03-05T15:00:00", coachesAL.get(5), 3);
//        lessonsAL.add(lesson1113);
//        
//        Lessons lesson1114 = new Lessons("Fencing", "Fencing Piste", "2021-03-02T16:00:00", coachesAL.get(6), 3);
//        lessonsAL.add(lesson1114);
//        
//        Lessons lesson1115 = new Lessons("Fencing", "Fencing Piste", "2021-03-03T18:00:00", coachesAL.get(6), 3);
//        lessonsAL.add(lesson1115);
//        
//        Lessons lesson1116 = new Lessons("Fencing", "Fencing Piste", "2021-03-04T18:00:00", coachesAL.get(6), 3);
//        lessonsAL.add(lesson1116);

//            for (int i = 1; i < 4; i++) {
//                for(Lessons l : lessonsAL){
//                    Lessons tempLesson = new Lessons(l.getName(),l.getPlace(),f.getOfficeHourLongDate(l.getDateTime(), i),l.getCoach(),l.getCapacity());
////                l.setDateTime(f.getOfficeHourLongDate(l.getDateTime(), i));
//                finalLessonsAL.add(tempLesson);
//            }
//    }
        return lessonsAL;
//    return finalLessonsAL ;
    }

    public static ArrayList<Bookings> generateBookingsData(ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Coach> coachesAL) {
        //        Bookings (Student student, Lessons lesson ) for Lesson Booking
        //        Bookings (Coach coach, String note, int slot) for Office Hour Booking
        ArrayList<Bookings> bookingsAL = new ArrayList<Bookings>();
        Random rand = new Random();
        int randomIndex;
        Lessons lesson = null;

        for (Student student : studentsAL) {

            boolean capacityCheck = false;
//           boolean bookedCheck = false;

            while (!capacityCheck) {

                randomIndex = rand.nextInt(lessonsAL.size());
                lesson = lessonsAL.get(randomIndex);

                int capacity = lesson.getCapacity();
                if (capacity > 0) {
                    lesson.setCapacity(capacity - 1);
                    capacityCheck = true;

                }

            }
            bookingsAL.add(new Bookings(student, lesson, "Booked"));
        }

//        Bookings (Coach coach, String note, int slot, String status, String dateTime_
        bookingsAL.add(new Bookings(coachesAL.get(0), "Parent A", 1, "Booked", coachesAL.get(0).getOfficeHour()));
        bookingsAL.add(new Bookings(coachesAL.get(0), "Parent B", 2, "Booked", coachesAL.get(0).getOfficeHour()));
        bookingsAL.add(new Bookings(coachesAL.get(1), "Parent C", 1, "Booked", coachesAL.get(1).getOfficeHour()));
        bookingsAL.add(new Bookings(coachesAL.get(2), "Parent D", 1, "Booked", coachesAL.get(2).getOfficeHour()));
        bookingsAL.add(new Bookings(coachesAL.get(3), "Parent E", 3, "Booked", coachesAL.get(3).getOfficeHour()));
        return bookingsAL;

    }

}
