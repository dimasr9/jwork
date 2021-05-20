package dimasradhitya.jwork;

/**
 * Write a description of class Jwork here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JWork {

    public static void main(String[] args) {
        Location lct1 = new Location("Jakarta", "Jakpus", "LOL");
        Location lct2 = new Location("Bandung", "Bandung Barat", "Mana ada");
        Location lct3 = new Location("Serang", "Seoul", ":O");

        Recruiter r1 = new Recruiter(1, "Dimas", "dimas@gmail.com", "01234567889", lct1);
        Recruiter r2 = new Recruiter(2, "Radhitya", "radhitya@gmail.com", "01234567889", lct2);
        Recruiter r3 = new Recruiter(3, "DimasRadhtyaaa", "dmsrdhty@gmail.com", "01234567889", lct3);

        DatabaseRecruiter.addRecruiter(r1);
        DatabaseRecruiter.addRecruiter(r2);
        DatabaseRecruiter.addRecruiter(r3);

        try{
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Dimas1", DatabaseRecruiter.getRecruiterById(1), 80000, JobCategory.DataAnalyst));
        }catch (RecruiterNotFoundException error){
            System.out.println(error.getMessage());
        }
        try{
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Dimas2", DatabaseRecruiter.getRecruiterById(2), 80000, JobCategory.DataAnalyst));
        }catch (RecruiterNotFoundException error){
            System.out.println(error.getMessage());
        }
        try{
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Dimas3", DatabaseRecruiter.getRecruiterById(3), 80000, JobCategory.BackEnd));
        }catch (RecruiterNotFoundException error){
            System.out.println(error.getMessage());
        }
        try{
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Dimas4", DatabaseRecruiter.getRecruiterById(3), 80000, JobCategory.FrondEnd));
        }catch (RecruiterNotFoundException error){
            System.out.println(error.getMessage());
        }

        SpringApplication.run(JWork.class, args);
    }

}