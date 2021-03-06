package bookingsystemhlc;
import java.time.LocalDateTime;
import java.time.Month;
/**
 *
 * @author abdul
 */
public class Coach extends Personnel {
    private String[] expertise;
    private String officeHour;
    
    public Coach(String fullName, String address, String telephoneNo, String[] expertise, String officeHour){
        
        super(fullName, address, telephoneNo);   
        this.expertise = expertise;
        this.officeHour = officeHour;
        
    }
    
    public String[] getExpertise(){       
        return expertise;
    }
    
    public String getExpertiseString(){
        String exp="";
        for(String s : expertise){
            exp+=s+", ";
        }
        return exp;
    }
    
    public String getOfficeHour(){
        return officeHour;
    }
    
    public void setExpertise (String[] expertise){
        this.expertise = expertise;
    }
    
    public void setOfficeHour(String officeHour){
        this.officeHour = officeHour;
    }
    
    
}
