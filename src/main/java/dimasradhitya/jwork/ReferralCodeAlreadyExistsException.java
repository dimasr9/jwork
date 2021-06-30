package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Referral Code Already Exists Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class ReferralCodeAlreadyExistsException extends Exception {
    private Bonus referral_error;

    public ReferralCodeAlreadyExistsException(Bonus referral_input){
        super("Referral Code: ");
        referral_error = referral_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " Already Exist";
    }
}
