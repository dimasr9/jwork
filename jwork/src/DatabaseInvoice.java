import java.util.ArrayList;

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id){
        for (int i=0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getId()== id){
                return INVOICE_DATABASE.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId){
        ArrayList<Invoice> temp = new ArrayList<>();
        for (int i=0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getJobseeker().getId() == jobseekerId){
                temp.add(INVOICE_DATABASE.get(i));
                return temp;
            }
        }
        return null;
    }

    public static boolean addInvoice(Invoice invoice){
        for (Invoice invc : INVOICE_DATABASE)
        {
            if (invc.getId() == invoice.getId()) return false;
            if (invc.getInvoiceStatus() == InvoiceStatus.OnGoing) return false;
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for (int i=0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getId() == id) {
               INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id){
        for (int i=0; i < INVOICE_DATABASE.size(); i++) {
            if(INVOICE_DATABASE.get(i).getId() == id) {
                INVOICE_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

}
