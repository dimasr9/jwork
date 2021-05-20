package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 *
 * @author Dimas Radhitya
 * @version Modul 2 - 25 Maret 2021
 */
public class DatabaseRecruiter
{
    // Mendefinisikan variabel
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * method untuk menambahkan objek pada database recruiter
     * @return nilai false
     */
    public static ArrayList<Recruiter> getRecruiterDatabase(){
        return RECRUITER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

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

    public static boolean addRecruiter(Recruiter recruiter){
        RECRUITER_DATABASE.add(recruiter);
        lastId = RECRUITER_DATABASE.size()-1;
        return true;
    }

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
