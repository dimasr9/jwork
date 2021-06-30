package dimasradhitya.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Recruiter dengan koneksi ke Postgresql
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */

public class DatabaseRecruiterPostgre extends DatabaseConnectionPostgre
{
    /**
     * method yang digunakan untuk mendapatkan database recruiter
     * @return arraylist recruiter
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        Connection c = connection();
        PreparedStatement statement;

        ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();
        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        String province = null;
        String city = null;
        String description = null;
        Recruiter recruiter = null;
        try {
            String sql = "SELECT id, name, email, phone_number, (location).province, (location).city, (location).description FROM recruiter;";
            statement = c.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                phoneNumber = resultSet.getString("phone_number");
                province = resultSet.getString("province");
                city = resultSet.getString("city");
                description = resultSet.getString("description");

                Location location = new Location(province, city, description);
                recruiter = new Recruiter(id, name, email, phoneNumber, location);
                RECRUITER_DATABASE.add(recruiter);
            }
            statement.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return RECRUITER_DATABASE;
    }

    /**
     * method yang digunakan untuk menambahkan recruiter database
     * @return Recruiter
     * @param recruiter objek recruiter
     */
    public static Recruiter addRecruiter(Recruiter recruiter)
    {
        Connection c = connection();
        PreparedStatement statement;
        String name = recruiter.getName();
        String email = recruiter.getEmail();
        String phoneNumber = recruiter.getPhoneNumber();
        String province = recruiter.getLocation().getProvince();
        String description = recruiter.getLocation().getDescription();
        String city = recruiter.getLocation().getCity();
        Location location = new Location(province, description, city);

        try {
            String sql = "INSERT INTO recruiter(name, email, phone_number, location) VALUES (?, ?, ?, ROW(?,?,?)) RETURNING id;";
            statement = c.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2,email);
            statement.setString(3,phoneNumber);
            statement.setString(4, location.getProvince());
            statement.setString(5, location.getCity());
            statement.setString(6, location.getDescription());
            ResultSet resultSet = statement.executeQuery();
            int id = 1;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            recruiter = new Recruiter(id, name, email, phoneNumber, location);
            statement.close();
            c.close();
            return recruiter;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recruiter;
    }

    /**
     * method yang digunakan untuk mendapatkan recruiter berdasarkan id
     * @return Recruiter
     * @param id_recruiter id recruiter yang ingin di dapatkan
     */
    public static Recruiter getRecruiterById(int id_recruiter)
    {
        Connection c = connection();
        PreparedStatement statement;

        int id = 0;
        String name = null;
        String email = null;
        String phoneNumber = null;
        String province = null;
        String city = null;
        String description = null;
        Location location = null;
        Recruiter recruiter = null;

        try {
            String sql = "SELECT id, name, email, phone_number, (location).province, (location).city, (location).description FROM recruiter WHERE id = ?;";
            statement = c.prepareStatement(sql);
            statement.setInt(1, id_recruiter);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                phoneNumber = resultSet.getString("phone_number");
                province = resultSet.getString("province");
                city = resultSet.getString("city");
                description = resultSet.getString("description");

                location = new Location(province, city, description);
            }
            statement.close();
            c.close();
            recruiter = new Recruiter(id, name, email, phoneNumber, location);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recruiter;
    }

}