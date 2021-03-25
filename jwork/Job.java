
/**
 *
 * @author Dimas Radhitya
 * @version Modul 2 - 25 Maret 2021
 */
public class Job
{
    // Mendefinisikan variabel
    private int id, fee;
    private String name, category;
    private Recruiter recruiter;
    /**
     * Constructor untuk object dari class Job
     * @param id id dari Job
     * @param name nama dari Jobb
     * @param recruiter objek recruiter dari class Recruiter
     * @param fee gaji dari Job
     * @param category kategori dari Job
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
     * getter id dari Job
     * @return id dari Job
     */
    public int getID()
    {
        return this.id;
    }
    
    /**
     * getter nama dari Job
     * @return name dari Job
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * getter recruiter dari class Recruiter
     * @return recruiter dari class Recruiter
     */
    public Recruiter getRecruiter(){
        return this.recruiter;
    }
    
    /**
     * getter gaji dari Job
     * @return fee dari Job
     */
    public int getFee(){
        return this.fee;
    }
    
    /**
     * getter kategori dari Job
     * @return category dari Job
     */
    public String getCategory(){
        return this.category;
    }
    
    /**
     * setter id dari Job
     * @param id dari Job
     */
    public void setId(int id){ 
        this.id = id;
    }
    
    /**
     * setter nama dari Job
     * @param name dari Job
     */
    public void setName(String name){ 
        this.name = name;
    }
    
    /**
     * setter recruiter menggunakan objek dari class Recruiter
     * @param objek recruiter dari class Recruiter
     */
    public void setRecruiter(Recruiter recruiter){
        this.recruiter = recruiter;
    }
    
    /**
     * setter gaji dari Job
     * @param fee dari Job
     */
    public void setFee(int fee){ 
        this.fee = fee;
    }
    
    /**
     * setter kategori dari Job
     * @param category dari Job
     */
    public void setCategory(String category){ 
        this.category = category;
    }
    
    /**
     * method mencetak nama dari Job
     * output adalah nama dari Job
     */
    public void printData(){
        System.out.println(getName());
    }
}
