package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Job
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseJob
{
    // Mendefinisikan variabel
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;
    
    /** 
     * method yang digunakan untuk mendapatkan Job
     * @return ArrayList<Job> mengebalikan nilai array yang berisi Job
     */
    public static ArrayList<Job> getJobDatabase(){
        return JOB_DATABASE;
    }

    /**
     * 
     * @return int last id
     */
    public static int getLastId(){
        return lastId;
    }

    /**
     * 
     * @param id
     * @return
     * @throws JobNotFoundException
     */
    public static Job getJobById(int id) throws JobNotFoundException {
        Job val = null;
        try
        {
            for (Job job : JOB_DATABASE)
            {
                if (id == job.getId())
                {
                    val = job;
                    return val;
                }
            }
        }
        catch (Exception error)
        {
            throw new JobNotFoundException(id);
        }
        return val;
    }

    /**
     * 
     * @param recruiterId
     * @return
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId){
        ArrayList<Job> temp = new ArrayList<>();
        for (int i=0; i < JOB_DATABASE.size(); i++) {
            if(JOB_DATABASE.get(i).getRecruiter().getId() == recruiterId){
                temp.add(JOB_DATABASE.get(i));
                return temp;
            }
        }
        return null;
    }

    /**
     * 
     * @param category
     * @return
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category){
        ArrayList<Job> temp = new ArrayList<>();
        for (int i=0; i < JOB_DATABASE.size(); i++) {
            if(JOB_DATABASE.get(i).getCategory() == category){
                temp.add(JOB_DATABASE.get(i));
                return temp;
            }
        }
        return null;
    }

    /**
     * 
     * @param job
     * @return
     */
    public static boolean addJob(Job job){
        JOB_DATABASE.add(job);
        lastId = JOB_DATABASE.size()-1;
        lastId = job.getId();
        return true;
    }

    /**
     * 
     * @param id
     * @return
     * @throws JobNotFoundException
     */
    public static boolean removeJob(int id) throws JobNotFoundException
    {
        for (Job job : JOB_DATABASE)
        {
            if (job.getId() == id)
            {
                JOB_DATABASE.remove(job);
                return true;
            }
        }
        throw new JobNotFoundException(id);
    }
}
