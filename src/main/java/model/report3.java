package model;

/**
 * This model represents the data for report 3
 */
public class report3 {
    private int Division_Id;
    private int Count;

    /**
     * Create Model for report 3
     * @param Division_Id
     * @param count
     */
    public report3(int Division_Id, int count){
        this.Division_Id = Division_Id;
        this.Count   = count;
    }

    /**
     * Get Division Id
     * @return
     */
    public int getDivision_Id() {
        return Division_Id;
    }

    /**
     * Set Division Id
     * @param division_Id
     */
    public void setDivision_Id(int division_Id) {
        Division_Id = division_Id;
    }

    /**
     * Get Count
     * @return
     */
    public int getCount() {
        return Count;
    }

    /**
     * Set Count
     * @param count
     */
    public void setCount(int count) {
        Count = count;
    }
}
