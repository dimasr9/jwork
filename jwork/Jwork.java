
/**
 * Write a description of class Jwork here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JWork
{
    public static void main(String[] args){
        Location location1 = new Location("Jakarta", "Jakarta Selatan", "Rumah Kedua");
        Recruiter recruiter1 = new Recruiter(1, "Dimas", "halo@gmail.com", "08568406688", location1);
        Job job1 = new Job(1, "Dimas", recruiter1, 120000, "Manusia");
        Jobseeker jobseeker1 = new Jobseeker(1, "Dimas", "halo@gmail.com", "password", "18 maret 2020");
        Invoice invoice1 = new Invoice(1, 1, "18 Maret 2020", 200000, jobseeker1);
        
        location1.printData();
        recruiter1.printData();
        jobseeker1.printData();
    }
}


