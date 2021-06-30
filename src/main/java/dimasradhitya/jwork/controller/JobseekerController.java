package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import static dimasradhitya.jwork.DatabaseConnectionPostgre.connection;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        return DatabaseJobseekerPostgre.getJobseeker(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        return DatabaseJobseekerPostgre.insertJobSeeker(name, email, password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                       @RequestParam(value="password") String password)
    {
        return DatabaseJobseekerPostgre.getJobseeker(email, password);
    }
}
