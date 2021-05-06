import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Write a description of class Jwork here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JWork
{
    public static void main(String[] args){
        //Location tempat_lahir = new Location("Jakarta", "Jakarta Selatan", "Rumah Kedua");

        {
            ArrayList<Jobseeker> print = new ArrayList<Jobseeker>();
            print.add(new Jobseeker(1, "Dimas", "dimas@ui.ac.id", "abcdefg12"));
            print.add(new Jobseeker(2, "Radhitya", "dimas@ui.ac.id", "abcdefg12"));
            print.add(new Jobseeker(3, "Bryan", "bryan@ui.ac.id", "abcdefg12"));
            print.add(new Jobseeker(4, "Dario", "dario@ui.ac.id", "abcdefg12"));

            for (Jobseeker j : print)
            {
                try {
                    DatabaseJobseeker.addJobseeker(j);
                } catch (EmailAlreadyExistsException error) {
                    System.out.println(error.getMessage());
                }
            }
        }

        {
            ArrayList<Bonus> print = new ArrayList<Bonus>();
            print.add(new Bonus(1, 10000, 30000, "abcd", true));
            print.add(new Bonus(2, 60000, 90000, "abcd", true));
            print.add(new Bonus(2, 10000, 30000, "vwxy", true));
            print.add(new Bonus(2, 60000, 90000, "vwxy1", true));
            for (Bonus b : print)
            {
                try {
                    DatabaseBonus.addBonus(b);
                } catch (ReferralCodeAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        {
            try {
                Jobseeker js = DatabaseJobseeker.getJobseekerById(20);
            } catch (JobSeekerNotFoundException e) {
                System.out.println(e.getMessage());
            }

            try {
                Recruiter js = DatabaseRecruiter.getRecruiterById(20);
            } catch (RecruiterNotFoundException e) {
                System.out.println(e.getMessage());
            }

            try {
                Job js = DatabaseJob.getJobById(20);
            } catch (JobNotFoundException e) {
                System.out.println(e.getMessage());
            }

            try {
                Bonus js = DatabaseBonus.getBonusById(20);
            } catch (BonusNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        {
            ArrayList<Bonus> listBonus = DatabaseBonus.getBonusDatabase();
            ArrayList<Jobseeker> listJS = DatabaseJobseeker.getDatabaseJobseeker();

            for (Bonus bns : listBonus)
                System.out.println(bns);

            for (Jobseeker js : listJS)
                System.out.println(js);
        }

        {
            try {

                Jobseeker js1 = DatabaseJobseeker.getJobseekerById(1);
                Jobseeker js2 = DatabaseJobseeker.getJobseekerById(2);
                Jobseeker js3 = DatabaseJobseeker.getJobseekerById(3);

                Location rumah = new Location("DKI Jakarta", "Jakarta Selatan", "Rumah");
                Recruiter rctr = new Recruiter(1, "Dimas", "dimasrdhty@ui.ac.id", "08568406688", rumah);
                DatabaseJob.addJob(new Job(1, "Senior UI", rctr, 120000, JobCategory.UI));

                DatabaseInvoice.addInvoice(new BankPayment(1, DatabaseJob.getJobDatabase(), js1));
                DatabaseInvoice.addInvoice(new BankPayment(2, DatabaseJob.getJobDatabase(), js2));
                DatabaseInvoice.addInvoice(new BankPayment(3, DatabaseJob.getJobDatabase(), js3));

            } catch (JobSeekerNotFoundException e) {
                System.out.print(e.getMessage());
                return;
            }

//            Thread myThread = new Thread(new FeeCalculator());
//            myThread.start();
        }
//        DatabaseJobseeker.addJobseeker((new Jobseeker(1, "Dimas", "dimas@gmail.com", "password")));
//        DatabaseJobseeker.addJobseeker((new Jobseeker(2, "Dimas", "dimas@gmail.com", "password")));
//        DatabaseJobseeker.addJobseeker((new Jobseeker(3, "Ferlinda", "ferlinda@gmail.com", "password")));


        //DatabaseJob.addJob((new Job(1, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.WebDeveloper)));
        //DatabaseJob.addJob((new Job(2, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.WebDeveloper)));
        //DatabaseJob.addJob((new Job(3, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.DataAnalyst)));

//        ArrayList<Jobseeker> DbJobs = DatabaseJobseeker.getDatabaseJobseeker();
//
//        for (Jobseeker js : DbJobs) {
//            System.out.println(js.toString());
//        }

        //DatabaseBonus.addBonus((new Bonus(1, "Hahaha", 5, 3, false)));
        //DatabaseBonus.addBonus((new Bonus(2, "Hahaha", 5, 3, false)));

//        ArrayList<Bonus> DbBonus = DatabaseBonus.getBonusDatabase();
//
//        DatabaseJob.addJob((new Job(1, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.WebDeveloper)));
//        DatabaseJob.addJob((new Job(2, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 10, JobCategory.WebDeveloper)));
//
//        ArrayList<Job> DbJob1 = DatabaseJob.getJobDatabase();
//        ArrayList<Job> DbJob2 = DatabaseJob.getJobDatabase();
//
//        DatabaseInvoice.addInvoice(new EwalletPayment(1, DbJob1, DatabaseJobseeker.getJobseekerById(1), DatabaseBonus.getBonusById(1)));
//
//        int lastid = DatabaseJobseeker.getLastId();
//        ArrayList<Invoice> tempInvc = DatabaseInvoice.getInvoiceByJobseeker(lastid);
//        for(Invoice invc : tempInvc){
//            invc.setTotalFee();
//        }
//        DatabaseInvoice.addInvoice(new BankPayment(1, DbJob1, DatabaseJobseeker.getJobseekerById(1)));
//
//        ArrayList<Invoice> DbInvoice = DatabaseInvoice.getInvoiceDatabase();
//
//        for (Invoice inv : DbInvoice) {
//            System.out.println(inv.toString());
//        }
//
//        ArrayList<Invoice> tempInvcStat = DatabaseInvoice.getInvoiceByJobseeker(lastid);
//        for(Invoice invc : tempInvcStat){
//            invc.setInvoiceStatus(InvoiceStatus.Finished);
//        }
//
//        DatabaseInvoice.addInvoice(new EwalletPayment(1, DbJob1, DatabaseJobseeker.getJobseekerById(2), DatabaseBonus.getBonusById(1)));
//
//        ArrayList<Bonus> tempBonus = DatabaseBonus.getBonusDatabase();
//        for(Bonus bons : tempBonus){
//            bons.setActive(true);
//        }
//
//        ArrayList<Invoice> tempInvc2 = DatabaseInvoice.getInvoiceByJobseeker(lastid);
//        for(Invoice invc : tempInvc2){
//            invc.setTotalFee();
//        }

        //Recruiter praktikan = new Recruiter(1, "Dimas", "halo@gmail.com", "08568406688", tempat_lahir);
        //Jobseeker jobseeker1 = new Jobseeker(1, "Lala", "halo@gmail.com", "password", "18 maret 2020");
        //Bonus bonus3 = new Bonus(3, null, 5, 3, true);
        //Jobseeker jobseeker1 = new Jobseeker(1, "Dimas",".haha@gmail.com", "aaaa", new GregorianCalendar(2023,4,20) );
        //Jobseeker jobseeker2 = new Jobseeker(2, "Dimas2", "dimas@gmail.com", "McLarenP1", 2020, 12, 20 );
        //Jobseeker jobseeker3 = new Jobseeker(3, "Dimas3","dimasr@gmail.com", "McLarenP1" );
        
        //jobseeker1.toString();
        //System.out.println(jobseeker1.toString());
        //jobseeker2.toString();
        //System.out.println(jobseeker2.toString());
        //jobseeker3.toString();
        //System.out.println(jobseeker3.toString());
        
        //jobseeker1.setEmail("dimasradhitya@gmail.com");
        //jobseeker1.setPassword("McLarenP1");
        //Calendar date1 = new GregorianCalendar();
        //System.out.println(jobseeker1.toString());
        //Job pekerjaan = new Job(1, "Senior Designer", praktikan, 10, JobCategory.WebDeveloper);
        
        //EwalletPayment ewallet1 = new EwalletPayment(1, pekerjaan, jobseeker1, bonus1, InvoiceStatus.OnGoing);
        //EwalletPayment ewallet2 = new EwalletPayment(2, pekerjaan, "18 maret 2020", jobseeker1, bonus2, InvoiceStatus.OnGoing);
        //EwalletPayment ewallet3 = new EwalletPayment(3, pekerjaan, "18 maret 2020", jobseeker1, bonus3, InvoiceStatus.OnGoing);
        //BankPayment bankpayment1 = new BankPayment(1, pekerjaan, jobseeker1, InvoiceStatus.Finished);
        //BankPayment bankpayment2 = new BankPayment(1, pekerjaan, "20 maret 2020", jobseeker1, 10, InvoiceStatus.Finished);
        //ewallet1.toString();
        //ewallet2.setTotalFee();
        //ewallet3.setTotalFee();
        //bankpayment1.toString();
        //bankpayment2.setTotalFee();
        //System.out.println(ewallet1.toString());
        //System.out.println(bankpayment1.toString());

        //bankpayment1.printData();
        //bankpayment2.printData();
        //ewallet1.printData();
        //ewallet2.printData();
        //ewallet3.printData();
        //Invoice invoice1 = new Invoice(1, pekerjaan.getId(), "18 Maret 2020", pekerjaan.getFee(), jobseeker1, 
                            //PaymentType.BankPayment, InvoiceStatus.OnGoing);
        
        //System.out.println(praktikan.getName());
        //praktikan.setName("Ferlinda");
        //System.out.println(praktikan.getName());
        //pekerjaan.printData();
        //DatabaseJob.addJob(pekerjaan);
        //DatabaseRecruiter.addRecruiter(praktikan);
        //System.out.println(PaymentType.BankPayment);
        //invoice1.printData();
    }
}


