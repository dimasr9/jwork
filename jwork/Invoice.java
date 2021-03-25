
/**
 *
 * @author Dimas Radhitya
 * @version Modul 2 - 25 Maret 2021
 */
public class Invoice
{
    // Mendefinisikan variabel
    private int id, idJob, totalFee;
    private String date;
    private Jobseeker jobseeker;

    /**
     * Constructor untuk object dari class Invoice
     * @param id id dari Invoice
     * @param idJob job id dari Invoice
     * @param date tanggal dari Invoice
     * @param objek jobseeker dari class Jobseeker
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
     * getter id dari Invoice
     * @return id dari Invoice
     */
    public int getID()
    {
        return this.id;
    }
    
    /**
     * getter job id dari Invoice
     * @return IdJob dari Invoice
     */
    public int getIdJob()
    {
        return this.idJob;
    }
    
    /**
     * getter tanggal dari Invoice
     * @return date dari Invoice
     */
    public String getDate()
    {
        return this.date;
    }
    
    /**
     * getter total gaji dari Invoice
     * @return TotalFee dari Invoice
     */
    public int getTotalFee(){
        return this.totalFee;
    }
    
    /**
     * setter id dari Invoice
     * @param id dari Invoice
     */
    public void setId(int id){ 
        this.id = id;
    }
    
    /**
     * setter job id dari Invoice
     * @param IdJob dari Invoice
     */
    public void setIdJob(int idJob){ 
        this.idJob = idJob;
    }
    
    /**
     * setter tanggal dari Invoice
     * @param date dari Invoice
     */
    public void setDate(String date){
        this.date = date;
    }
    
    /**
     * setter total gaji dari Invoice
     * @param TotalFee dari Invoice
     */
    public void setTotalFee(int totalFee){ 
        this.totalFee = totalFee;
    }
    
    /**
     * setter jobseeker menggunakan objek dari class Jobseeker
     * @param objek jobseeker dari class Jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker){ 
        this.jobseeker = jobseeker;
    }
    
    /**
     * method mencetak total gaji dari Invoice
     * output adalah TotalFee dari Invoice
     */
    public void printData(){
        System.out.println(getTotalFee());
    }
}
