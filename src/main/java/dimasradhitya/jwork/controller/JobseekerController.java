package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

/**
 * Class yang menyimpan fungsi-fungsi controller jobseeker
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * mapping untuk tes koneksi
     * @param name
     * @return Hello 'nama'
     */
    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    /**
     * mapping untuk mendapatkan database jobseeker dari id
     * @param id
     * @return database jobseeker
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        return DatabaseJobseekerPostgre.getJobseeker(id);
    }

    /**
     * mapping untuk register
     * @param name
     * @param email
     * @param password
     * @return database jobseeker
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        return DatabaseJobseekerPostgre.insertJobSeeker(name, email, password);
    }

    /**
     * mapping untuk melakukan login
     * @param email
     * @param password
     * @return database jobseeker
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                       @RequestParam(value="password") String password)
    {
        return DatabaseJobseekerPostgre.getJobseeker(email, password);
    }
}
