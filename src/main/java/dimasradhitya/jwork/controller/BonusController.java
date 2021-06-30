package dimasradhitya.jwork.controller;

import dimasradhitya.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus(){
        return DatabaseBonusPostgre.getDatabaseBonus();
    }

    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        return DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                          @RequestParam(value="extraFee") int extraFee,
                          @RequestParam(value="minTotalFee") int minTotalFee,
                          @RequestParam(value="active") boolean active)
            throws ReferralCodeAlreadyExistsException{
                return DatabaseBonusPostgre.addBonus(referralCode, extraFee,minTotalFee,active);
    }
}
