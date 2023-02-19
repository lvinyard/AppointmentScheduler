package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles all SQL methods dealing with the Contact model
 */
public class ContactsQuery {

    /**
     * This method retrieves all contacts from the database
     * @return
     * @throws SQLException
     * @throws Exception
     */
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

    /**
     * This method retrieves a single Contact based on the provided Contact Id
     * @param Contact_Id
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static Contacts getContact(int Contact_Id) throws SQLException, Exception{

        String sqlStatement = "SELECT * FROM contacts where Contact_ID = '" + Contact_Id + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
        int resContactId = result.getInt("Contact_ID");
        String resContactName = result.getString("Contact_Name");
        String resEmail = result.getString("Email");
        Contacts ContactResult = new Contacts(resContactId ,resContactName, resEmail);

        return ContactResult;
    }

}
