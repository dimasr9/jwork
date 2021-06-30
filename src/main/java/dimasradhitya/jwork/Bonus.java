package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Bonus
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class Bonus
{
    private int id, extraFee, minTotalFee;
    private String referralCode;
    private boolean active;

    public Bonus(int id, int extraFee, int minTotalFee, String referralCode, boolean active)
    {
        // initialise instance variables
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /** 
     * method yang digunakan untuk mendapatkan id dari bonus
     * @return int mengebalikan nilai id job 
     */
    public int getId()
    {
        return this.id;
    }
    
    /** 
     * method yang digunakan untuk mendapat referal code
     * @return String referralCode
     */
    public String getReferralCode()
    {
        return this.referralCode;
    }
    
    /** 
     * method yang digunakan untuk mendapatkan extraFee
      * @return int extraFee
     */
    public int getExtraFee()
    {
        return this.extraFee;
    }
    
    /** 
     * method yang digunakan untuk mendapatkan minimum total fee
      * @return int minTotalFee
     */
    public int getMinTotalFee()
    {
        return this.minTotalFee;
    }
    
    /** 
     * method yang digunakan untuk mendapat status dari bonus
      * @return active status dari bonus ada/tidak
     */
    public boolean getActive()
    {
        return this.active;
    }
    
    /** 
     * method yang digunakan untuk menset id
      * @param id id bonus
     */
    public void setId(int id){ 
        this.id = id;
    }
    
    /** 
     * method yang digunakan untuk set referal code
      * @param referralCode String referralCode
     */
    public void setReferralCode(String referralCode){ 
        this.referralCode = referralCode;
    }
    
    /** 
     * method yang digunakan untuk mengubah extraFee
      * @param extraFee int extraFee
     */
    public void setExtraFee(int extraFee){ 
        this.extraFee = extraFee;
    }
    
    /** 
     * method yang digunakan untuk mengubah nilai minimum total fee
      * @param minTotalFee int minimal fee
     */
    public void setMinTotalFee(int minTotalFee){ 
        this.minTotalFee = minTotalFee;
    }
    
    /** 
     * method yang digunakan untuk mendapat status dari bonus
      * @return active status dari bonus ada/tidak
     */
    public void setActive(boolean active){ 
        this.active = active;
    }
    
    public String toString(){
        return "Id = "+ id +
               "\nReferral Code = "+ referralCode +
               "\nExtra Fee = " + extraFee +
               "\nMin Total Fee = "+ minTotalFee +
               "\nActive = "+ active;
    }
    
    /*public void printData(){
        System.out.println("============= BONUS ==============");
        System.out.println("ID : " + id);
        System.out.println("Referral Code : " + referralCode);
        System.out.println("Extra Fee : " + extraFee);
        System.out.println("Min Total Fee : " + minTotalFee);
        System.out.println("Active : " + active);
    }*/
}
