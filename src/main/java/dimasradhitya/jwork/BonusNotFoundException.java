package dimasradhitya.jwork;

/**
 * Class yang menyimpan fungsi-fungsi Bonus Exception
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class BonusNotFoundException extends Exception {
    private int bonus_error;

    /**
     * Constructor untuk Bonus not found exception
     * @param bonus_input
     */
    public BonusNotFoundException(int bonus_input){
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + bonus_error + "Not Found";
    }
}
