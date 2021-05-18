package dimasradhitya.jwork;

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

    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException {
        Jobseeker val = null;
        try
        {
            for (Jobseeker js : JOBSEEKER_DATABASE)
            {
                if (id == js.getId())
                {
                    val = js;
                }
            }
        }
        catch (Exception error)
        {
            throw new JobSeekerNotFoundException(id);
        }
        return val;
    }
    /**
     * method untuk menambahkan objek database job
     * @return nilai false
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException{
        for (Jobseeker js : JOBSEEKER_DATABASE) {
            if (jobseeker.getEmail() == js.getEmail()) {
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

}
