/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
        generateCoachData();
        generateStudentData();
        generateLessonsData();
        generateBookingsData();
    }
    
    public static void generateCoachData(){
        //        Coach(String fullName, String address, String telephoneNo, String[] expertise, String officeHour)
        
        //        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
        //        Coach rick = new Coach("Rick Grimes", "Hereford", "+44 7700 900140",null, LocalDateTime.of(2021,Month.MARCH,1,4,30).format(myFormatObj));

        Coach rick = new Coach("Rick Grimes", "Hereford", "+44 7700 900110",new String[]{"Swimming", "Badminton"}, "Monday, 16:00-17:00");   
        Coach glenn = new Coach("Glenn Rhee", "Wells", "+44 7700 900120",new String[]{"Gymnastics", "Tennis"}, "Tuesday, 16:00-17:00");
        Coach negan = new Coach("Negan", "Southampton", "+44 7700 900130",new String[]{"Cricket", "Football"}, "Wednesday, 16:00-17:00");
        Coach daryl = new Coach("Daryl Dixon", "Cambridge", "+44 7700 900140",new String[]{"Table Tennis", "Archery"}, "Thursday, 16:00-17:00");
        Coach maggie = new Coach("Maggie Greene", "Worcester", "+44 7700 900150",new String[]{"Tennis", "Cricket"}, "Friday, 16:00-17:00");
        Coach michonne = new Coach("Michonne", "Hereford", "+44 7700 900160",new String[]{"Swimming", "Gymnastics"}, "Friday, 17:00-18:00");
    }
    
    public static void generateStudentData(){
        //        Student(String fullName, String address, String telephoneNo
        Student herby = new Student("Herby Stansell","3rd Parkway","+44 7700 900111");
        Student sophi = new Student("Sophi Broadbear","Kedzie Junction","+44 7700 900220");
        Student andres = new Student("Andres Ughini","Myrtle Terrace","+44 7700 900330");
        Student sarette = new Student("Sarette Mintram","Sachs Way","+44 7700 900440");
        Student trent = new Student("Trent Eilhermann","Loeprich Point","+44 7700 900550");
        
        Student janet = new Student("Janet McCosker","","+44 7700 900660");
        Student mortie = new Student("Mortie Fenlon","Grover Way","+44 7700 900770");
        Student maurice = new Student("Maurice Ritchley","Sachs Circle","+44 7700 900880");
        Student rainer = new Student("Rainer Naile","Summer Ridge Road","+44 7700 900990");
        Student lindon = new Student("Lindon Chessil","Nancy Center","+44 7700 900890");
        
        Student reeta = new Student("Reeta Staite","Macpherson Junction","+44 7700 900790");
        Student jenna = new Student("Jenna Trahearn","Canary Street","+44 7700 900590");
        Student christine = new Student("Christine Jardine","Jenna Center","+44 7700 900450");
        Student domeniga = new Student("Domeniga Guillon","Menomonie Point","+44 7700 900650");
        Student leon = new Student("Leon Pettit","Ridgeview Point","+44 7700 900150");
    }
    
    public static void generateLessonsData(){
        //        Lessons(String name, String place, String dateTime, Coach coach, int capacity)  
        Lessons swimmingA = new Lessons("Swimming", "Swimming Pool", "Monday, 16:00-17:00", rick, 3);
    }
    public static void generateBookingsData(){
        //        Bookings (Student student, Lessons lesson )
        //        Bookings (Coach coach, String note, int slot)
    }
    
}
