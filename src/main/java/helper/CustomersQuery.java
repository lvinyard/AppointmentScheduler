package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;

import java.sql.*;
import java.time.Instant;

import model.report3;

/**
 * This class is responsible for all the SQL methods dealing with the Customer model
 */
public abstract class CustomersQuery {
    /**
     * This method finds the next available customer id
     * @return
     * @throws SQLException
     */
    public static int newCustomerId() throws SQLException {
        int newCustomerId;
        String sqlStatement = "SELECT MAX(Customer_Id) as newID FROM customers;";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        result.next();

        newCustomerId = result.getInt("newID");

        return ++newCustomerId;
    }

    /**
     * This method is used for adding a customer into the database by executing an insert statement
     * @param customerId
     * @param customerName
     * @param Address
     * @param Postal
     * @param Phone
     * @param Division
     * @return
     * @throws SQLException
     */
    public static boolean AddCustomer(int customerId, String customerName, String Address, String Postal, String Phone, int Division) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Insert INTO Customers VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        sqlStatement.setInt(1, customerId);
        sqlStatement.setString(2, customerName);
        sqlStatement.setString(3, Address);
        sqlStatement.setString(4, Postal);
        sqlStatement.setString(5, Phone);
        sqlStatement.setTimestamp(6, AppointmentsQuery.LocalTimetoUTC(Timestamp.from(Instant.now()).toLocalDateTime())); //ZonedDateTime.now(ZoneOffset.UTC).format(formatter).toString());
        sqlStatement.setString(7, (UsersQuery.loggedonUser).getUser_Name());//LogonSession.getLoggedOnUser().getUserName());
        sqlStatement.setTimestamp(8, AppointmentsQuery.LocalTimetoUTC(Timestamp.from(Instant.now()).toLocalDateTime()));
        sqlStatement.setString(9, (UsersQuery.loggedonUser).getUser_Name());
        sqlStatement.setInt(10, Division);
        sqlStatement.executeUpdate();

        return true;
    }

    /**
     * This method updates an existing customer by the update statement
     * @param CustomerId
     * @param CustomerName
     * @param Address
     * @param PostalCode
     * @param PhoneNumber
     * @param DivisionId
     * @return
     * @throws SQLException
     */
    public static boolean updateCustomer(int CustomerId, String CustomerName, String Address, String PostalCode, String PhoneNumber, int DivisionId) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Update Customers set Customer_Name=?, Address=?, Postal_Code=?, Phone=?, Last_Update=?, Last_Updated_By=?, Division_ID=? WHERE Customer_ID=?");

        sqlStatement.setString(1, CustomerName);
        sqlStatement.setString(2, Address);
        sqlStatement.setString(3, PostalCode);
        sqlStatement.setString(4, PhoneNumber);
        sqlStatement.setTimestamp(5, AppointmentsQuery.LocalTimetoUTC(Timestamp.from(Instant.now()).toLocalDateTime())); //ZonedDateTime.now(ZoneOffset.UTC).format(formatter).toString());
        sqlStatement.setString(6, (UsersQuery.loggedonUser).getUser_Name());//LogonSession.getLoggedOnUser().getUserName());
        sqlStatement.setInt(7, DivisionId);
        sqlStatement.setInt(8, CustomerId);
        sqlStatement.executeUpdate();

        return true;
    }

    /**
     * This method deletes the customer from the database by the provided customer id
     * @param CustomerId
     * @return
     * @throws SQLException
     */
    public static boolean deleteCustomer(int CustomerId) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Delete FROM Customers WHERE Customer_ID =?");

        sqlStatement.setInt(1, CustomerId);
        sqlStatement.executeUpdate();

        return true;
    }

    /**
     * This method retrieves a single customer from a provided customer id
     * @param customerid
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static Customers getCustomer(int customerid) throws SQLException, Exception{
        String sqlStatement = "Select * from customers where Customer_ID = '" + customerid + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();

        result.next();
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
        Customers customerResult = new Customers(resCustomer_Id, resCustomerName, resAddress, resPostal, resPhone, AppointmentsQuery.UTCtoLocalTime(resCreate_Date), resCreated_by, AppointmentsQuery.UTCtoLocalTime(resLast_Update), resUpdatedBy,resDivision_Id);
        return customerResult;
    }

    /**
     * This method returns all customers from the database
     * @return
     * @throws SQLException
     * @throws Exception
     */
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
            Customers customerResult = new Customers(resCustomer_Id, resCustomerName, resAddress, resPostal, resPhone, AppointmentsQuery.UTCtoLocalTime(resCreate_Date), resCreated_by, AppointmentsQuery.UTCtoLocalTime(resLast_Update), resUpdatedBy,resDivision_Id);
            allCustomers.add(customerResult);
        }
        return allCustomers;
    }

    /**
     * This method returns report 3 by retrieving the amount of customers in each division
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<report3> getCountbyDivision() throws SQLException, Exception{
        ObservableList<report3> customerByDivision = FXCollections.observableArrayList();
        String sqlStatement = "SELECT Count(*) as Num, Division_Id FROM client_schedule.customers group by Division_ID;";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resDivisionId = result.getInt("Division_Id");
            int resCount = result.getInt("Num");
            report3 newreport = new report3(resDivisionId, resCount);
            customerByDivision.add(newreport);
        }
        return customerByDivision;
    }

}
