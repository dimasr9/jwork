
/**
 *
 * @author Dimas Radhitya
 * @version Modul 2 - 25 Maret 2021
 */
public class Jobseeker
{
    // Mendefinisikan variabel
    private int id;
    private String name, email, password, joinDate;

    /**
     * Constructor untuk object dari class Jobseeker
     * @param id id dari Jobseeker
     * @param name nama dari Jobseeker
     * @param email email dari Jobseeker
     * @param password password dari Jobseeker
     * @param joinDate tanggal masuk dari Jobseeker
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * getter id dari Jobseeker
     * @return id dari Jobseeker
     */
    public int getID()
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
    public String getJoinDate(){
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
        this.email = email;
    }
    
    /**
     * setter password dari Jobseeker
     * @param password dari Jobseeker
     */
    public void setPassword(String password){ 
        this.password = password;
    }
    
    /**
     * setter tanggal masuk dari Jobseeker
     * @param joinDate dari Jobseeker
     */
    public void setJoinDate(String joinDate){ 
        this.joinDate = joinDate;
    }
    
    /**
     * method mencetak nama dari Jobseeker
     * output adalah nama dari Jobseeker
     */
    public void printData(){
        System.out.println(getName());
    }
}
