package dimasradhitya.jwork;

import java.util.Calendar;
import java.util.regex.*;  
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class yang menyimpan fungsi-fungsi Jobseeker
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
 */
public class Jobseeker
{
    // Mendefinisikan variabel
    private int id;
    private String name, email, password;
    private Calendar joinDate;

    /**
     * Constructor untuk object dari class Jobseeker
     * @param id id dari Jobseeker
     * @param name nama dari Jobseeker
     * @param email email dari Jobseeker
     * @param password password dari Jobseeker
     * @param joinDate tanggal masuk dari Jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        setEmail(email);
        setPassword(password);
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param email
     * @param password
     * @param year
     * @param month
     * @param dayOfMonth
     */
    public Jobseeker(int id, String name, String email, String password,
                      int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        this.setEmail(email);
        this.setPassword(password);
        this.setJoinDate(year, month, dayOfMonth);
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param email
     * @param password
     */
    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.setEmail(email);
        this.setPassword(password);
    }
    
    /**
     * getter id dari Jobseeker
     * @return id dari Jobseeker
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * getter nama dari Jobseeker
     * @return name dari Jobseeker
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * getter email dari Jobseeker
     * @return email dari Jobseeker
     */
    public String getEmail(){
        return this.email;
    }
    
    /**
     * getter password dari Jobseeker
     * @return password dari Jobseeker
     */
    public String getPassword(){
        return this.password;
    }
    
    /**
     * getter tanggal masuk dari Jobseeker
     * @return joinDate dari Jobseeker
     */
    public Calendar getJoinDate(){
        return this.joinDate;
    }
    
    /**
     * setter id dari Jobseeker
     * @param id dari Jobseeker
     */
    public void setId(int id){ 
        this.id = id;
    }
    
    /**
     * setter nama dari Jobseeker
     * @param name dari Jobseeker
     */
    public void setName(String name){ 
        this.name = name;
    }
    
    /**
     * setter email dari Jobseeker
     * @param email dari Jobseeker
     */
    public void setEmail(String email){ 
        Pattern p = Pattern.compile("^(?!.*([.])\1)[^-.@][a-zA-Z0-9.&*_~]+(?!.*([@.])\1)[^-.][a-zA-Z0-9-.&*_~]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher m = p.matcher(email);
        if (m.find()){
            this.email = email;
        }
        else{
            this.email = "";
        }
    }
    
    /**
     * setter password dari Jobseeker
     * @param password dari Jobseeker
     */
    public void setPassword(String password){ 
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$");
        Matcher m = p.matcher(password);
        if (m.find()){
            this.password = password;
        }
        else{
            this.password = "";
        }
    }
    
    /**
     * setter tanggal masuk dari Jobseeker
     * @param joinDate dari Jobseeker
     */
    public void setJoinDate(Calendar joinDate){
        this.joinDate = joinDate;
    }

    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }
    
    public String toString(){
    String joindate = "";
    String pattern = "dd MMMM yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    
        if (joinDate != null){
    Date date = joinDate.getTime();
    joindate = simpleDateFormat.format(date);
    }
    return "Id = "+ id +
           "\nNama = "+ name +
           "\nEmail = " + email +
           "\nPassword = "+ password +
           "\nJoin Date = "+ joindate;
    }
    
    /**
     * method mencetak nama dari Jobseeker
     * output adalah nama dari Jobseeker
     */
    /*public void printData(){
        System.out.println("=============JOBSEEKER==============");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        System.out.println("Password : " + password);
        System.out.println("Fee : " + joinDate);
    }*/
}
