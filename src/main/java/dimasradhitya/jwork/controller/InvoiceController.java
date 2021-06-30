package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice(){
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) throws SQLException {
        Invoice invc = null;
        invc = DatabaseInvoicePostgre.getInvoiceById(id);
        return invc;
    }

    @RequestMapping(value = "/Jobseeker/{JobseekerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int JobseekerId) throws SQLException {
        ArrayList<Invoice> invc = null;
        invc = DatabaseInvoicePostgre.getInvoiceByJobseeker(JobseekerId);
        return invc;
    }

    @RequestMapping(value = "/InvoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") int id,
                                       @RequestParam(value="invoiceStatus") InvoiceStatus invoiceStatus)
            throws InvoiceNotFoundException, SQLException {
        DatabaseInvoice.changeInvoiceStatus(id, invoiceStatus);
        Invoice invc = DatabaseInvoicePostgre.getInvoiceById(id);
        return invc;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@RequestParam(value = "id") int id){
        try{
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e){
            e.getMessage();
            return false;
        }
        return true;
    }
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee) throws SQLException{
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<Job>();
        for (Integer integer : jobIdList) {
            jobs.add(DatabaseJobPostgre.getJobById(integer));
        }
        invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseeker(jobseekerId), adminFee);
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoicePostgre.addInvoice(invoice);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (status) {
            return invoice;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "referralCode") String referralCode) 
            throws SQLException{
                Invoice invoice = null;
                ArrayList<Job> jobs = new ArrayList<Job>();
                System.err.println("Jobseeker Id: " + jobseekerId);
                for (int integer : jobIdList) {
                    jobs.add(DatabaseJobPostgre.getJobById(integer));
                    }
                invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseeker(jobseekerId), DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
                invoice.setTotalFee();
                boolean status = false;
                try {
                    status = DatabaseInvoicePostgre.addInvoice(invoice);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                if (status) {
                    return invoice;
                } else {
                    return null;
                }
    }

}
