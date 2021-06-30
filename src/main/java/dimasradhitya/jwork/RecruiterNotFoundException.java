package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Recruiter Not Found Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class RecruiterNotFoundException extends Exception {
    private int recruiter_error;

    public RecruiterNotFoundException(int recruiter_input){
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + recruiter_error + "Not Found";
    }
}
