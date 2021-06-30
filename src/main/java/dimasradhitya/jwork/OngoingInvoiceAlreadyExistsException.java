package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi OnGoing Invoice Already Exist Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class OngoingInvoiceAlreadyExistsException extends Exception{
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("Ongoing Invoice: ");
        invoice_error = invoice_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + invoice_error.getInvoiceStatus() + "Already Exist";
    }
}
