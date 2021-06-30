package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Fee Calculator
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
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