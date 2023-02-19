package model;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;

/**
 * This class is the model for Users in the database
 */
public class Users {
    private int UserId;
    private String User_Name;

    /**
     * Create new User
     * @param userId
     * @param user_name
     */
    public Users(int userId, String user_name){
        this.UserId = userId;
        this.User_Name = user_name;
    }

    /**
     * Get User Id
     * @return
     */
    public int getUserId() {
        return UserId;
    }

    /**
     * Set User Id
     * @param userId
     */
    public void setUserId(int userId) {
        UserId = userId;
    }

    /**
     * Get User Name
     * @return
     */
    public String getUser_Name() {
        return User_Name;
    }

    /**
     * Set user Name
     * @param user_Name
     */
    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    /**
     * Override toString
     * @return
     */
    @Override
    public String toString(){
        return (Integer.toString(UserId) + ": " + User_Name);
    }
}


