package dimasradhitya.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Bonus dengan koneksi ke Postgresql
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseBonusPostgre extends DatabaseConnectionPostgre
{
    private static ArrayList<Bonus> DATABASE_BONUS = new ArrayList<>();

    /**
     * method yang digunakan untuk mendapatkan database bonus
     * @return ArrayList mengebalikan arraylist bonus
     */
    public static ArrayList<Bonus> getDatabaseBonus()
    {
        Connection c = connection();
        PreparedStatement statement;
        int id = 0;
        String referralCode = null;
        int extraFee = 0;
        int minTotalFee = 0;
        boolean active = false;
        Bonus bonus = null;

        try {
            String sql = "SELECT * FROM bonus;";
            statement = c.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                extraFee = resultSet.getInt("extrafee");
                minTotalFee = resultSet.getInt("mintotalfee");
                referralCode = resultSet.getString("referralcode");
                active = resultSet.getBoolean("active");
                bonus = new Bonus(id, extraFee, minTotalFee ,referralCode, active);
                DATABASE_BONUS.add(bonus);
            }
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DATABASE_BONUS;
    }

    /**
     * method yang digunakan untuk menambah item ke database bonus
     * @return Bonus mengebalikan bonus
     * @param referralCode string referral
     * @param extraFee int extraFee
     * @param minTotalFee int minimal total fee
     * @param active boolean bonus true/false
     */
    public static Bonus addBonus(String referralCode, int extraFee, int minTotalFee, Boolean active)
    {
        Connection c = connection();
        PreparedStatement statement;
        Bonus bonus = null;

        try {
            String sql = "INSERT INTO bonus(extraFee, minTotalFee ,referralCode, active) VALUES (?, ?, ?, ?) RETURNING id;";
            statement = c.prepareStatement(sql);
            statement.setInt(1, extraFee);
            statement.setInt(2, minTotalFee);
            statement.setString(3, referralCode);
            statement.setBoolean(4, active);
            ResultSet resultSet = statement.executeQuery();

            int id = 1;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            bonus = new Bonus(id, extraFee, minTotalFee ,referralCode, active);
            statement.close();
            c.close();
            return bonus;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bonus;
    }

    /**
     * method yang digunakan untuk mendapatkan bonus didapatkan dari referralCode
     * @return Bonus mengembalikkan bonus
     * @param referralCode String referral
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Connection c = connection();
        PreparedStatement statement;
        int id = 0;
        String codeReferral = null;
        int extraFee = 0;
        int minTotalFee = 0;
        boolean active = false;
        Bonus bonus = null;

        try {
            String sql = "SELECT * FROM bonus WHERE referralCode = ?;";
            statement = c.prepareStatement(sql);
            statement.setString(1, referralCode);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                extraFee = resultSet.getInt("extrafee");
                minTotalFee = resultSet.getInt("mintotalfee");
                codeReferral = resultSet.getString("referralcode");
                active = resultSet.getBoolean("active");
            }
            statement.close();
            c.close();
            bonus = new Bonus(id, extraFee, minTotalFee ,referralCode, active);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bonus;
    }

    /**
     * method yang digunakan untuk mendapatkan bonus didapatkan dari id
     * @return Bonus bonus
     * @param bonusId int id bonus
     */
    public static Bonus getBonusById(int bonusId)
    {
        Connection c = connection();
        PreparedStatement statement;
        int id = 0;
        String codeReferral = null;
        int extraFee = 0;
        int minTotalFee = 0;
        boolean active = false;
        Bonus bonus = null;

        try {
            String sql = "SELECT * FROM bonus WHERE id = ?;";
            statement = c.prepareStatement(sql);
            statement.setInt(1, bonusId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                extraFee = resultSet.getInt("extrafee");
                minTotalFee = resultSet.getInt("mintotalfee");
                codeReferral = resultSet.getString("referralcode");
                active = resultSet.getBoolean("active");
            }
            statement.close();
            c.close();
            bonus = new Bonus(id, extraFee, minTotalFee , codeReferral, active);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bonus;
    }

}