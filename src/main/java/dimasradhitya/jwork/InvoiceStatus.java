package dimasradhitya.jwork;

/**
 * Class yang menyimpan tipe data status enum dari invoice
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public enum InvoiceStatus
{
    OnGoing("On Going"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String status;

    InvoiceStatus(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    } 
}
