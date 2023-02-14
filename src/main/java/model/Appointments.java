package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;

public class Appointments {
    private int Appointment_Id;
    private String Title;
    private String Description;
    private String Location;
    private String Type;
    private Timestamp Start;
    private Timestamp End;
    private Timestamp Create_Date;
    private String Created_By;
    private Timestamp Last_Update;
    private String Updated_By;
    private int Customer_Id;
    private int User_Id;
    private int Contact_id;

    public Appointments(int appointment_Id, String title, String description, String location, String type, Timestamp start, Timestamp end, Timestamp create_Date, String created_By, Timestamp last_Update, String updated_By, int customer_Id, int user_Id, int contact_id) {
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


    public int getAppointment_Id() {
        return Appointment_Id;
    }

    public void setAppointment_Id(int appointment_Id) {
        Appointment_Id = appointment_Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Timestamp getStart() {
        return Start;
    }

    public void setStart(Timestamp start) {
        Start = start;
    }

    public Timestamp getEnd() {
        return End;
    }

    public void setEnd(Timestamp end) {
        End = end;
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

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public int getContact_id() {
        return Contact_id;
    }

    public void setContact_id(int contact_id) {
        Contact_id = contact_id;
    }
}
