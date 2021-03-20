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
public class Personnel {
    private int id;
    private String fullName;
    private String address;
    private String telephoneNo;
    
    private static int counter = 1;
    
    public Personnel(String fullName, String address, String telephoneNo){
       this.id = counter++;
       this.fullName = fullName;
       this.address = address;
       this.telephoneNo = telephoneNo;
       
    };
    
    public int getId(){
        return this.id;
    };
    public String getFullName(){
        return this.fullName;
    };
    public String address(){
        return this.address;
    };
    public String telephoneNo(){
        return this.telephoneNo;
    };
    
        
    
    
}
