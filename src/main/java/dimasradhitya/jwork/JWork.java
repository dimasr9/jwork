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

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Dimas", "dimasr9@gmail.com", "08568406688", lct1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Radhitya", "radhitya9@gmail.com", "08568806688", lct2));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "DmsRdhty", "dimasradhitya9@gmail.com", "08567906688", lct3));

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