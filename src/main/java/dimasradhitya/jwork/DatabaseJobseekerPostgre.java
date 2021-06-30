package dimasradhitya.jwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class yang menyimpan fungsi-fungsi Database Jobseeker dengan koneksi Posgresql
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */

import static dimasradhitya.jwork.DatabaseConnectionPostgre.connection;
public class DatabaseJobseekerPostgre {
    /**
     * method yang digunakan untuk menambahkan jobseeker
     * @return Jobseeker
     * @param name string nama jobseeker
     * @param email string email jobseeker
     * @param password string password jobseeker
     */
    public static Jobseeker insertJobSeeker(String name, String email, String password)
    {
        // Cek Email
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z[0-9]]{6,}$");
        Matcher matcher = p.matcher(password);
        if(!matcher.matches()){
            return null;
        }

        // Cek password
        p = Pattern.compile("(?!.*\\.{2,})(?!\\.)[0-9A-z.&*_~]+@(?!-)[0-9A-z&*_~.-]+");
        matcher = p.matcher(email);
        if(!matcher.matches()){
            return null;
        }

        Connection c = connection();
        PreparedStatement statement;
        Jobseeker jobseeker = null;
        try {
            String sql = "INSERT INTO jobseeker(name, email, password) VALUES (?,?,?) RETURNING id;";
            statement = c.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            ResultSet resultSet = statement.executeQuery();
            int id = 1;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            jobseeker = new Jobseeker(id, name, email, password);
            statement.close();
            c.close();
            return jobseeker;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobseeker;
    }

    /**
     * method yang digunakan untuk mendapatkan id terakhir jobseeker
     * @return int id jobseeker terakhir
     */
    public static int getLastJobseekerId()
    {
        Connection c = connection();
        PreparedStatement statement;
        int id = 0;
        try {
            String sql = "SELECT id FROM jobseeker ORDER BY id DESC LIMIT 1;";
            statement = c.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            statement.close();
            c.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * method yang digunakan untuk mendapatkan database jobseeker
     * @return arraylist jobnseeker
     */
    public static ArrayList<Jobseeker> getDatabaseJobseeker()
    {
        Connection c = connection();
        PreparedStatement statement = null;

        ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Jobseeker jobseeker = null;
        try {
            String sql = "SELECT * FROM jobseeker;";
            statement = c.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                jobseeker = new Jobseeker(id, name, email, password);
                JOBSEEKER_DATABASE.add(jobseeker);
            }
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JOBSEEKER_DATABASE;
    }

    /**
     * method yang digunakan untuk menghapus jobseeker dari databse jobseeker
     * @return Boolean
     * @param id id jobseeker yang ingin dihapus
     */
    public static Boolean removeJobseeker(int id)
    {
        Connection c = connection();
        PreparedStatement statement;
        try {
            String sql = "DELETE FROM jobseeker WHERE id = ?;";
            statement = c.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            c.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * method yang digunakan untuk mendapatkan jobseeker
     * @return Jobseeker
     * @param email2 email jobseeker
     * @param password2 password jobseeker
     */
    public static Jobseeker getJobseeker(String email2, String password2)
    {
        Connection c = connection();
        PreparedStatement statement;
        Calendar joinDate = new GregorianCalendar();
        Jobseeker jobseeker = null;

        try {
            String sql = "SELECT id, name, email, password, joinDate FROM jobseeker WHERE email =? AND password = ?;";
            statement = c.prepareStatement(sql);
            statement.setString(1, email2);
            statement.setString(2, password2);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Date tanggal = resultSet.getDate("joinDate");
                jobseeker = new Jobseeker(id, name, email, password);

                joinDate.setTime(tanggal);
                jobseeker.setJoinDate(joinDate);
            }
            statement.close();
            c.close();
            return jobseeker;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return jobseeker;
    }

    /**
     * method yang digunakan untuk mendapatkan jobseeker berdasarkan id nya
     * @return Jobseeker
     * @param id_jobseeker id jobseeker
     */
    public static Jobseeker getJobseeker(int id_jobseeker)
    {
        Connection c = connection();
        PreparedStatement statement;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Jobseeker jobseeker = null;

        try {
            String sql = "SELECT * FROM jobseeker WHERE id = ?;";
            statement = c.prepareStatement(sql);
            statement.setInt(1, id_jobseeker);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
            }
            statement.close();
            c.close();
            jobseeker = new Jobseeker(id, name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobseeker;
    }
}