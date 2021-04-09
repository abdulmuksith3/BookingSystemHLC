/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

/**
 *
 * @author abdul
 */
public class Bookings {
    private int id;
    
    private Student student;
    private Lessons lesson;
    
    private Coach coach;
    private String note;
    private int slot;
    private String status;
    
    private String bookingType;
    
    private static int bookingCounter = 1;
    
    public Bookings (Student student, Lessons lesson, String status ){
        this.id = bookingCounter++;
        this.student = student;
        this.lesson = lesson; 
        this.bookingType = "Lesson";
        this.status = status;
    }
    
     public Bookings (Coach coach, String note, int slot, String status){
        this.id = bookingCounter++;
        this.coach = coach;
        this.note = note;
        this.slot = slot;
        this.bookingType = "Appointment";
        this.status = status;
    }
    
    public int getId(){
        return id;
    } 
     
    public Student getStudent(){
        return student;
    }
    
    public Lessons getLesson(){
        return lesson;
    }
    
    public String getBookingType(){
        return bookingType;
    }
    
    public Coach getCoach(){
        return coach;
    }
    
    public String getNote(){
        return note;
    }
    
    public int getSlot(){
        return slot;
    }
    
    public String getStatus(){
        return status;
    }
    
    
}
