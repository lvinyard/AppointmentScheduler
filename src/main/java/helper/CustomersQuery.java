package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;

import java.sql.*;
import java.time.Instant;

public abstract class CustomersQuery {

    public static int newCustomerId() throws SQLException {
        int newCustomerId;
        String sqlStatement = "SELECT MAX(Customer_Id) as newID FROM customers;";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        result.next();

        newCustomerId = result.getInt("newID");

        return ++newCustomerId;
    }

    public static boolean updateCustomer(int CustomerId, String CustomerName, String Address, String PostalCode, String PhoneNumber, int DivisionId) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Update Customers set Customer_Name=?, Address=?, Postal_Code=?, Phone=?, Last_Update=?, Last_Updated_By=?, Division_ID=? WHERE Customer_ID=?");

        sqlStatement.setString(1, CustomerName);
        sqlStatement.setString(2, Address);
        sqlStatement.setString(3, PostalCode);
        sqlStatement.setString(4, PhoneNumber);
        sqlStatement.setTimestamp(5, Timestamp.from(Instant.now())); //ZonedDateTime.now(ZoneOffset.UTC).format(formatter).toString());
        sqlStatement.setString(6, "User");//LogonSession.getLoggedOnUser().getUserName());
        sqlStatement.setInt(7, DivisionId);
        sqlStatement.setInt(8, CustomerId);
        sqlStatement.executeUpdate();

        return true;
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
            Timestamp resCreate_Date = result.getTimestamp("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            int resDivision_Id = result.getInt("Division_ID");
            Customers customerResult = new Customers(resCustomer_Id, resCustomerName, resAddress, resPostal, resPhone, resCreate_Date, resCreated_by, resLast_Update, resUpdatedBy,resDivision_Id);
            allCustomers.add(customerResult);
        }
        return allCustomers;
    }

    public static boolean AddCustomer(int customerId, String customerName, String Address, String Postal, String Phone, int Division) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Insert INTO Customers VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        sqlStatement.setInt(1, customerId);
        sqlStatement.setString(2, customerName);
        sqlStatement.setString(3, Address);
        sqlStatement.setString(4, Postal);
        sqlStatement.setString(5, Phone);
        sqlStatement.setTimestamp(6, Timestamp.from(Instant.now())); //ZonedDateTime.now(ZoneOffset.UTC).format(formatter).toString());
        sqlStatement.setString(7, "User");//LogonSession.getLoggedOnUser().getUserName());
        sqlStatement.setTimestamp(8, Timestamp.from(Instant.now()));
        sqlStatement.setString(9, "User");
        sqlStatement.setInt(10, Division);
        sqlStatement.executeUpdate();

        return true;
    }
}
