package dimasradhitya.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * Class yang menyimpan fungsi-fungsi Bank Payment
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class BankPayment extends Invoice
{
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
     * method yang digunakan untuk mendapatkan tipe payment 
     * @return payment type mengebalikan nilai tipe payment
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /** 
     * method yang digunakan untuk mendapatkan admin fee
     * @return int mengebalikan nilai adminfee  
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
    /** 
     * method yang digunakan untuk mengubah admin fee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
    /** 
     * method yang digunakan untuk mengubah total fee
     */
    public void setTotalFee()
    {
        super.totalFee = 0;
        for (Job job: getJobs()){
            super.totalFee += job.getFee();
        }
        if (adminFee != 0){
            super.totalFee -= adminFee;
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
        String str =    "====== Bank Payment ======" +
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