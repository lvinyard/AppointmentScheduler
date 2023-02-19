package model;

import java.sql.Timestamp;
import java.text.DateFormat;

/**
 * This class is the model for Countries in the database
 */
public class Countries {
    private int Country_Id;
    private String Country;
    private Timestamp Create_Date;
    private String Created_By;
    private Timestamp Last_Update;
    private String Updated_By;

    /**
     * Create new Country
     * @param country_Id
     * @param country
     * @param create_Date
     * @param created_By
     * @param last_Update
     * @param updated_By
     */
    public Countries(int country_Id, String country, Timestamp create_Date, String created_By, Timestamp last_Update, String updated_By){
        this.Country_Id = country_Id;
        this.Country = country;
        this.Create_Date = create_Date;
        this.Created_By = created_By;
        this.Last_Update = last_Update;
        this.Updated_By = updated_By;
    }

    /**
     * Get Country Id
     * @return
     */
    public int getCountry_Id() {
        return Country_Id;
    }

    /**
     * Set Country Id
     * @param country_Id
     */
    public void setCountry_Id(int country_Id) {
        Country_Id = country_Id;
    }

    /**
     * Get Country
     * @return
     */
    public String getCountry() {
        return Country;
    }

    /**
     * Set Country
     * @param country
     */
    public void setCountry(String country) {
        Country = country;
    }

    /**
     * Get Create Date
     * @return
     */
    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    /**
     * Set create Date
     * @param create_Date
     */
    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    /**
     * Get Created By
     * @return
     */
    public String getCreated_By() {
        return Created_By;
    }

    /**
     * Set Created By
     * @param created_By
     */
    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    /**
     * Get Last Update
     * @return
     */
    public Timestamp getLast_Update() {
        return Last_Update;
    }

    /**
     * Set Last update
     * @param last_Update
     */
    public void setLast_Update(Timestamp last_Update) {
        Last_Update = last_Update;
    }

    /**
     * Get updated by
     * @return
     */
    public String getUpdated_By() {
        return Updated_By;
    }

    /**
     * Set updated by
     * @param updated_By
     */
    public void setUpdated_By(String updated_By) {
        Updated_By = updated_By;
    }
}
