package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Write a description of class DatabaseBonus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseBonus
{
    // Mendefinisikan variabel
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;


    /**
     * getter list object Database Job
     * @return nilai null
     */
    public static ArrayList<Bonus> getBonusDatabase(){
        return BONUS_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    /**
     * getter objek Database Job
     * @return nilai null
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus val = null;
        try
        {
            for (Bonus bns : BONUS_DATABASE)
            {
                if (id == bns.getId())
                {
                    val = bns;
                }
            }
        }
        catch (Exception error)
        {
            throw new BonusNotFoundException(id);
        }
        return val;
    }

    public static Bonus getBonusByReferralCode(String referralCode){
        for (int i=0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getReferralCode()== referralCode){
                return BONUS_DATABASE.get(i);
            }
        }
        return null;
    }

    /**
     * method untuk menambahkan objek database job
     * @return nilai false
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        for (Bonus bns : BONUS_DATABASE)
        {
            if (bonus.getReferralCode() == bns.getReferralCode())
            {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    public static boolean activeBonus(int id){
        for (int i = 0; i < BONUS_DATABASE.size(); i++) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivateBonus(int id){
        for (int i = 0; i < BONUS_DATABASE.size(); i++) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * method untuk menghapus objek database job
     * @return nilai false
     */
    public static boolean removeBonus(int id) throws JobNotFoundException {
        for (Bonus bns : BONUS_DATABASE)
        {
            if (bns.getId() == id)
            {
                BONUS_DATABASE.remove(bns);
                return true;
            }
        }
        throw new JobNotFoundException(id);
    }
}
