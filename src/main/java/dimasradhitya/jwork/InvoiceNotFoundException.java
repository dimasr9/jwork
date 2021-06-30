package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Invoice Not Found Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class InvoiceNotFoundException extends Exception{
    private int invoice_error;

    public InvoiceNotFoundException(int invoice_input){
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + invoice_error + "Not Found";
    }
}
