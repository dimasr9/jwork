package dimasradhitya.jwork;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * Abstract class EwalletPayment - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class EwalletPayment extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;
    
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker){
        super(id, jobs, jobseeker);
    }
    
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker,
    Bonus bonus){
        super(id, jobs, jobseeker);
        this.bonus = bonus;
    }
    /**
     */
    public PaymentType getPaymentType()
    {
        // put your code here
        return this.PAYMENT_TYPE;
    }
    
    public Bonus getBonus()
    {
        // put your code here
        return this.bonus;
    }
    
    public void setBonus(Bonus bonus)
    {
        // put your code here
        this.bonus = bonus;
    }
    
    public void setTotalFee(){
        if (bonus != null && bonus.getActive() &&
                getTotalFee() > bonus.getMinTotalFee()) {
            super.totalFee += bonus.getExtraFee();
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
                "\nSeeker       : " + getJobseeker().getName();
        if (bonus.getReferralCode() != null && bonus != null && bonus.getActive() &&
                getTotalFee() > bonus.getMinTotalFee())
        {
            str += "\nReferral Code: " + bonus.getReferralCode();
        }
            str +=  "\nFee : " + totalFee +
                    "\nStatus       : " + getInvoiceStatus().toString() +
                    "\nPayment Type : " + PAYMENT_TYPE.toString();
        return str;
    }
    /*@Override
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID :"+ super.getId());
        System.out.println("ID Job : "+ super.getJob().getName());
        System.out.println("Date : "+ super.getDate());
        System.out.println("Seeker : "+ super.getJobseeker().getName());
        System.out.println("Fee : "+ super.totalFee);

        if(getJob().getFee() != totalFee){
            System.out.println("Bonus: "+ bonus.getReferralCode());
        }

        System.out.println("Status : "+ super.getInvoiceStatus().toString());
        System.out.println("Payment Type : "+ PAYMENT_TYPE.toString());
    }*/
}
