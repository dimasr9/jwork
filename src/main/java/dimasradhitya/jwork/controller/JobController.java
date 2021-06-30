package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {
    @RequestMapping("")
    public ArrayList<Job> getAllJob(){
        ArrayList<Job> job = null;
        job = DatabaseJob.getJobDatabase();
        return job;
    }

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

    @RequestMapping(value = "/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJob.getJobByRecruiter(recruiterId);
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value="category") JobCategory category,
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
    }
}
