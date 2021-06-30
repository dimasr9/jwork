package dimasradhitya.jwork;

/**
 * Write a description of class Jwork here.
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JWork {

    public static void main(String[] args) {

        Location lct1 = new Location("Jakarta", "Jakpus", "LOL");
        Location lct2 = new Location("Bandung", "Bandung Barat", "Mana ada");
        Location lct3 = new Location("Serang", "Seoul", ":O");

        Recruiter r1 = new Recruiter(1, "Dimas", "dimasradhitya9@gmail.com", "01234567889", lct1);
        DatabaseRecruiterPostgre.addRecruiter(r1);

        Recruiter r2 = new Recruiter(2, "Radhitya", "radhitya@gmail.com", "01234567889", lct2);
        DatabaseRecruiterPostgre.addRecruiter(r2);

        Recruiter r3 = new Recruiter(3, "DimasRadhtyaaa", "dmsrdhty@gmail.com", "01234567889", lct3);
        DatabaseRecruiterPostgre.addRecruiter(r3);

        
        DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastJobId()+1, "Dimas1", DatabaseRecruiterPostgre.getRecruiterById(1), 80000, JobCategory.DataAnalyst));
        DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastJobId()+1, "Dimas2", DatabaseRecruiterPostgre.getRecruiterById(2), 80000, JobCategory.DataAnalyst));
        DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastJobId()+1, "Dimas4", DatabaseRecruiterPostgre.getRecruiterById(3), 80000, JobCategory.FrondEnd));
        DatabaseJobPostgre.addJob(new Job(DatabaseJobPostgre.getLastJobId()+1, "Dimas3", DatabaseRecruiterPostgre.getRecruiterById(3), 80000, JobCategory.BackEnd));
        
        SpringApplication.run(JWork.class, args);
    }

}