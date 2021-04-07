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
public class BookingSystemHLC{
//public class BookingSystemHLC extends JFrame{
//     public BookingSystemHLC () {
//        super("BookingSystemHLC"); 
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                  
//        setLayout (new BorderLayout ());  
//        
//       JButton button = new JButton("Click me!");                       
//       JButton button2 = new JButton("Click me222!"); 
//       
//       button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(e);
//                
////                JOptionPane.showMessageDialog (null,
////                "There was an error in your program",
////                "Program error",
////                JOptionPane.ERROR_MESSAGE);
//                
//            }
//        });
//       
//        JPanel centerPanel = new JPanel();
//        centerPanel.setLayout(new GridLayout(1, 1));  
//        
//        JEditorPane pane = new JEditorPane ();        
//        
//        centerPanel.add(pane);
//
//        
////        add(button, BorderLayout.CENTER);             
////        add(button2, BorderLayout.CENTER);   
//        add(centerPanel, BorderLayout.CENTER);
//
////        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//        setSize(1500, 1000);
//    }
     
    public static void main(String[] args) {        
//           BookingSystemHLC app = new BookingSystemHLC();
//           app.setVisible(true);
            
        ArrayList<Coach> coachesAL = generateCoachData();
        ArrayList <Student> studentsAL = generateStudentData();
        ArrayList <Lessons> lessonsAL = generateLessonsData(coachesAL);
        ArrayList<Bookings> bookingsAL = generateBookingsData(studentsAL, lessonsAL);
        
//        MainFrame frame = new MainFrame(coachesAL, studentsAL, bookingsAL);
        GraphicsFrame frame = new GraphicsFrame(coachesAL, studentsAL, bookingsAL);

//        
//        System.out.println("Data Loaded");
//        Scanner input = new Scanner(System.in); 
//        
//        System.out.println("Enter Student Name: ");
////        String studentName = input.nextLine();        
//        String studentName = "Reeta"; 
//        
//        System.out.println("Enter Coach Name: ");
////        String coachName = input.nextLine();
//        String coachName = "Rick Grimes";
//         
//        System.out.println("Enter Expertise: ");
////        String lessonName = input.nextLine();
//        String lessonName = "Swimming";
//        
//        
//        
//////////////        Coach Search & Get Lessons        ///////////////
//System.out.println("--------------------------------------------------------------");
//        Coach chosenCoach=null;
//        ArrayList <Lessons> coachLessonsAL = new ArrayList<Lessons>();
//        for(Coach c : coachesAL){            
//            if(c.getFullName().toLowerCase().equals(coachName.toLowerCase())){
//                System.out.println(c.getId()+"\t"+c.getFullName()+ "\t"+c.getExpertiseString()+"\t"+c.getOfficeHour());
//                chosenCoach = c;
//            }
//        }
//        
//        for(Lessons l:lessonsAL){
//            if(l.getCoach()==chosenCoach){
//                coachLessonsAL.add(l);
//                 System.out.println(l.getId() + "\t"+l.getName() +"\t"+l.getCoach().getFullName()+ "\t"+l.getDateTime()+ "\t"+l.getPlace()+"\t"+l.getCapacity());
//            }
//        }
//        
//        
//        
//        
//        
//        
/////////////        Expertise Search & Get Lessons        ////////////////
//System.out.println("--------------------------------------------------------------");
//        for(Lessons l : lessonsAL){
//            if(l.getName().toLowerCase().contains(lessonName.toLowerCase())){
//                System.out.println(l.getId() + "\t"+l.getName() +"\t"+l.getCoach().getFullName()+ "\t"+l.getDateTime()+ "\t"+l.getPlace()+"\t"+l.getCapacity());
//            }
//        }
//        
//        
//        
//System.out.println("--------------------------------------------------------------");
//        for (Bookings b : bookingsAL){
//                System.out.println("BookingID: "+b.getId() + "\tLessonName: " + b.getLesson().getName() +" - "+b.getLesson().getId()+ 
//                                                        "\tCoachName: " +b.getLesson().getCoach().getFullName() + "\tStudentName: "+
//                                                            b.getStudent().getFullName() +"\tDateTime"+b.getLesson().getDateTime()+ "\tCapacity: "+b.getLesson().getCapacity());
//            }
//        

    }
    
   
    
    
    
//    public static ArrayList<ArrayList> generateData(){
//        ArrayList<Coach> coachesAL = generateCoachData();
//        ArrayList <Student> studentsAL = generateStudentData();
//        ArrayList <Lessons> lessonsAL = generateLessonsData(coachesAL);
//        ArrayList<Bookings> bookingsAL = generateBookingsData(studentsAL, lessonsAL);
//        
//        ArrayList <ArrayList> data = new ArrayList<ArrayList>();
//        data.add(coachesAL);
//        data.add(studentsAL);
//        
//        
////        for (Coach c : coachesAL) {
////            System.out.println(c.getId() + " " + c.getFullName());
////        }
//
////         for (Student c : studentsAL) {
////            System.out.println(c.getId() + " " + c.getFullName());
////        }
//
////            for (Bookings b : bookingsAL){
////                System.out.println("BookingID: "+b.getId() + "\tLessonName: " + b.getLesson().getName() +" - "+b.getLesson().getId()+ 
////                                                        "\tCoachName: " +b.getLesson().getCoach().getFullName() + "\tStudentName: "+
////                                                            b.getStudent().getFullName() +"\tDateTime"+b.getLesson().getDateTime()+ "\tCapacity: "+b.getLesson().getCapacity());
////            }
//
//        return data;
//            
//    }
    
    
    public static ArrayList<Coach> generateCoachData(){
        //        Coach(String fullName, String address, String telephoneNo, String[] expertise, String officeHour)        
        //        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
        //        Coach rick = new Coach("Rick Grimes", "Hereford", "+44 7700 900140",null, LocalDateTime.of(2021,Month.MARCH,1,4,30).format(myFormatObj));
        
        ArrayList <Coach> coachList = new ArrayList<Coach>();       
                
        Coach coach1 = new Coach("Rick Grimes", "Hereford", "+44 7700 900110",new String[]{"Swimming", "Badminton"}, "Monday, 16:00-17:00"); 
        coachList.add(coach1);
        
        Coach coach2 = new Coach("Glenn Rhee", "Wells", "+44 7700 900120",new String[]{"Gymnastics", "Tennis"}, "Tuesday, 17:00-18:00");
        coachList.add(coach2);
        
        Coach coach3 = new Coach("Negan ", "Southampton", "+44 7700 900130",new String[]{"Cricket", "Football"}, "Wednesday, 17:00-18:00");
        coachList.add(coach3);
        
        Coach coach4 = new Coach("Daryl Dixon", "Cambridge", "+44 7700 900140",new String[]{"Archery"}, "Thursday, 15:00-16:00");
        coachList.add(coach4);
        
        Coach coach5 = new Coach("Maggie Greene", "Worcester", "+44 7700 900150",new String[]{"Tennis"}, "Friday, 18:00-19:00");
        coachList.add(coach5);
        
        Coach coach6 = new Coach("Michonne ", "Hereford", "+44 7700 900160",new String[]{"Swimming", "Gymnastics"}, "Friday, 17:00-18:00");
        coachList.add(coach6);
        
        Coach coach7 = new Coach("Rosita Espinosa", "Worcester", "+44 7700 900170",new String[]{"Fencing"}, "Thursday, 16:00-17:00");
        coachList.add(coach7);  
        
        return coachList;
        
        
    }
    
    public static ArrayList<Student> generateStudentData(){
        //        Student(String fullName, String address, String telephoneNo
        
        ArrayList<Student> studentAL = new ArrayList<Student>();        
        
        Student student1 = new Student("Herby Stansell","3rd Parkway","+44 7700 900111");
        studentAL.add(student1);
        
        Student student2 = new Student("Sophi Broadbear","Kedzie Junction","+44 7700 900220");
        studentAL.add(student2);
        
        Student student3 = new Student("Andres Ughini","Myrtle Terrace","+44 7700 900330");
        studentAL.add(student3);
        
        Student student4 = new Student("Sarette Mintram","Sachs Way","+44 7700 900440");
        studentAL.add(student4);
        
        Student student5 = new Student("Trent Eilhermann","Loeprich Point","+44 7700 900550");    
        studentAL.add(student5);
            
        Student student6 = new Student("Janet McCosker","","+44 7700 900660");
        studentAL.add(student6);
        
        Student student7 = new Student("Mortie Fenlon","Grover Way","+44 7700 900770");
        studentAL.add(student7);
        
        Student student8 = new Student("Maurice Ritchley","Sachs Circle","+44 7700 900880");
        studentAL.add(student8);
        
        Student student9 = new Student("Rainer Naile","Summer Ridge Road","+44 7700 900990");
        studentAL.add(student9);
        
        Student student10 = new Student("Lindon Chessil","Nancy Center","+44 7700 900890");    
        studentAL.add(student10);
            
        Student student11 = new Student("Reeta Staite","Macpherson Junction","+44 7700 900790");
        studentAL.add(student11);
        
        Student student12 = new Student("Jenna Trahearn","Canary Street","+44 7700 900590");
        studentAL.add(student12);
        
        Student student13 = new Student("Christine Jardine","Jenna Center","+44 7700 900450");
        studentAL.add(student13);
        
        Student student14 = new Student("Domeniga Guillon","Menomonie Point","+44 7700 900650");
        studentAL.add(student14);
        
        Student student15 = new Student("Leon Pettit","Ridgeview Point","+44 7700 900150");
        studentAL.add(student15);
        
        Student student16 = new Student("Abdul","Ridgeview Point","+44 7700 3701380");
        studentAL.add(student16);
        
        return studentAL;
    }
    
    public static ArrayList<Lessons> generateLessonsData(ArrayList<Coach> coachesAL){
        //        Lessons(String name, String place, String dateTime, Coach coach, int capacity)  
        
        ArrayList<Lessons> lessonsAL = new ArrayList<Lessons>();       


        Lessons lesson1 = new Lessons("Swimming", "Swimming Pool", "2021-03-01T15:00:00", coachesAL.get(0), 3);
        lessonsAL.add(lesson1);
        
        Lessons lesson2 = new Lessons("Badminton", "Badminton Court", "2021-03-02T15:00:00", coachesAL.get(0), 3);
        lessonsAL.add(lesson2);
        
        Lessons lesson3 = new Lessons("Badminton", "Badminton Court", "2021-03-04T16:00:00", coachesAL.get(0), 3);
        lessonsAL.add(lesson3);
        
        Lessons lesson4 = new Lessons("Gymnastics", "Gym", "2021-03-01T16:00:00", coachesAL.get(1), 3);
        lessonsAL.add(lesson4);
        
        Lessons lesson5 = new Lessons("Gymnastics", "Gym", "2021-03-04T15:00:00", coachesAL.get(1), 3);
        lessonsAL.add(lesson5);
        
        Lessons lesson6 = new Lessons("Tennis", "Tennis Court", "2021-03-04T17:00:00", coachesAL.get(1), 3);
        lessonsAL.add(lesson6);
        
        Lessons lesson7 = new Lessons("Football", "Football Field", "2021-03-01T18:00:00", coachesAL.get(2), 3);
        lessonsAL.add(lesson7);
        
        Lessons lesson8 = new Lessons("Cricket", "Cricket Field", "2021-03-03T15:00:00", coachesAL.get(2), 3);
        lessonsAL.add(lesson8);
        
        Lessons lesson9 = new Lessons("Football", "Football Field", "2021-03-05T17:00:00", coachesAL.get(2), 3);
        lessonsAL.add(lesson9);
        
        Lessons lesson10 = new Lessons("Archery", "Archery Arena", "2021-03-01T17:00:00", coachesAL.get(3), 3);
        lessonsAL.add(lesson10);
        
        Lessons lesson11 = new Lessons("Archery", "Archery Arena", "2021-03-03T16:00:00", coachesAL.get(3), 3);
        lessonsAL.add(lesson11);
        
        Lessons lesson12 = new Lessons("Archery", "Archery Arena", "2021-03-04T17:00:00", coachesAL.get(3), 3);
        lessonsAL.add(lesson12);
        
        Lessons lesson13 = new Lessons("Tennis", "Tennis Court", "2021-03-01T17:00:00", coachesAL.get(4), 3);
        lessonsAL.add(lesson13);
        
        Lessons lesson14 = new Lessons("Tennis", "Tennis Court", "2021-03-02T16:00:00", coachesAL.get(4), 3);
        lessonsAL.add(lesson14);
        
        Lessons lesson15 = new Lessons("Tennis", "Tennis Court", "2021-03-05T16:00:00", coachesAL.get(4), 3);
        lessonsAL.add(lesson15);
        
        Lessons lesson16 = new Lessons("Gymnastics", "Gym", "2021-03-02T17:00:00", coachesAL.get(5), 3);
        lessonsAL.add(lesson16);
        
        Lessons lesson17 = new Lessons("Swimming", "Swimming Pool", "2021-03-03T17:00:00", coachesAL.get(5), 3);
        lessonsAL.add(lesson17);
        
        Lessons lesson18 = new Lessons("Swimming", "Swimming Pool", "2021-03-05T15:00:00", coachesAL.get(5), 3);
        lessonsAL.add(lesson18);
        
        Lessons lesson19 = new Lessons("Fencing", "Fencing Piste", "2021-03-02T16:00:00", coachesAL.get(6), 3);
        lessonsAL.add(lesson19);
        
        Lessons lesson20 = new Lessons("Fencing", "Fencing Piste", "2021-03-03T18:00:00", coachesAL.get(6), 3);
        lessonsAL.add(lesson20);
        
        Lessons lesson21 = new Lessons("Fencing", "Fencing Piste", "2021-03-04T18:00:00", coachesAL.get(6), 3);
        lessonsAL.add(lesson21);
        
        
        return lessonsAL;
    }
    public static ArrayList<Bookings> generateBookingsData(ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL){
        //        Bookings (Student student, Lessons lesson ) for Lesson Booking
        //        Bookings (Coach coach, String note, int slot) for Office Hour Booking
        ArrayList<Bookings> bookingsAL = new ArrayList<Bookings>();
        Random rand = new Random();    
        int randomIndex;
        Lessons lesson = null;
        
                
        for (Student student : studentsAL) {
            
           boolean capacityCheck = false;
           
           while(!capacityCheck){
               randomIndex = rand.nextInt(lessonsAL.size());
               lesson = lessonsAL.get(randomIndex);
               int capacity = lesson.getCapacity(); 
               
               if(capacity > 0) {
                   lesson.setCapacity(capacity-1);
                   capacityCheck = true;
               }              
               
           }       
           bookingsAL.add(new Bookings(student, lesson, "Booked"));
        }
        
        return bookingsAL;
        
        
    }
    
}
