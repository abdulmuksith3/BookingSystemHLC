/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;
import java.time.LocalDateTime;
import java.time.Month;
/**
 *
 * @author abdul
 */
public class Lessons {
    private int id;
    private String name;
    private String place;
    private String dateTime;
    private Coach coach;
    private int capacity;
    
    private static int lessonCounter = 1;
    
    public Lessons(String name, String place, String dateTime, Coach coach, int capacity){
        this.id = lessonCounter++;
        this.name = name;
        this.place = place;
        this.dateTime = dateTime;
        this.coach = coach;
        this.capacity = capacity;
        
    }
     
    public int getId(){
        return id;
    } 
    
    public String getName(){
        return name;
    }
    
    public String getPlace(){
        return place;
    }
    
    public String getDateTime(){
        return dateTime;
    }
    
    public Coach getCoach(){
        return coach;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public void setCapacity(int value){
        this.capacity=value;
    }
}
