package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Recruiter
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseRecruiter
{
    // Mendefinisikan variabel
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * method untuk menambahkan objek pada database recruiter
     * @return ArrayList<Recruiter>
     */
    public static ArrayList<Recruiter> getRecruiterDatabase(){
        return RECRUITER_DATABASE;
    }

    /**
     * 
     * @return last id
     */
    public static int getLastId(){
        return lastId;
    }

    /**
     * 
     * @param id
     * @return
     * @throws RecruiterNotFoundException
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        Recruiter val = null;
        try
        {
            for (Recruiter rc : RECRUITER_DATABASE)
            {
                if (id == rc.getId())
                {
                    val = rc;
                }
            }
        }
        catch (Exception error)
        {
            throw new RecruiterNotFoundException(id);
        }
        return val;
    }

    /**
     * 
     * @param recruiter
     * @return
     */
    public static boolean addRecruiter(Recruiter recruiter){
        RECRUITER_DATABASE.add(recruiter);
        lastId = RECRUITER_DATABASE.size()-1;
        return true;
    }

    /**
     * 
     * @param id
     * @return
     * @throws RecruiterNotFoundException
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        for (Recruiter rc : RECRUITER_DATABASE)
        {
            if (rc.getId() == id)
            {
                RECRUITER_DATABASE.remove(rc);
                return true;
            }
        }
        throw new RecruiterNotFoundException(id);
    }

}
