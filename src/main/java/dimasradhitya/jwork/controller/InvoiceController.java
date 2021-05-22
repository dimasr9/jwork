package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice(){
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invc = null;
        try {
            invc = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invc;
    }

    @RequestMapping(value = "/Jobseeker/{JobseekerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int JobseekerId) {
        ArrayList<Invoice> invc = null;
        invc = DatabaseInvoice.getInvoiceByJobseeker(JobseekerId);
        return invc;
    }

    @RequestMapping(value = "/InvoiceStatus/{Id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") int id,
                                       @RequestParam(value="invoiceStatus") InvoiceStatus invoiceStatus)
            throws InvoiceNotFoundException {
        DatabaseInvoice.changeInvoiceStatus(id, invoiceStatus);
        Invoice invc = DatabaseInvoice.getInvoiceById(id);
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
                                  @RequestParam(value = "adminId") int adminFee){
        ArrayList<Job> job = new ArrayList<>();
        for (int jb : jobIdList) {
            try {
                job.add(DatabaseJob.getJobById(jb));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Invoice invoice = new BankPayment(DatabaseInvoice.getLastId()+1, job,
                    DatabaseJobseeker.getJobseekerById(jobseekerId), adminFee);
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalFee();
            return invoice;
        } catch (JobSeekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "referralCode") String referralCode){
        ArrayList<Job> job = new ArrayList<>();
        for (int jb : jobIdList) {
            try {
                job.add(DatabaseJob.getJobById(jb));
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Invoice invoice = new EwalletPayment(DatabaseInvoice.getLastId()+1, job,
                    DatabaseJobseeker.getJobseekerById(jobseekerId), DatabaseBonus.getBonusByReferralCode(referralCode));
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalFee();
            return invoice;
        } catch (JobSeekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
