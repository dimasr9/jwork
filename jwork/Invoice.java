
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice
{
    // instance variables - replace the example below with your own
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        // initialise instance variables
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
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
    
    public int getIdJob()
    {
        return this.idJob;
    }
    
    public String getDate()
    {
        return this.date;
    }
    
    public int getTotalFee(){
        return this.totalFee;
    }
    
    public void setId(int id){ 
        this.id = id;
    }
    
    public void setIdJob(int idJob){ 
        this.idJob = idJob;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setTotalFee(int totalFee){ 
        this.totalFee = totalFee;
    }
    
    public void setJobseeker(Jobseeker jobseeker){ 
        this.jobseeker = jobseeker;
    }
    
    public void printData(){   
        
    }
}
