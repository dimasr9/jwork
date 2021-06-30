package dimasradhitya.jwork;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class yang menyimpan fungsi-fungsi Database Job dengan koneksi Postgresql
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */

public class DatabaseJobPostgre extends DatabaseConnectionPostgre
{
    /**
     * method yang digunakan untuk mendapatkan database job
     * @return arraylist job
     */
    public static ArrayList<Job> getAllJob()
    {
        Connection c = connection();
        PreparedStatement stmt;

        ArrayList<Job> JOB_DATABASE = new ArrayList<>();
        int id = 0;
        int fee = 0;
        int recruiter_id = 0;
        String name = null;
        String category = null;
        JobCategory jobCategory = null;
        Recruiter recruiter = null;

        try {
            String sql = "SELECT * FROM job;";
            stmt = c.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                recruiter_id = resultSet.getInt("recruiter_id");
                fee = resultSet.getInt("fee");
                category = resultSet.getString("job_category");
                jobCategory = JobCategory.valueOf(category);
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiter_id);

                Job job = new Job(id, name, recruiter, fee, jobCategory);
                JOB_DATABASE.add(job);
            }
            stmt.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return JOB_DATABASE;

    }

    /**
     * method yang digunakan untuk mendapatkan last id dari job
     * @return int lastid
     */
    public static int getLastJobId()
    {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;

        try {
            String sql = "SELECT id FROM job ORDER BY id DESC LIMIT 1";
            stmt = c.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            stmt.close();
            c.close();
            return id;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    /**
     * method yang digunakan untuk menambah job ke database
     * @return object job
     * @param job menerima parameter objek job
     */
    public static Job addJob(Job job)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Job jobs = null;
        int fee = job.getFee();
        String name = job.getName();
        JobCategory category = job.getCategory();
        Recruiter recruiter = job.getRecruiter();


        try {
            String sql = "INSERT INTO job(id, name, recruiter_id, fee, job_category) VALUES (?,?,?,?,?::job_category);";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, job.getId());
            stmt.setString(2, name);
            stmt.setInt(3, recruiter.getId());
            stmt.setInt(4,fee);
            stmt.setString(5, category.toString());
            int update = stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            int id = 1;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            job = new Job(id, name, recruiter, fee, category);
            stmt.close();
            c.close();
            return job;

        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
        }
        return job;
    }

    /**
     * method yang digunakan untuk mendapatkan job berdasarkan category
     * @return arraylist job
     * @param category kategori job
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        Connection c = connection();
        PreparedStatement stmt;
        ArrayList<Job> job = new ArrayList<>();

        try {
            String sql = "SELECT * FROM job WHERE job_category = ?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, category.name());
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int recruiterId = resultSet.getInt("recruiter_id");
                int fee = resultSet.getInt("fee");
                String job_category = resultSet.getString("job_category");
                JobCategory  jobCategory = JobCategory.valueOf(job_category);
                Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);

                Job job1 = new Job(id, name, recruiter, fee, jobCategory);
                job.add(job1);
            }
            stmt.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return job;
    }

    /**
     * method yang digunakan untuk mendapatkan job berdasarkan recruiternya
     * @return job
     * @param recruiterId id dari recruiter
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        Connection c = connection();
        PreparedStatement stmt;
        ArrayList<Job> job = new ArrayList<>();

        try {
            String sql = "SELECT * FROM job WHERE recruiter_id = ?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, recruiterId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                recruiterId = resultSet.getInt("recruiter_id");
                int fee = resultSet.getInt("fee");
                String category_string = resultSet.getString("job_category");
                JobCategory category = JobCategory.valueOf(category_string);
                Recruiter recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);

                Job job1 = new Job(id, name, recruiter, fee, category);
                job.add(job1);
            }
            stmt.close();
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return job;
    }

    /**
     * method yang digunakan untuk menghapus job
     * @return boolean
     * @param id menerima id dari job
     */
    public static boolean removeJob(int id)
    {
        Connection c = connection();
        PreparedStatement stmt;

        try {
            String sql = "DELETE FROM job WHERE id = ?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            stmt.close();
            c.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * method yang digunakan untuk mendapatkan job berdasarkan id job
     * @return job yang akan dihapus
     * @param jobId id job
     */
    public static Job getJobById(int jobId)
    {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        int fee = 0;
        String name = null;
        JobCategory category = null;
        Recruiter recruiter = null;
        Job job1 = null;
        try {
            String sql = "SELECT * FROM job WHERE id = ?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, jobId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                int recruiterId = resultSet.getInt("recruiter_id");
                fee = resultSet.getInt("fee");
                String category_string = resultSet.getString("job_category");
                category = JobCategory.valueOf(category_string);
                recruiter = DatabaseRecruiterPostgre.getRecruiterById(recruiterId);

                job1 = new Job(id, name, recruiter, fee, category);
            }
            stmt.close();
            c.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return job1;
    }
}