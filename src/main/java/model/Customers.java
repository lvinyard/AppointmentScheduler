package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * This class is the model for Customers in the database
 */
public class Customers {
    private int Customer_Id;
    private String Customer_Name;
    private String Address;
    private String PostalCode;
    private String Phone;
    private LocalDateTime Create_Date;
    private String Created_By;
    private LocalDateTime Last_Update;
    private String Updated_By;
    private int Division_Id;

    /**
     * New customer
     * @param customer_Id
     * @param customer_Name
     * @param address
     * @param postalCode
     * @param phone
     * @param create_Date
     * @param created_By
     * @param last_Update
     * @param updated_By
     * @param division_Id
     */
    public Customers(int customer_Id, String customer_Name, String address, String postalCode, String phone, LocalDateTime create_Date, String created_By, LocalDateTime last_Update, String updated_By, int division_Id){
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

    /**
     * Get Customer id
     * @return
     */
    public int getCustomer_Id() {
        return Customer_Id;
    }

    /**
     * Set Customer id
     * @param customer_Id
     */
    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    /**
     * Get Customer Name
     * @return
     */
    public String getCustomer_Name() {
        return Customer_Name;
    }

    /**
     * Set Customer name
     * @param customer_Name
     */
    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    /**
     * Get Address
     * @return
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Set Address
     * @param address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * Get Postal Code
     * @return
     */
    public String getPostalCode() {
        return PostalCode;
    }

    /**
     * Set postal Code
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    /**
     * Get Phone
     * @return
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * Set Phone
     * @param phone
     */
    public void setPhone(String phone) {
        Phone = phone;
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
     * Get Created Date
     * @return
     */
    public LocalDateTime getCreate_Date() {
        return Create_Date;
    }

    /**
     * Set Create Date
     * @param create_Date
     */
    public void setCreate_Date(LocalDateTime create_Date) {
        Create_Date = create_Date;
    }

    /**
     * Get Last Update
     * @return
     */
    public LocalDateTime getLast_Update() {
        return Last_Update;
    }

    /**
     * Set Last Update
     * @param last_Update
     */
    public void setLast_Update(LocalDateTime last_Update) {
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
     * Set Updated By
     * @param updated_By
     */
    public void setUpdated_By(String updated_By) {
        Updated_By = updated_By;
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
     * Override toString method
     * @return
     */
    @Override
    public String toString(){
        return (Integer.toString(Customer_Id) + ": " + Customer_Name);
    }
}