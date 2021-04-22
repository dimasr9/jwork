import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * Write a description of class BankPayment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BankPayment extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee = 0;
    
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker){
        super(id, jobs, jobseeker);
    }
    
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker,
    int adminFee){
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @return    the sum of x and y
     */
    public PaymentType getPaymentType()
    {
        // put your code here
        return this.PAYMENT_TYPE;
    }
    
    public int getAdminFee()
    {
        // put your code here
        return this.adminFee;
    }
    
    public void setAdminFee(int adminFee)
    {
        // put your code here
        this.adminFee = adminFee;
    }
    
    public void setTotalFee()
    {
        if (adminFee != 0) {
            totalFee -= adminFee;
        }
    }
    
    public String toString()
    {
        Date date = getDate().getTime();
        String strDate = "";
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            strDate = dateFormat.format(date);
        }
        String str =    "====== Ewallet Payment ======" +
                "\nID           : " + getId() +
                "\nJobs         : " + getJobs() +
                "\nDate         : " + strDate +
                "\nSeeker       : " + getJobseeker().getName() +
                "\nFee : " + totalFee +
                "\nStatus       : " + getInvoiceStatus().toString() +
                "\nPayment Type : " + PAYMENT_TYPE.toString();
        return str;
    }
    /*@Override
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID :"+ super.getId());
        System.out.println("Job : "+ super.getJob().getCategory());
        System.out.println("Date : "+ super.getDate());
        System.out.println("Jobseeker : "+ super.getJobseeker().getName());
        System.out.println("Admin : "+ adminFee);
        System.out.println("Fee : "+ super.totalFee);
        System.out.println("Status : "+ super.getInvoiceStatus().toString());
        System.out.println("Payment Type : "+ PAYMENT_TYPE.toString());
    }*/
}