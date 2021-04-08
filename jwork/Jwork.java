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
        Location tempat_lahir = new Location("Jakarta", "Jakarta Selatan", "Rumah Kedua");
        Recruiter praktikan = new Recruiter(1, "Dimas", "halo@gmail.com", "08568406688", tempat_lahir);
        //Jobseeker jobseeker1 = new Jobseeker(1, "Lala", "halo@gmail.com", "password", "18 maret 2020");
        Bonus bonus1 = new Bonus(1, "Hahaha", 5, 2, true);
        Bonus bonus2 = new Bonus(2, null, 5, 7, true);
        Bonus bonus3 = new Bonus(3, null, 5, 3, true);
        Jobseeker jobseeker1 = new Jobseeker(1, "Dimas",".haha@gmail.com", "aaaa", new GregorianCalendar(2021,5,20) );
        Jobseeker jobseeker2 = new Jobseeker(2, "Dimas2", "dimas@gmail.com", "McLarenP1", 2020, 12, 20 );
        Jobseeker jobseeker3 = new Jobseeker(3, "Dimas3","dimasr@gmail.com", "McLarenP1" );
        
        jobseeker1.toString();
        System.out.println(jobseeker1.toString());
        jobseeker2.toString();
        System.out.println(jobseeker2.toString());
        jobseeker3.toString();
        System.out.println(jobseeker3.toString());
        
        jobseeker1.setEmail("dimasradhitya@gmail.com");
        jobseeker1.setPassword("McLarenP1");
        
        System.out.println(jobseeker1.toString());
        //Job pekerjaan = new Job(1, "Senior Designer", praktikan, 10, JobCategory.WebDeveloper);
        
        
        
        //EwalletPayment ewallet1 = new EwalletPayment(1, pekerjaan, "18 maret 2020", jobseeker1, bonus1, InvoiceStatus.OnGoing);
        //EwalletPayment ewallet2 = new EwalletPayment(2, pekerjaan, "18 maret 2020", jobseeker1, bonus2, InvoiceStatus.OnGoing);
        //EwalletPayment ewallet3 = new EwalletPayment(3, pekerjaan, "18 maret 2020", jobseeker1, bonus3, InvoiceStatus.OnGoing);
        //BankPayment bankpayment1 = new BankPayment(1, pekerjaan, "20 maret 2020", jobseeker1, InvoiceStatus.Finished);
        //BankPayment bankpayment2 = new BankPayment(1, pekerjaan, "20 maret 2020", jobseeker1, 10, InvoiceStatus.Finished);
        //ewallet1.setTotalFee();
        //ewallet2.setTotalFee();
        //ewallet3.setTotalFee();
        //bankpayment1.setTotalFee();
        //bankpayment2.setTotalFee();
        
        
        
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


