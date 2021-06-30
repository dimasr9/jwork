package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Invoice
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId;

    /** 
     * method yang digunakan untuk mendapatkan Invoice
     * @return ArrayList<Invoice> mengebalikan nilai array yang berisi Invoice
     */
    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    /**
     * method yang digunakan untuk mendapatkan last id invoice
     * @return last id
     */
    public static int getLastId(){
        return lastId;
    }

    /** 
     * method yang digunakan untuk mendapatkan invoice didapatkan dari id
     * @param id int id
     * @return int mengebalikan nilai id
     * @throws InvoiceNotFoundException
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        Invoice val = null;
        try
        {
            for (Invoice invc : INVOICE_DATABASE)
            {
                if (id == invc.getId())
                {
                    val = invc;
                }
            }
        }
        catch (Exception error)
        {
            throw new InvoiceNotFoundException(id);
        }
        return val;
    }

    /** 
     * method yang digunakan untuk mendapatkan invoice didapatkan dari jobseeker id
     * @param jobseekerId int id
     * @return int mengebalikan nilai jobseeker id
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId){
        ArrayList<Invoice> temp = new ArrayList<>();
        for (int i=0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId){
                temp.add(INVOICE_DATABASE.get(i));
            }
        }
        return temp.isEmpty() ? null : temp;
    }

    /** 
     * method yang digunakan untuk menambah invoice
     * @param id int id
     * @return boolean untuk menambah invoice
     * @throws OngoingInvoiceAlreadyExistsException
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException{
        for (Invoice invc : INVOICE_DATABASE)
        {
            if ((invc.getInvoiceStatus() == (InvoiceStatus.OnGoing)) && invoice.getJobseeker().getId() == (invc.getJobseeker().getId()))
            {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /** 
     * method yang digunakan untuk mengubah status invoice
     * @param id int id
     * @param invoiceStatus InvoiceStatus status dari invoice
     * @return boolean untuk mengubah status invoice
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for (int i=0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getId() == id) {
               INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /** 
     * method yang digunakan untuk menghapus invoice
     * @param id int id
     * @return boolean untuk menghapus invoice
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        for (Invoice invc : INVOICE_DATABASE)
        {
            if (invc.getId() == id)
            {
                INVOICE_DATABASE.remove(invc);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

}
