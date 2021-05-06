public class EmailAlreadyExistsException extends Exception {
    private Jobseeker jobseeker_error;

    public EmailAlreadyExistsException(Jobseeker jobseeker_input){
        super("Recruiter Email: ");
        jobseeker_input = jobseeker_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + jobseeker_error.getEmail() + "Already Exist";
    }
}
