package dimasradhitya.jwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

/**
 * Class yang menyimpan fungsi-fungsi Database Invoice Postgresql
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class DatabaseInvoicePostgre extends DatabaseConnectionPostgre
{
    /**
     * method yang digunakan untuk menambah invoice
     * @return boolean
     * @param invoice object invoice
     * @throws SQLException
     */
    public static boolean addInvoice(Invoice invoice) throws SQLException {
        Connection c = connection();
        PreparedStatement statement;

        Statement statement1 = c.createStatement();
        String sql = "SELECT COUNT(invoicestatus) FROM invoice WHERE jobseeker_id = "+invoice.getJobseeker().getId() +" AND invoicestatus = 'OnGoing';";
        ResultSet resultSet = statement1.executeQuery(sql);
        while (resultSet.next()) {
            if (resultSet.getInt("count") > 0) {
                return false;
            } else {
                break;
            }

        }

        sql = "INSERT INTO invoice( jobseeker_id, totalfee, adminfee, bonus_id, invoicestatus, payment, job_id) VALUES (?,?,?,?,?::invoicestat,?::payment_type,?::integer[]);";
        statement = c.prepareStatement(sql);
        statement.setInt(1, invoice.getJobseeker().getId());
        statement.setInt(2, invoice.getTotalFee());
        statement.setString(5, invoice.getInvoiceStatus().toString());
        statement.setString(6, invoice.getPaymentType().toString());
        statement.setString(7, Arrays.toString(invoice.getJobs().stream().map(job -> job.getId()).toArray()).replace("[" , "{").replace("]", "}") );
        if (invoice.getPaymentType() == PaymentType.EwalletPayment) {
            EwalletPayment ewalletPayment = (EwalletPayment) invoice;
            statement.setInt(4, ewalletPayment.getId());
            statement.setNull(3, Types.INTEGER);
        }
        else {
            BankPayment bankPayment = (BankPayment) invoice;
            statement.setInt(3, bankPayment.getAdminFee());
            statement.setNull(4, Types.INTEGER);
        }

        return statement.executeUpdate() != 0 ? true:false;
    }

    /**
     * method yang digunakan untuk mendapatkan invoice berdasarkan id
     * @return Invoice
     * @param id int id dari invoice
     * @throws SQLException
     */
    public static Invoice getInvoiceById(int id) throws SQLException {
        Connection c = connection();

       Invoice invoice = null;


        Statement statement = c.createStatement();
        String sql = "SELECT * FROM invoice WHERE id = "+ id + ";";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id_invoice = resultSet.getInt("id");
            Jobseeker jobseeker = DatabaseJobseekerPostgre.getJobseeker(resultSet.getInt("jobseeker_id"));
            String dateStr = resultSet.getString("invoicedate");
            Date invoiceDate = Date.valueOf(dateStr);
            int totalfee = resultSet.getInt("totalfee");
            String invoiceStatus = resultSet.getString("invoicestatus");
            InvoiceStatus status = InvoiceStatus.valueOf(invoiceStatus);
            PaymentType paymentType = PaymentType.valueOf(resultSet.getString("payment"));
            ArrayList<Job> jobs = Arrays.stream(((Integer[]) resultSet.getArray("job_id").getArray())).map(integer -> DatabaseJobPostgre.getJobById(integer)).collect(Collectors.toCollection(ArrayList::new));
            if (paymentType == PaymentType.EwalletPayment) {
                invoice = new EwalletPayment(id_invoice, jobs, jobseeker, DatabaseBonusPostgre.getBonusById(resultSet.getInt("bonus_id")) );
            } else {

                invoice = new BankPayment(id_invoice, jobs, jobseeker, resultSet.getInt("adminfee"));
            }
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(invoiceDate);
            invoice.setDate(calendar);

            invoice.setTotalFee(totalfee);
            invoice.setInvoiceStatus(status);
        }
        return invoice;
    }

    /**
     * method yang digunakan untuk mendapatkan invoice berdasarkan jobseeker
     * @return ArrayList invoice
     * @param jobseekerId id dari jobseeker
     * @throws SQLException
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId) throws SQLException {
        Connection c = connection();

        ArrayList<Invoice> invoices = new ArrayList<>();



        Statement statement = c.createStatement();
        String sql = "SELECT * FROM invoice WHERE jobseeker_id = "+ jobseekerId + ";";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Invoice invoice = null;
            int id_invoice = resultSet.getInt("id");
            Jobseeker jobseeker = DatabaseJobseekerPostgre.getJobseeker(resultSet.getInt("jobseeker_id"));
            String dateStr = resultSet.getString("invoicedate");
            Date invoiceDate = Date.valueOf(dateStr);
            int totalfee = resultSet.getInt("totalfee");
            String invoiceStatus = resultSet.getString("invoicestatus");
            InvoiceStatus status = InvoiceStatus.valueOf(invoiceStatus);
            PaymentType paymentType = PaymentType.valueOf(resultSet.getString("payment"));
            ArrayList<Job> jobs = Arrays.stream(((Integer[]) resultSet.getArray("job_id").getArray())).map(integer -> DatabaseJobPostgre.getJobById(integer)).collect(Collectors.toCollection(ArrayList::new));
            if (paymentType == PaymentType.EwalletPayment) {
                invoice = new EwalletPayment(id_invoice, jobs, jobseeker, DatabaseBonusPostgre.getBonusById(resultSet.getInt("bonus_id")) );
            } else {

                invoice = new BankPayment(id_invoice, jobs, jobseeker, resultSet.getInt("adminfee"));
            }
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(invoiceDate);
            invoice.setDate(calendar);

            invoice.setTotalFee(totalfee);
            invoice.setInvoiceStatus(status);
            invoices.add(invoice);
        }
        return invoices;
    }

    /**
     * method yang digunakan untuk mengubah invoice
     * @return boolean
     * @param invoice object invoice
     * @throws SQLException
     */
    public static boolean changeInvoice(Invoice invoice) throws SQLException {
        Connection c = connection();

        Statement statement = c.createStatement();
        String sql = "UPDATE  invoice SET invoicestatus = '" + invoice.getInvoiceStatus().toString() + "' WHERE id =  " + invoice.getId() + ";";

        return statement.executeUpdate(sql) != 0 ? true:false;
    }
}