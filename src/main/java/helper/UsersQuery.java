package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersQuery {

    public static Users loggedonUser;

    public static Users getUser(String userName) throws SQLException, Exception{
        String sqlStatement = "SELECT * FROM users WHERE User_Name = '" + userName + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        while(result.next()){
            int resuserid = result.getInt("User_ID");
            String resuserName = result.getString("User_Name");
            String respassword = result.getString("Password");
            Users userResult = new Users(resuserid, resuserName);
            return userResult;
        }
        return null;
    }
    public static void logOnUser(String username, String password) throws SQLException, Exception{
        String sqlStatement = "Select * from users where User_Name = '" + username + "' and Password = '" + password + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        int resUserId = result.getInt("User_ID");
        String resUserName = result.getString("User_Name");
        Users loggedUser = new Users(resUserId, resUserName);

        loggedonUser = loggedUser;
    }
}
