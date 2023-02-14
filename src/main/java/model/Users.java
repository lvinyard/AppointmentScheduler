package model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;

public class Users {
    private int UserId;
    private String User_Name;



    public Users(int userId, String user_name){
        this.UserId = userId;
        this.User_Name = user_name;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }
}


