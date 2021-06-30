package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi controller invoice
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * mapping untuk mendapatkan database invoice
     * @return database invoice
     */
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice(){
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * mapping untuk mendapatkan database invoice dari id
     * @param id int id
     * @return database invoice
     * @throws SQLException SQL Exception
     */
    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) throws SQLException {
        
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
       
        /* Invoice invc = null;
        invc = DatabaseInvoicePostgre.getInvoiceById(id);
        return invc; */
    }

    /**
     * mapping untuk mendapatkan database invoice dari jobseeker id
     * @param JobseekerId int jobseeker id
     * @return database invoice
     * @throws SQLException SQL Exception
     */
    @RequestMapping(value = "/Jobseeker/{JobseekerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int JobseekerId) throws SQLException {
        
        ArrayList<Invoice> invoice = null;
        invoice = DatabaseInvoice.getInvoiceByJobseeker(JobseekerId);
        return invoice;
       
        /* ArrayList<Invoice> invc = null;
        invc = DatabaseInvoicePostgre.getInvoiceByJobseeker(JobseekerId);
        return invc; */
    }

    /**
     * mapping untuk merubah status invoice
     * @param id int id
     * @param invoiceStatus invoice status
     * @return menambahkan database invoice
     * @throws InvoiceNotFoundException Invoice Not Found Exception
     * @throws SQLException SQL Exception
     */
    @RequestMapping(value = "/InvoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") int id,
                                       @RequestParam(value="invoiceStatus") InvoiceStatus invoiceStatus)
            throws InvoiceNotFoundException, SQLException {
        
        DatabaseInvoice.changeInvoiceStatus(id, invoiceStatus);
        try {
            Invoice invoice = DatabaseInvoice.getInvoiceById(id);
            return invoice;
        } catch (InvoiceNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
       
        /* DatabaseInvoice.changeInvoiceStatus(id, invoiceStatus);
        Invoice invc = DatabaseInvoicePostgre.getInvoiceById(id);
        return invc; */
    }

    /**
     * mapping untuk menghapus invoice dari id
     * @param id int id
     * @return database invoice
     */
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

    /**
     * mappping untuk menambahkan payment ewallet
     * @param jobIdList list id dari job
     * @param jobseekerId int id jobseeker
     * @param adminFee int admin fee
     * @return menambahkan database invoice
     * @throws SQLException
     * @throws JobSeekerNotFoundException
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "adminFee") int adminFee) throws SQLException, JobSeekerNotFoundException{
            ArrayList<Job> job = new ArrayList<>();
            for (int jobs : jobIdList) {
            try {
                job.add(DatabaseJob.getJobById(jobs));
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
       
        /* Invoice invoice = null;
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
        } */
    }

    /**
     * mappping untuk menambahkan payment ewallet
     * @param jobIdList
     * @param jobseekerId
     * @param referralCode
     * @return menambahkan database invoice
     * @throws SQLException
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value = "jobseekerId") int jobseekerId,
                                  @RequestParam(value = "referralCode") String referralCode) 
        throws SQLException{
            try{
                ArrayList<Job> jobs = new ArrayList<Job>();
                for (Integer id : jobIdList){
                    Job job = DatabaseJob.getJobById(id);
                    jobs.add(job);
                }
                Jobseeker jobseeker = DatabaseJobseeker.getJobseekerById(jobseekerId);
                EwalletPayment ep = new EwalletPayment(DatabaseInvoice.getLastId()+1, jobs, jobseeker, DatabaseBonus.getBonusByReferralCode(referralCode));
                DatabaseInvoice.addInvoice(ep);
                return ep;
                } catch (JobSeekerNotFoundException | JobNotFoundException | OngoingInvoiceAlreadyExistsException e){
                    System.out.println(e.getMessage());
                }
                return null;
        }
       
                /* Invoice invoice = null;
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
                } */
}