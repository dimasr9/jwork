
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
        Job pekerjaan = new Job(1, "Dimas", praktikan, 120000, JobCategory.WebDeveloper);
        Jobseeker jobseeker1 = new Jobseeker(1, "Lala", "halo@gmail.com", "password", "18 maret 2020");
        Invoice invoice1 = new Invoice(1, 1, "18 Maret 2020", 200000, jobseeker1, 
                            PaymentType.BankPayment, InvoiceStatus.OnGoing);
        
        //System.out.println(praktikan.getName());
        //praktikan.setName("Ferlinda");
        //System.out.println(praktikan.getName());
        //pekerjaan.printData();
        //DatabaseJob.addJob(pekerjaan);
        //DatabaseRecruiter.addRecruiter(praktikan);
        //System.out.println(PaymentType.BankPayment);
        invoice1.printData();
    }
}


