
/**
 *
 * @author Dimas Radhitya
 * @version Modul 2 - 25 Maret 2021
 */
public class DatabaseRecruiter
{
    // Mendefinisikan variabel
    private String[] listRecruiter;
    /**
     * Constructor untuk object dari class DatabaseRecruiter
     * @param province provinsi dari lokasi
     * @param city kota dari lokasi
     * @param description deskripsi dari lokasi
     */
    public DatabaseRecruiter(){
    }
    
    /**
     * method untuk menambahkan objek pada database recruiter
     * @return nilai false
     */
    public static boolean addRecruiter(Recruiter recruiter){
        return false;
    }
    
    /**
     * method untuk menghapus objek pada database recruiter
     * @return nilai false
     */
    public boolean removeJob(Recruiter recruiter){
       return false;
    }
    
    /**
     * getter objek recruiter
     * @return nilai null
     */
    public Job getRecruiter(){
       return null; 
    }
    
    /**
     * getter list object recruiter
     * @return nilai null
     */
    public String[] getListRecruiter(){
       return null; 
    } 
}
