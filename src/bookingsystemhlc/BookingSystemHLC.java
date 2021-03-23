/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author abdul
 */
public class BookingSystemHLC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          generateData();
          
//          System.out.println("Monday, 16:00-17:00");
          
          
          
    }
    
    public static void generateData(){
        ArrayList<Coach> coachesAL = generateCoachData();
        ArrayList <Student> studentsAL = generateStudentData();
        ArrayList <Lessons> lessonsAL = generateLessonsData(coachesAL);
        generateBookingsData();
        
//        for (Coach c : coachesAL) {
//            System.out.println(c.getId() + " " + c.getFullName());
//        }
//         for (Student c : studentsAL) {
//            System.out.println(c.getId() + " " + c.getFullName());
//        }
    }
    
    public static ArrayList<Coach> generateCoachData(){
        ArrayList <Coach> coachList = new ArrayList<Coach>();
        
        //        Coach(String fullName, String address, String telephoneNo, String[] expertise, String officeHour)        
        //        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
        //        Coach rick = new Coach("Rick Grimes", "Hereford", "+44 7700 900140",null, LocalDateTime.of(2021,Month.MARCH,1,4,30).format(myFormatObj));
                
        Coach coach1 = new Coach("Rick Grimes", "Hereford", "+44 7700 900110",new String[]{"Swimming", "Badminton"}, "Monday, 16:00-17:00"); 
        coachList.add(coach1);
        
        Coach coach2 = new Coach("Glenn Rhee", "Wells", "+44 7700 900120",new String[]{"Gymnastics", "Tennis"}, "Tuesday, 17:00-18:00");
        coachList.add(coach2);
        
        Coach coach3 = new Coach("Negan", "Southampton", "+44 7700 900130",new String[]{"Cricket", "Football"}, "Wednesday, 17:00-18:00");
        coachList.add(coach3);
        
        Coach coach4 = new Coach("Daryl Dixon", "Cambridge", "+44 7700 900140",new String[]{"Archery"}, "Thursday, 15:00-16:00");
        coachList.add(coach4);
        
        Coach coach5 = new Coach("Maggie Greene", "Worcester", "+44 7700 900150",new String[]{"Tennis"}, "Friday, 18:00-19:00");
        coachList.add(coach5);
        
        Coach coach6 = new Coach("Michonne", "Hereford", "+44 7700 900160",new String[]{"Swimming", "Gymnastics"}, "Friday, 17:00-18:00");
        coachList.add(coach6);      
        
        
        return coachList;
        
        
    }
    
    public static ArrayList<Student> generateStudentData(){
        ArrayList<Student> studentAL = new ArrayList<Student>();
        
        //        Student(String fullName, String address, String telephoneNo
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
        
        return studentAL;
    }
    
    public static ArrayList<Lessons> generateLessonsData(ArrayList<Coach> coachesAL){
        
        ArrayList<Lessons> lessonsAL = new ArrayList<Lessons>();
        
//        Lessons(String name, String place, String dateTime, Coach coach, int capacity)  

        Lessons swimmingA = new Lessons("Swimming", "Swimming Pool", "Monday, 16:00-17:00", coachesAL.get(0), 3);
        
        return lessonsAL;
    }
    public static void generateBookingsData(){
        //        Bookings (Student student, Lessons lesson )
        //        Bookings (Coach coach, String note, int slot)
    }
    
}
