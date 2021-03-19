package bookingsystemhlc;

/**
 *
 * @author abdul
 */
public class Coach extends Personnel {
    private String[] expertise;
    private String officeHour;
    
    public Coach(int id, String fullName, String address, String telephoneNo, String[] expertise, String officeHour){
        
        super(id, fullName, address, telephoneNo);   
        this.expertise = expertise;
        this.officeHour = officeHour;
        
    }
    
    public String[] getExpertise(){
        return expertise;
    }
    
    public String officeHour(){
        return officeHour;
    }
    
    
}
