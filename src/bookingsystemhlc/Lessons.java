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
public class Lessons {
    private String name;
    private String place;
    private String dateTime;
    private Coach coach;
    private int capacity;
    
    public Lessons(String name, String place, String dateTime, Coach coach, int capacity){
        this.name = name;
        this.place = place;
        this.dateTime = dateTime;
        this.coach = coach;
        this.capacity = capacity;
        
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
}
