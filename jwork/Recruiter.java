
/**
 * Write a description of class Recruiter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recruiter
{
    // instance variables - replace the example below with your own
    private int id;
    private String name, email, phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Recruiter
     */
    public Recruiter(int id,String name, String email, String phoneNumber, Location location)
    {
        // initialise instance variables
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getID()
    {
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setId(int id){ 
        this.id = id;
    }
    
    public void setName(String name){ 
        this.name = name;
    }
    
    public void setEmail(String email){ 
        this.email = email;
    }
    
    public void setPhoneNumber(String phoneNumber){ 
        this.phoneNumber = phoneNumber;
    }
    
    public void setLocation(Location location){
        this.location = location; 
    }
    
    public void printData(){   
        System.out.println(getName());
    }
}
