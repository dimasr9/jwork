package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus(){
        ArrayList<Bonus> bonus = null;
        bonus = DatabaseBonus.getBonusDatabase();
        return bonus;
    }

    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        Bonus bonus = null;
        bonus = DatabaseBonus.getBonusByReferralCode(referralCode);
        return bonus;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                          @RequestParam(value="extraFee") int extraFee,
                          @RequestParam(value="minTotalFee") int minTotalFee,
                          @RequestParam boolean active)
            throws ReferralCodeAlreadyExistsException{
        Bonus bonus = new Bonus(DatabaseBonus.getLastId()+1, minTotalFee, extraFee, referralCode, active);
        if (DatabaseBonus.addBonus(bonus)){
            return bonus;
        }
        else{
            return null;
        }
    }
}
