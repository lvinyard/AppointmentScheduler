package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles all of the SQL methods for the User model
 */
public class UsersQuery {

    public static Users loggedonUser;

    /**
     * This method returns a single user by the provided User Id
     * @param Id
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static Users getUser(int Id) throws SQLException, Exception{
        String sqlStatement = "SELECT * FROM users WHERE User_ID = '" + Id + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        while(result.next()){
            int resuserid = result.getInt("User_ID");
            String resuserName = result.getString("User_Name");
            Users userResult = new Users(resuserid, resuserName);
            return userResult;
        }
        return null;
    }

    /**
     * This method returns a list of all users in the database
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Users> getAllUsers() throws SQLException, Exception{
        ObservableList<Users> allUsers = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM users";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        while(result.next()){
            int resuserid = result.getInt("User_ID");
            String resuserName = result.getString("User_Name");
            Users userResult = new Users(resuserid, resuserName);
            allUsers.add(userResult);
        }
        return allUsers;
    }

    /**
     * This method checks for logon username and password.
     * @param username
     * @param password
     * @throws SQLException
     * @throws Exception
     */
    public static void logOnUser(String username, String password) throws SQLException, Exception{

        String sqlStatement = "Select * from users where User_Name = '" + username + "' and BINARY Password = '" + password + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        int resUserId = result.getInt("User_ID");
        String resUserName = result.getString("User_Name");
        Users loggedUser = new Users(resUserId, resUserName);

        loggedonUser = loggedUser;
    }
}
