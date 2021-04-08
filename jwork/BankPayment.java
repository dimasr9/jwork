
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
    
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, 
    InvoiceStatus invoiceStatus){
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    public BankPayment(int id, Job job, String date, Jobseeker jobseeker, 
    int adminFee, InvoiceStatus invoiceStatus){
        super(id, job, date, jobseeker, invoiceStatus);
        this.adminFee = adminFee;
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
        // put your code here
        super.totalFee = super.getJob().getFee();
    }
    
    @Override
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
    }
}