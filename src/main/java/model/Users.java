package model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;

public class Users {
    private int UserId;
    private String User_Name;
    private String Password;
    private DateFormat Create_Date;
    private String Created_By;
    private Timestamp TimeStamp;
    private String Updated_By;


    public Users(int userId, String user_name, String password){
        this.UserId = userId;
        this.User_Name = user_name;
        this.Password = password;
        //this.Create_Date = create_Date;
        //this.Created_By = created_by;
        //this.TimeStamp = timestamp;
        //this.Updated_By = updated_by;

    }

    public DateFormat getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(DateFormat create_Date) {
        Create_Date = create_Date;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUpdated_By() {
        return Updated_By;
    }

    public void setUpdated_By(String updated_By) {
        Updated_By = updated_By;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public Timestamp getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        TimeStamp = timeStamp;
    }
}


