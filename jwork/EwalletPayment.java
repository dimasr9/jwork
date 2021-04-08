
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
    
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, 
    InvoiceStatus invoiceStatus){
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, 
    Bonus bonus, InvoiceStatus invoiceStatus){
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
        if((bonus != null) && (bonus.getActive() == true) && (getJob().getFee() > getBonus().getMinTotalFee())){
            super.totalFee = (getJob().getFee() + bonus.getExtraFee());
        }
        else{
            super.totalFee = getJob().getFee();
        }
    }
    
    @Override
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
    }
}
