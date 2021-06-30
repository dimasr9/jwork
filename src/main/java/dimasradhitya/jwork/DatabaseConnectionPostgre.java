package dimasradhitya.jwork;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class yang menyimpan fungsi-fungsi Database Connection dengan koneksi ke Postgresql
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseConnectionPostgre {

    /**
     * method connection untuk menginisiasi koneksi ke database Postgresql
     * @return data koneksi ke postgre
     */
    public static Connection connection() {
        Connection c = null;
        String db_name = "jwork";
        String db_user = "postgres";
        String db_password = "dimasr";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db_name, db_user, db_password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}