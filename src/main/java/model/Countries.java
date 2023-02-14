package model;

import java.sql.Timestamp;
import java.text.DateFormat;

public class Countries {
    private int Country_Id;
    private String Country;
    private Timestamp Create_Date;
    private String Created_By;
    private Timestamp Last_Update;
    private String Updated_By;

    public Countries(int country_Id, String country, Timestamp create_Date, String created_By, Timestamp last_Update, String updated_By){
        this.Country_Id = country_Id;
        this.Country = country;
        this.Create_Date = create_Date;
        this.Created_By = created_By;
        this.Last_Update = last_Update;
        this.Updated_By = updated_By;
    }

    public int getCountry_Id() {
        return Country_Id;
    }

    public void setCountry_Id(int country_Id) {
        Country_Id = country_Id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
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
}
