package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.Time;

import java.text.DateFormat;
import java.time.LocalDateTime;

/**
 * This is the Class to hold the appointment model of the database
 */
public class Appointments {
    private int Appointment_Id;
    private String Title;
    private String Description;
    private String Location;
    private String Type;
    private LocalDateTime Start;
    private LocalDateTime End;
    private LocalDateTime Create_Date;
    private String Created_By;
    private LocalDateTime Last_Update;
    private String Updated_By;
    private int Customer_Id;
    private int User_Id;
    private int Contact_id;

    /**
     * Creates new Appointment
     * @param appointment_Id
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param create_Date
     * @param created_By
     * @param last_Update
     * @param updated_By
     * @param customer_Id
     * @param user_Id
     * @param contact_id
     */
    public Appointments(int appointment_Id, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, LocalDateTime create_Date, String created_By, LocalDateTime last_Update, String updated_By, int customer_Id, int user_Id, int contact_id) {
        this.Appointment_Id = appointment_Id;
        this.Title = title;
        this.Description = description;
        this.Location = location;
        this.Type = type;
        this.Start = start;
        this.End = end;
        this.Create_Date = create_Date;
        this.Created_By = created_By;
        this.Last_Update = last_Update;
        this.Updated_By = updated_By;
        this.Customer_Id = customer_Id;
        this.User_Id = user_Id;
        this.Contact_id = contact_id;
    }

    /**
     * Get appointment ID
     * @return
     */
    public int getAppointment_Id() {
        return Appointment_Id;
    }

    /**
     * Sets appointment Id
     * @param appointment_Id
     */
    public void setAppointment_Id(int appointment_Id) {
        Appointment_Id = appointment_Id;
    }

    /**
     * Gets Title
     * @return
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Sets title
     * @param title
     */
    public void setTitle(String title) {
        Title = title;
    }

    /**
     * Gets description
     * @return
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Sets description
     * @param description
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * Gets location
     * @return
     */
    public String getLocation() {
        return Location;
    }

    /**
     * Sets location
     * @param location
     */
    public void setLocation(String location) {
        Location = location;
    }

    /**
     * Gets type
     * @return
     */
    public String getType() {
        return Type;
    }

    /**
     * Sets type
     * @param type
     */
    public void setType(String type) {
        Type = type;
    }

    /**
     * Gets start
     * @return
     */
    public LocalDateTime getStart() {
        return Start;
    }

    /**
     * Sets start
     * @param start
     */
    public void setStart(LocalDateTime start) {
        Start = start;
    }

    /**
     * Gets End
     * @return
     */
    public LocalDateTime getEnd() {
        return End;
    }

    /**
     * Sets end
     * @param end
     */
    public void setEnd(LocalDateTime end) {
        End = end;
    }

    /**
     * Get Create Date
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
     * Gets created by
     * @return
     */
    public String getCreated_By() {
        return Created_By;
    }

    /**
     * Sets created by
     * @param created_By
     */
    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    /**
     * Get last update
     * @return
     */
    public LocalDateTime getLast_Update() {
        return Last_Update;
    }

    /**
     * Set last update
     * @param last_Update
     */
    public void setLast_Update(LocalDateTime last_Update) {
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

    /**
     * Get Customer id
     * @return
     */
    public int getCustomer_Id() {
        return Customer_Id;
    }

    /**
     * Set Customer Id
     * @param customer_Id
     */
    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    /**
     * Get User Id
     * @return
     */
    public int getUser_Id() {
        return User_Id;
    }

    /**
     * Set user id
     * @param user_Id
     */
    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    /**
     * Get Contact Id
     * @return
     */
    public int getContact_id() {
        return Contact_id;
    }

    /**
     * Set Contact Id
     * @param contact_id
     */
    public void setContact_id(int contact_id) {
        Contact_id = contact_id;
    }

    /**
     * Override toString method
     * @return
     */
    @Override
    public String toString(){
        return ("Appointment ID: " + Integer.toString(Appointment_Id) + " Start Time: " + Start);
    }

}
