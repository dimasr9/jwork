
/**
 * Write a description of class Job here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Job
{
    // instance variables - replace the example below with your own
    private int id, fee;
    private String name, category;
    private Recruiter recruiter;
    /**
     * Constructor for objects of class Job
     */
    public Job(int id, String name, Recruiter recruiter, int fee, String category)
    {
        // initialise instance variables
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
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
    
    public Recruiter getRecruiter(){
        return this.recruiter;
    }
    
    public int getFee(){
        return this.fee;
    }
    
    public String getCategory(){
        return this.category;
    }
    
    public void setId(int id){ 
        this.id = id;
    }
    
    public void setName(String name){ 
        this.name = name;
    }
    
    public void setRecruiter(Recruiter recruiter){
        this.recruiter = recruiter;
    }
    
    public void setFee(int fee){ 
        this.fee = fee;
    }
    
    public void setCategory(String category){ 
        this.category = category;
    }
    
    public void printData(){
        System.out.println(getName());
    }
}
