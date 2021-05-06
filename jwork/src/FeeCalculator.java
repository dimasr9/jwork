import java.util.ArrayList;

public class FeeCalculator implements Runnable
{
    public void run(){
        ArrayList<Invoice> list = DatabaseInvoice.getInvoiceDatabase();
        for (Invoice invc : list){
            System.out.println("Calculating Invoice ID: "+ invc.getId());
            invc.setTotalFee();
            System.out.println("Finish Calculating Invoice ID: "+ invc.getId());

        }

    }
}