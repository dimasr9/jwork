import java.util.ArrayList;

/**
 * Write a description of class DatabaseJobseeker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseJobseeker
{
    // Mendefinisikan variabel
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;
    
    public static ArrayList<Jobseeker> getDatabaseJobseeker(){
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Jobseeker getJobseekerById(int id){
        for (int i=0; i < JOBSEEKER_DATABASE.size(); i++) {
            if(JOBSEEKER_DATABASE.get(i).getId() == id){
                return JOBSEEKER_DATABASE.get(i);
            }
        }
        return null;
    }
    /**
     * method untuk menambahkan objek database job
     * @return nilai false
     */
    public static boolean addJobseeker(Jobseeker jobseeker){
        for (Jobseeker jobs : JOBSEEKER_DATABASE)
        {
            if (jobs.getId() == jobseeker.getId()) return false;
            if (jobs.getEmail() == jobseeker.getEmail()) return false;
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }
    
    /**
     * method untuk menghapus objek database job
     * @return nilai false
     */
    public static boolean removeJobseeker(int id){
        for (int i=0; i < JOBSEEKER_DATABASE.size(); i++) {
            if(JOBSEEKER_DATABASE.get(i).getId() == id) {
                JOBSEEKER_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

}
