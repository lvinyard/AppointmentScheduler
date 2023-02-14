package model;

import java.sql.Timestamp;

public class Customers {
    private int Customer_Id;
    private String Customer_Name;
    private String Address;
    private String PostalCode;
    private String Phone;
    private Timestamp Create_Date;
    private String Created_By;
    private Timestamp Last_Update;
    private String Updated_By;
    private int Division_Id;

    public Customers(int customer_Id, String customer_Name, String address, String postalCode, String phone, Timestamp create_Date, String created_By, Timestamp last_Update, String updated_By, int division_Id){
        this.Customer_Id = customer_Id;
        this.Customer_Name = customer_Name;
        this.Address = address;
        this.PostalCode = postalCode;
        this.Phone = phone;
        this.Create_Date = create_Date;
        this.Created_By = created_By;
        this.Last_Update = last_Update;
        this.Updated_By = updated_By;
        this.Division_Id = division_Id;
    }

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public Timestamp getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(Timestamp create_Date) {
        Create_Date = create_Date;
    }

    public java.sql.Timestamp getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(java.sql.Timestamp last_Update) {
        Last_Update = last_Update;
    }

    public String getUpdated_By() {
        return Updated_By;
    }

    public void setUpdated_By(String updated_By) {
        Updated_By = updated_By;
    }

    public int getDivision_Id() {
        return Division_Id;
    }

    public void setDivision_Id(int division_Id) {
        Division_Id = division_Id;
    }
}