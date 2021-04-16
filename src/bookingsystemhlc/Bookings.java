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
    private String appointmentDateTime;
    
    private String bookingType;
    
    private static int bookingCounter = 1;
    
    public Bookings (Student student, Lessons lesson, String status ){
        this.id = bookingCounter++;
        this.student = student;
        this.lesson = lesson; 
        this.bookingType = "Lesson";
        this.status = status;
    }
    
     public Bookings (Coach coach, String note, int slot, String status, String dateTime){
        this.id = bookingCounter++;
        this.coach = coach;
        this.note = note;
        this.slot = slot;
        this.bookingType = "Appointment";
        this.status = status;
        this.appointmentDateTime = dateTime;
    }
    
    public int getId(){
        return id;
    } 
    
    public void setId(int id){
        this.id = id;
    }
     
    public Student getStudent(){
        return student;
    }
    
    public void setStudent(Student student){
        this.student = student;
    }
    
    public Lessons getLesson(){
        return lesson;
    }
    
    public void setLesson(Lessons lesson){
        this.lesson = lesson;
    }
    
    public String getBookingType(){
        return bookingType;
    }
    
    public void setBookingType(String type){
        this.bookingType = type;
    }
    
    public Coach getCoach(){
        return coach;
    }
    
    public void setCoach(Coach c) {
        this.coach=c;
    }
    
    public String getNote(){
        return note;
    }
    
    public void setNote(String s) {
        this.note = s;
    }
    
    public int getSlot(){
        return slot;
    }
    
    public void setSlot (int slot){
        this.slot = slot;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String s){
        this.status=s;
    }
    
    public String getAppointmentBookingDateTime() {
        return appointmentDateTime;
    }
    
    public void setAppointmentBookingDateTime(String s){
        this.appointmentDateTime = s;
    }
    
    
    
    
}
