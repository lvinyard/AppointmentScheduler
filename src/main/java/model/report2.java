package model;

import java.util.Date;

/**
 * This model represents the data for report 2
 */
public class report2 {
    private String Month;
    private String Type;
    private int Count;

    /**
     * Create report 2 model
     * @param month
     * @param type
     * @param count
     */
    public report2(String month, String type, int count){
        this.Month = month;
        this.Type = type;
        this.Count   = count;
    }

    /**
     * Get Month
     * @return
     */
    public String getMonth() {
        return Month;
    }

    /**
     * Set Month
     * @param month
     */
    public void setMonth(String month) {
        Month = month;
    }

    /**
     * Get Type
     * @return
     */
    public String getType() {
        return Type;
    }

    /**
     * Set type
     * @param type
     */
    public void setType(String type) {
        Type = type;
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
