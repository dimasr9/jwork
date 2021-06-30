package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Email Already Exists Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class EmailAlreadyExistsException extends Exception {
    private Jobseeker jobseeker_error;

    public EmailAlreadyExistsException(Jobseeker jobseeker_input){
        super("Recruiter Email: ");
        jobseeker_error = jobseeker_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + "Already Exist";
    }
}
