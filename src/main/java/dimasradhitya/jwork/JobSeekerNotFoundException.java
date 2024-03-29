package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Job Seeker Not Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class JobSeekerNotFoundException extends Exception {
    private int jobseeker_error;

    public JobSeekerNotFoundException(int jobseeker_input){
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + jobseeker_error + "Not Found";
    }
}
