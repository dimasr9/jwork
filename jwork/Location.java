
/**
 * Write a description of class Location here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String province, city, description;

    /**
     * Constructor for objects of class Location
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getProvince()
    {
        // put your code here
        return this.province;
    }
    
    public String getCity()
    {
        // put your code here
        return this.city;
    }
    
    public String getDescription()
    {
        // put your code here
        return this.description;
    }
    
    public void setProvince(String province)
    {
        // put your code here
        this.province = province;
    }
    
    public void setCity(String city)
    {
        // put your code here
        this.city = city;
    }
    
    public void setDescription(String description)
    {
        // put your code here
        this.description = description;
    }
    
    public void printData(){
        System.out.println(getProvince());
    }
}
