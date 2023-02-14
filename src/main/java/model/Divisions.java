package model;

import java.sql.Timestamp;
import java.text.DateFormat;

public class Divisions {
    private int Division_Id;
    private String Division;
    private DateFormat Create_Date;
    private Timestamp Last_Update;
    private String Updated_By;
    private int Country_Id;

    public void Divisions(int division_Id, String division, DateFormat create_Date, Timestamp last_Update, String updated_By, int country_Id){

        this.Division_Id = division_Id;
        this.Division = division;
        this.Create_Date = create_Date;
        this.Last_Update = last_Update;
        this.Updated_By = updated_By;
        this.Country_Id = country_Id;

    }

    public int getDivision_Id() {
        return Division_Id;
    }

    public void setDivision_Id(int division_Id) {
        Division_Id = division_Id;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public DateFormat getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(DateFormat create_Date) {
        Create_Date = create_Date;
    }

    public Timestamp getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(Timestamp last_Update) {
        Last_Update = last_Update;
    }

    public String getUpdated_By() {
        return Updated_By;
    }

    public void setUpdated_By(String updated_By) {
        Updated_By = updated_By;
    }

    public int getCountry_Id() {
        return Country_Id;
    }

    public void setCountry_Id(int country_Id) {
        Country_Id = country_Id;
    }
}
