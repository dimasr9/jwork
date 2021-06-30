package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi controller job
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * mapping untuk mendapatkan database job
     * @return database job
     */
    @RequestMapping("")
    public ArrayList<Job> getAllJob(){
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobDatabase();
        return job;
    }

    /**
     * mapping untuk mendapatkan database job dari id
     * @param id
     * @return database job
     * @throws JobNotFoundException
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job js = null;
        try {
            js = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return js;
    }

    /**
     * mapping untuk mendapatkan database job dari recruiter id
     * @param recruiterId
     * @return database job
     */
    @RequestMapping(value = "/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJob.getJobByRecruiter(recruiterId);
       
        /* return DatabaseJobPostgre.getJobByRecruiter(recruiterId); */
    }

    /**
     * mapping untuk mendapatkan database job dari category
     * @param category
     * @return database job
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
       
        /* return DatabaseJobPostgre.getJobByCategory(category); */
    }

    /**
     *  mapping untuk menambahkan database job
     * @param name
     * @param fee
     * @param category
     * @param recruiterId
     * @return menambahkan database job
     * @throws RecruiterNotFoundException
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value="category") JobCategory category, //String category, 
                      @RequestParam(value="recruiter id") int recruiterId)
            throws RecruiterNotFoundException{
        Recruiter rctr = null;
        try {
            rctr = DatabaseRecruiter.getRecruiterById(recruiterId);
        } catch (RecruiterNotFoundException error)
        {
            throw error;
        }
        Job job = new Job(DatabaseJob.getLastId(), name, rctr, fee, category);
        boolean success = DatabaseJob.addJob(job);

        if (success){
            return job;
        }
        else{
            return null;
        }
        /* Job job = new Job(DatabaseJobPostgre.getLastJobId()+1, name,  DatabaseRecruiterPostgre.getRecruiterById(recruiterId), fee, JobCategory.valueOf(category));

        return DatabaseJobPostgre.addJob(job); */
    }
}
