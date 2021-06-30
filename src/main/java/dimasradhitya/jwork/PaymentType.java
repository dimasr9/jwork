package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi PaymentType
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public enum PaymentType
{
    BankPayment("Bank Payment"),
    EwalletPayment("E-Wallet Payment");
    
    private String type;

    PaymentType(String type)
    {
        this.type = type;
    }
    
    public String toString()
    {
        return type;
    } 
}
