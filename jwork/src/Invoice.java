import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDate;

/**
 *
 * @author Dimas Radhitya
 * @version Modul 2 - 25 Maret 2021
 */
public abstract class Invoice
{
    // Mendefinisikan variabel
    private int id;
    protected int totalFee;
    private ArrayList<Job> jobs;
    private Calendar date;
    private Jobseeker jobseeker;
    private InvoiceStatus InvoiceStatus;

    /**
     * Constructor untuk object dari class Invoice
     * @param id id dari Invoice
     */
    public Invoice(int id, ArrayList<Job> job, Jobseeker jobseeker)
    {
        // initialise instance variables
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.InvoiceStatus = InvoiceStatus.OnGoing;
        this.date = Calendar.getInstance();
        LocalDate localDate = LocalDate.now();
        setDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    /**
     * getter id dari Invoice
     * @return id dari Invoice
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * getter job id dari Invoice
     * @return IdJob dari Invoice
     */
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
    /**
     * getter tanggal dari Invoice
     * @return date dari Invoice
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * getter total gaji dari Invoice
     * @return TotalFee dari Invoice
     */
    public int getTotalFee(){
        return this.totalFee;
    }
    
    public Jobseeker getJobseeker(){
        return this.jobseeker;
    }
    
    public abstract PaymentType getPaymentType();
    
    public InvoiceStatus getInvoiceStatus(){
        return this.InvoiceStatus;
    }
    /**
     * setter id dari Invoice
     * @param id dari Invoice
     */
    public void setId(int id){ 
        this.id = id;
    }

    public void setJobs(ArrayList<Job> jobs){
        this.jobs = jobs;
    }

    /**
     * setter tanggal dari Invoice
     * @param date dari Invoice
     */
    public void setDate(Calendar date){
        this.date = date;
    }
    
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    /**
     */
    public abstract void setTotalFee();
    
    /**
     */
    public void setJobseeker(Jobseeker jobseeker){ 
        this.jobseeker = jobseeker;
    }

    public void setInvoiceStatus(InvoiceStatus InvoiceStatus){
        this.InvoiceStatus = InvoiceStatus;
    }
    /**
     * method mencetak total gaji dari Invoice
     * output adalah TotalFee dari Invoice
     */
    //public abstract void printData();
    
    public abstract String toString();
}
