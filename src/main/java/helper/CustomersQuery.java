package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;
import model.Users;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;

public abstract class CustomersQuery {

    public static int newCustomer(){

        return 0;
    }

    public static ObservableList<Customers> getAllCustomers() throws SQLException, Exception{
        ObservableList<Customers> allCustomers = FXCollections.observableArrayList();
        String sqlStatement = "Select * from customers";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resCustomer_Id = result.getInt("Customer_ID");
            String resCustomerName = result.getString("Customer_Name");
            String resAddress = result.getString("Address");
            String resPostal = result.getString("Postal_Code");
            String resPhone = result.getString("Phone");
            Date resCreate_Date = result.getDate("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            int resDivision_Id = result.getInt("Division_ID");
            Customers customerResult = new Customers(resCustomer_Id, resCustomerName, resAddress, resPostal, resPhone, resCreate_Date, resCreated_by, resLast_Update, resUpdatedBy,resDivision_Id);
            allCustomers.add(customerResult);
        }
        return allCustomers;
    }

}
