package dimasradhitya.jwork;

import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Bonus
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseBonus
{
    // Mendefinisikan variabel
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;


    /** 
     * method yang digunakan untuk mendapatkan Bonus
     * @return ArrayList<Bonus> mengebalikan nilai array yang berisi Bonus
     */
    public static ArrayList<Bonus> getBonusDatabase(){
        return BONUS_DATABASE;
    }

    /**
     * method yang digunakan untuk mendapatkan last id bonus
     * @return last id
     */
    public static int getLastId(){
        return lastId;
    }

    /** 
     * method yang digunakan untuk mendapatkan bonus didapatkan dari id
     * @param id int id
     * @return int mengebalikan nilai id
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

    /** 
     * method yang digunakan untuk mendapatkan bonus didapatkan dari referral code
     * @param referralCode string referral code
     * @return string mengebalikan nilai referral code
     */
    public static Bonus getBonusByReferralCode(String referralCode){
        for (int i=0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getReferralCode().equals(referralCode)){
                return BONUS_DATABASE.get(i);
            }
        }
        return null;
    }

    /** 
     * method yang digunakan untuk menambah bonus
     * @param bonus menerima objek bonus
     * @return booelan untuk menambahkan bonus
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

    /**
     * method untuk mengaktifkan bonus
     * @param id
     * @return
     */
    public static boolean activeBonus(int id){
        for (int i = 0; i < BONUS_DATABASE.size(); i++) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * method untuk menonaktifkan bonus
     * @param id
     * @return
     */
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
     * method yang digunakan untuk menghapus bonus
     * @param id
     * @return
     * @throws JobNotFoundException
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
