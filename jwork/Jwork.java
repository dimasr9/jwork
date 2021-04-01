
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
        Jobseeker jobseeker1 = new Jobseeker(1, "Lala", "halo@gmail.com", "password", "18 maret 2020");
        Bonus bonus1 = new Bonus(1, "Hahaha", 20000, 2000, true);
        Bonus bonus2 = new Bonus(2, null, 25000, 2000000, true);
        Bonus bonus3 = new Bonus(2, null, 25000, 2000, true);
        Job pekerjaan = new Job(1, "Dimas", praktikan, 120000, JobCategory.WebDeveloper);
        EwalletPayment ewallet1 = new EwalletPayment(1, pekerjaan, "18 maret 2020", jobseeker1, InvoiceStatus.OnGoing, bonus1);
        EwalletPayment ewallet2 = new EwalletPayment(2, pekerjaan, "18 maret 2020", jobseeker1, InvoiceStatus.OnGoing, bonus2);
        EwalletPayment ewallet3 = new EwalletPayment(3, pekerjaan, "18 maret 2020", jobseeker1, InvoiceStatus.OnGoing, bonus3);
        
        ewallet1.setTotalFee();
        ewallet2.setTotalFee();
        ewallet3.setTotalFee();
        
        ewallet1.printData();
        ewallet2.printData();
        ewallet3.printData();
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


