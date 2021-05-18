package dimasradhitya.jwork;

/**
 * Enumeration class JobCategory - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum JobCategory
{
    WebDeveloper("Web Developer"),
    FrondEnd("Front End"),
    BackEnd("Back End"),
    UI("UI"),
    UX("UX"),
    Devops("Devops"),
    DataScientist("Data Scientist"),
    DataAnalyst("Data Analyst");

    private String category;

    JobCategory(String category)
    {
        this.category = category;
    }

    public String toString()
    {
        return category;
    } 
}
