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
    private Job job;
    private Calendar date;
    private Jobseeker jobseeker;
    private PaymentType paymentType;
    private InvoiceStatus InvoiceStatus;

    /**
     * Constructor untuk object dari class Invoice
     * @param id id dari Invoice
     * @param idJob job id dari Invoice
     * @param date tanggal dari Invoice
     * @param objek jobseeker dari class Jobseeker
     */
    public Invoice(int id, Job job, Jobseeker jobseeker, InvoiceStatus InvoiceStatus)
    {
        // initialise instance variables
        this.id = id;
        this.job = job;
        this.jobseeker = jobseeker;
        this.InvoiceStatus = InvoiceStatus;
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
    public Job getJob()
    {
        return this.job;
    }
    
    /**
     * getter tanggal dari Invoice
     * @return date dari Invoice
     */
    public Calendar getDate()
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
    
    /**
     * setter job id dari Invoice
     * @param IdJob dari Invoice
     */
    public void Job(Job job){ 
        this.job = job;
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
     * setter total gaji dari Invoice
     * @param TotalFee dari Invoice
     */
    public abstract void setTotalFee();
    
    /**
     * setter jobseeker menggunakan objek dari class Jobseeker
     * @param objek jobseeker dari class Jobseeker
     */
    public void setJobseeker(Jobseeker jobseeker){ 
        this.jobseeker = jobseeker;
    }
    
    public void setPaymentType(PaymentType paymentType){ 
        this.paymentType = paymentType;
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
