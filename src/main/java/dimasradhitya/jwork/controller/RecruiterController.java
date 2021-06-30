package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi controller recruiter
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * mapping untuk mendapatkan database recruiter
     * @return database recruiter
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Recruiter> getAllRecruiter(){
        return DatabaseRecruiter.getRecruiterDatabase();
    }

    /**
     * mapping untuk mendapatkan database recruiter dari id
     * @param id
     * @return database recruiter
     * @throws RecruiterNotFoundException
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter rctr = null;
        try {
            rctr = DatabaseRecruiter.getRecruiterById(id);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }
        return rctr;
    }

    /**
     * method mapping untuk post recruiter
     * @param name
     * @param email
     * @param phoneNumber
     * @param province
     * @param city
     * @param description
     * @return database recruiter
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value ="name") String name,
                                  @RequestParam(value ="email") String email,
                                  @RequestParam(value ="phoneNumber") String phoneNumber,
                                  @RequestParam(value ="province") String province,
                                  @RequestParam(value ="city") String city,
                                  @RequestParam(value ="description") String description){
        Location location = new Location(province, city, description);
        Recruiter rctr = new Recruiter(DatabaseRecruiter.getLastId()+1, name, email, phoneNumber, location);

        if (DatabaseRecruiter.addRecruiter(rctr)){
            return rctr;
        }
        else{
            return null;
        }
    }
}
