package model;

import java.sql.Timestamp;

/**
 * This class is the model for Divisions in the database
 */
public class Divisions {
    private int Division_Id;
    private String Division;
    private Timestamp Create_Date;
    private String Created_By;
    private Timestamp Last_Update;
    private String Updated_By;
    private int Country_Id;

    /**
     * Create Division Model
     * @param division_Id
     * @param division
     * @param create_Date
     * @param created_By
     * @param last_Update
     * @param updated_By
     * @param country_Id
     */
    public Divisions(int division_Id, String division, Timestamp create_Date, String created_By, Timestamp last_Update, String updated_By, int country_Id){

        this.Division_Id = division_Id;
        this.Division = division;
        this.Create_Date = create_Date;
        this.Created_By = created_By;
        this.Last_Update = last_Update;
        this.Updated_By = updated_By;
        this.Country_Id = country_Id;

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
     * Get Division
     * @return
     */
    public String getDivision() {
        return Division;
    }

    /**
     * Set Division
     * @param division
     */
    public void setDivision(String division) {
        Division = division;
    }

    /**
     * Get Create Date
     * @return
     */
    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    /**
     * Set Create Date
     * @param create_Date
     */
    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    /**
     * Get Last Update
     * @return
     */
    public Timestamp getLast_Update() {
        return Last_Update;
    }

    /**
     * Set Last Update
     * @param last_Update
     */
    public void setLast_Update(Timestamp last_Update) {
        Last_Update = last_Update;
    }

    /**
     * Get Updated By
     * @return
     */
    public String getUpdated_By() {
        return Updated_By;
    }

    /**
     * Set Updated by
     * @param updated_By
     */
    public void setUpdated_By(String updated_By) {
        Updated_By = updated_By;
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
     * Get Created By
     * @return
     */
    public String getCreated_By() {
        return Created_By;
    }

    /**
     * Set created By
     * @param created_By
     */
    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }
}
