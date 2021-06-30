package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Jobseeker
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseJobseeker
{
    // Mendefinisikan variabel
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;
    
    /**
     * 
     * @return
     */
    public static ArrayList<Jobseeker> getDatabaseJobseeker(){
        return JOBSEEKER_DATABASE;
    }

    /**
     * 
     * @return
     */
    public static int getLastId(){
        return lastId;
    }

    /**
     * 
     * @param id
     * @return
     * @throws JobSeekerNotFoundException
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException {
        for (Jobseeker js : JOBSEEKER_DATABASE)
            if (id == js.getId())
                return js;
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * method untuk menambahkan objek database job
     * @return nilai false
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException{
        for (Jobseeker js : JOBSEEKER_DATABASE) {
            if (jobseeker.getEmail().equals(js.getEmail())) {
                throw new EmailAlreadyExistsException(jobseeker);
            }
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }
    
    /**
     * method untuk menghapus objek database job
     * @return nilai false
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException{
        for (Jobseeker js : JOBSEEKER_DATABASE)
        {
            if (js.getId() == id)
            {
                JOBSEEKER_DATABASE.remove(js);
                return true;
            }
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * 
     * @param email
     * @param password
     * @return
     */
    public static Jobseeker jobseekerLogin(String email, String password){
        Jobseeker val = null;
        for (Jobseeker js : JOBSEEKER_DATABASE)
        {
            if (js.getEmail().equals(email) && js.getPassword().equals(password))
            {
                val = js;
            }
            else{
                return null;
            }
        }
        return val;
    }

}
