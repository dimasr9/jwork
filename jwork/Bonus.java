
/**
 * Write a description of class Bonus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bonus
{
    // instance variables - replace the example below with your own
    private int id, extraFee, minTotalFee;
    private String referralCode;
    private boolean active;

    /**
     * Constructor for objects of class Bonus
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active)
    {
        // initialise instance variables
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        return this.id;
    }
    
    public String getReferralCode()
    {
        return this.referralCode;
    }
    
    public int getExtraFee()
    {
        return this.extraFee;
    }
    
    public int getMinTotalFee()
    {
        return this.minTotalFee;
    }
    
    public boolean getActive()
    {
        return this.active;
    }
    
    public void setId(int id){ 
        this.id = id;
    }
    
    public void setReferralCode(String referralCode){ 
        this.referralCode = referralCode;
    }
    
    public void setExtraFee(int extraFee){ 
        this.extraFee = extraFee;
    }
    
    public void setMinTotalFee(int minTotalFee){ 
        this.minTotalFee = minTotalFee;
    }
    
    public void setActive(boolean active){ 
        this.active = active;
    }
    
    public void printData(){
        System.out.println("============= BONUS ==============");
        System.out.println("ID : " + id);
        System.out.println("Referral Code : " + referralCode);
        System.out.println("Extra Fee : " + extraFee);
        System.out.println("Min Total Fee : " + minTotalFee);
        System.out.println("Active : " + active);
    }
}
