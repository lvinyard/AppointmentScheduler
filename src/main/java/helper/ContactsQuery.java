package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsQuery {


    public static ObservableList<Contacts> getAllContacts() throws SQLException, Exception{
        ObservableList<Contacts> allContacts = FXCollections.observableArrayList();
        String sqlStatement = "SELECT * FROM contacts";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        while(result.next()){
            int resContactId = result.getInt("Contact_ID");
            String resContactName = result.getString("Contact_Name");
            String resEmail = result.getString("Email");
            Contacts ContactResult = new Contacts(resContactId ,resContactName, resEmail);
            allContacts.add(ContactResult);
        }
        return allContacts;
    }
    public static ObservableList<String> getAllContactIds() throws SQLException, Exception{
        ObservableList<String> allContactIds = FXCollections.observableArrayList();
        String sqlStatement = "SELECT Contact_ID FROM contacts";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        while(result.next()){
            String resContactId = result.getString("Contact_ID");
            allContactIds.add(resContactId);
        }
        return allContactIds;
    }

}
