package dimasradhitya.jwork;

/**
 * Class yang menyimpan tipe data kategori enum dari job
 *
 * @author Dimas Radhitya
 * @version 30 Juni 2021
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
