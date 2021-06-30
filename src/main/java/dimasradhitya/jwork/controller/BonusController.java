package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi controller bonus
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {
    /**
     * method mapping untuk mendapatkan database bonus
     * @return database bonus
     */
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus(){
        return DatabaseBonus.getBonusDatabase();
       
        /* return DatabaseBonusPostgre.getDatabaseBonus(); */
    }

    /**
     * method mapping untuk mendapatkan database bonus didapatkan dari referral code
     * @param referralCode
     * @return database bonus berdasarkan referral code
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        return DatabaseBonus.getBonusByReferralCode(referralCode);
       
        /* return DatabaseBonusPostgre.getBonusByReferralCode(referralCode); */
    }

    /**
     * method mapping untuk post bonus
     * @param referralCode
     * @param extraFee
     * @param minTotalFee
     * @param active
     * @return menambahkan database bonus
     * @throws ReferralCodeAlreadyExistsException
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                          @RequestParam(value="extraFee") int extraFee,
                          @RequestParam(value="minTotalFee") int minTotalFee,
                          @RequestParam(value="active") boolean active)
            throws ReferralCodeAlreadyExistsException{
                
                Bonus bonus = new Bonus(DatabaseBonus.getLastId()+1, extraFee, minTotalFee, referralCode, active);
            try {
                DatabaseBonus.addBonus(bonus);
                return bonus;
            } catch (ReferralCodeAlreadyExistsException e) {
                e.getMessage();
                return null;
            }
           
            /* return DatabaseBonusPostgre.addBonus(referralCode, extraFee, minTotalFee,active); */
    }
}
