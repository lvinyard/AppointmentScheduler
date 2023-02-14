package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersQuery {

    public static Users getUser(String userName) throws SQLException, Exception{
        String sqlStatement = "SELECT * FROM users WHERE User_Name = '" + userName + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        while(result.next()){
            int resuserid = result.getInt("User_ID");
            String resuserName = result.getString("User_Name");
            String respassword = result.getString("Password");
            Users userResult = new Users(resuserid, resuserName, respassword);
            return userResult;
        }
        return null;
    }
    public static ObservableList<Users> getAllUsers() throws SQLException, Exception{
        ObservableList<Users> allUsers = FXCollections.observableArrayList();
        String sqlStatement = "Select * from users";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resuserid = result.getInt("User_ID");
            String resuserName = result.getString("User_Name");
            String respassword = result.getString("Password");
            Users userResult = new Users(resuserid, resuserName, respassword);
            allUsers.add(userResult);
        }
        return allUsers;
    }
}
