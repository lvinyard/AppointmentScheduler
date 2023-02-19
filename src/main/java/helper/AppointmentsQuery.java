package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.report2;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * This Class handles all of the SQL methods for Appointments
 *
 */
public class AppointmentsQuery {

    /**
     * This method finds the next available ID for a new appointment
     * @return
     * @throws SQLException
     */
    public static int newAppointmentId() throws SQLException {
        int newAppointmentId;
        String sqlStatement = "SELECT MAX(Appointment_Id) as newID FROM appointments;";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        result.next();

        newAppointmentId = result.getInt("newID");

        return ++newAppointmentId;
    }

    /**
     * This method gets all the appointments and turns them into objects
     * @param options
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointments> getAllAppointments(String options) throws SQLException, Exception{
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sqlStatement;

        switch(options) {
            case "week": sqlStatement = "Select * from appointments where Start <= NOW() + interval 1 Week and Start > NOW()";
            break;
            case "month": sqlStatement = "Select * from appointments where Start <= NOW() + interval 1 Month and Start > NOW()";
            break;
            default: sqlStatement = "Select * from appointments";
            break;
        }

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resAppointment_Id = result.getInt("Appointment_ID");
            String resTitle = result.getString("Title");
            String resDescription = result.getString("Description");
            String resLocation = result.getString("Location");
            String resType = result.getString("Type");
            Timestamp resStart = result.getTimestamp("Start");
            Timestamp resEnd = result.getTimestamp("End");
            Timestamp resCreate_Date = result.getTimestamp("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            int resCustomerId = result.getInt("Customer_ID");
            int resUserId = result.getInt("User_ID");
            int resContactId = result.getInt("Contact_ID");
            Appointments appointmentsResult = new Appointments(resAppointment_Id, resTitle, resDescription, resLocation, resType, UTCtoLocalTime(resStart), UTCtoLocalTime(resEnd), UTCtoLocalTime(resCreate_Date), resCreated_by, UTCtoLocalTime(resLast_Update), resUpdatedBy, resCustomerId, resUserId, resContactId);
            allAppointments.add(appointmentsResult);
        }
        return allAppointments;
    }

    /**
     * This method gets all appointments that are assigned to a specific customer
     * @param customerId
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointments> getAllAppointmentsforCustomer(int customerId) throws SQLException, Exception{
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sqlStatement;

       sqlStatement = "Select * from appointments where Customer_ID = '" + customerId + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resAppointment_Id = result.getInt("Appointment_ID");
            String resTitle = result.getString("Title");
            String resDescription = result.getString("Description");
            String resLocation = result.getString("Location");
            String resType = result.getString("Type");
            Timestamp resStart = result.getTimestamp("Start");
            Timestamp resEnd = result.getTimestamp("End");
            Timestamp resCreate_Date = result.getTimestamp("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            int resCustomerId = result.getInt("Customer_ID");
            int resUserId = result.getInt("User_ID");
            int resContactId = result.getInt("Contact_ID");
            Appointments appointmentsResult = new Appointments(resAppointment_Id, resTitle, resDescription, resLocation, resType, UTCtoLocalTime(resStart), UTCtoLocalTime(resEnd), UTCtoLocalTime(resCreate_Date), resCreated_by, UTCtoLocalTime(resLast_Update), resUpdatedBy, resCustomerId, resUserId, resContactId);
            allAppointments.add(appointmentsResult);
        }
        return allAppointments;
    }

    /**
     * This method gets all appointments for a specific contact
     * @param contactId
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<Appointments> getAllAppointmentsforContact(int contactId) throws SQLException, Exception{
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sqlStatement;

        sqlStatement = "Select * from appointments where Customer_ID = '" + contactId + "'";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            int resAppointment_Id = result.getInt("Appointment_ID");
            String resTitle = result.getString("Title");
            String resDescription = result.getString("Description");
            String resLocation = result.getString("Location");
            String resType = result.getString("Type");
            Timestamp resStart = result.getTimestamp("Start");
            Timestamp resEnd = result.getTimestamp("End");
            Timestamp resCreate_Date = result.getTimestamp("Create_Date");
            String resCreated_by = result.getString("Created_By");
            Timestamp resLast_Update = result.getTimestamp("Last_Update");
            String resUpdatedBy = result.getString("Last_Updated_By");
            int resCustomerId = result.getInt("Customer_ID");
            int resUserId = result.getInt("User_ID");
            int resContactId = result.getInt("Contact_ID");
            Appointments appointmentsResult = new Appointments(resAppointment_Id, resTitle, resDescription, resLocation, resType, UTCtoLocalTime(resStart), UTCtoLocalTime(resEnd), UTCtoLocalTime(resCreate_Date), resCreated_by, UTCtoLocalTime(resLast_Update), resUpdatedBy, resCustomerId, resUserId, resContactId);
            allAppointments.add(appointmentsResult);
        }
        return allAppointments;
    }

    /**
     * This method is for the 2nd report. It retrieves all appointments grouped by month and type
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static ObservableList<report2> getAppByMonthType() throws SQLException, Exception{
        ObservableList<report2> results = FXCollections.observableArrayList();
        String sqlStatement;

        sqlStatement = "SELECT date_format(Start, '%Y-%m') As Month, Type, Count(*) as Count from appointments group by month, type Order by month, type";

        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while(result.next()){
            String resMonth = result.getString("Month");
            String resType = result.getString("Type");
            int resCount = result.getInt("Count");
            report2 reportresult = new report2(resMonth, resType, resCount);
            results.add(reportresult);
        }
        return results;
    }

    /**
     * This method saves a new appointment by inserting it into the database
     * @param newAppointmentId
     * @param newTitle
     * @param newDescription
     * @param newLocation
     * @param newType
     * @param newStart
     * @param newEnd
     * @param newCustomerId
     * @param newUserId
     * @param newContactId
     * @return
     * @throws SQLException
     */
    public static boolean newAppointment(int newAppointmentId, String newTitle, String newDescription, String newLocation, String newType, Timestamp newStart, Timestamp newEnd, int newCustomerId, int newUserId, int newContactId) throws SQLException {

        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Insert INTO appointments VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        sqlStatement.setInt(1, newAppointmentId);
        sqlStatement.setString(2, newTitle);
        sqlStatement.setString(3, newDescription);
        sqlStatement.setString(4, newLocation);
        sqlStatement.setString(5, newType);
        sqlStatement.setTimestamp(6, newStart);
        sqlStatement.setTimestamp(7, newEnd);
        sqlStatement.setTimestamp(8, LocalTimetoUTC(Timestamp.from(Instant.now()).toLocalDateTime())); //ZonedDateTime.now(ZoneOffset.UTC).format(formatter).toString());
        sqlStatement.setString(9, (UsersQuery.loggedonUser).getUser_Name());//LogonSession.getLoggedOnUser().getUserName());
        sqlStatement.setTimestamp(10, LocalTimetoUTC(Timestamp.from(Instant.now()).toLocalDateTime()));
        sqlStatement.setString(11, (UsersQuery.loggedonUser).getUser_Name());
        sqlStatement.setInt(12, newCustomerId);
        sqlStatement.setInt(13, newUserId);
        sqlStatement.setInt(14, newContactId);


        sqlStatement.executeUpdate();

        return true;
    }

    /**
     * This method is for updating an exisiting appointment in the database by executing an update statement
     * @param appointmentId
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param customerId
     * @param userId
     * @param contactId
     * @return
     * @throws SQLException
     */
    public static boolean updateAppointment(int appointmentId, String title, String description, String location, String type, Timestamp start, Timestamp end, int customerId, int userId, int contactId) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Update appointments set Title=?, Description=?, Location=?, Type=?, Start=?, End=?, Last_Update=?, Last_Updated_By=?, Customer_ID=?, User_ID=?, Contact_ID=? WHERE Appointment_ID=?");

        sqlStatement.setString(1, title);
        sqlStatement.setString(2, description);
        sqlStatement.setString(3, location);
        sqlStatement.setString(4, type);
        sqlStatement.setTimestamp(5, start);
        sqlStatement.setTimestamp(6, end);
        sqlStatement.setTimestamp(7, LocalTimetoUTC(Timestamp.from(Instant.now()).toLocalDateTime())); //ZonedDateTime.now(ZoneOffset.UTC).format(formatter).toString());
        sqlStatement.setString(8, (UsersQuery.loggedonUser).getUser_Name());//LogonSession.getLoggedOnUser().getUserName());
        sqlStatement.setInt(9, customerId);
        sqlStatement.setInt(10, userId);
        sqlStatement.setInt(11, contactId);
        sqlStatement.setInt(12, appointmentId);


        sqlStatement.executeUpdate();

        return true;
    }

    /**
     * This method deletes an appointment in the database by a given appointment Id
     * @param appointmentId
     * @return
     * @throws SQLException
     */
    public static boolean deleteAppointment(int appointmentId) throws SQLException {
        PreparedStatement sqlStatement = JDBC.dbCursor().prepareStatement("Delete FROM appointments WHERE Appointment_ID =?");

        sqlStatement.setInt(1, appointmentId);
        sqlStatement.executeUpdate();

        return true;
    }

    /**
     * This Method handles converting the UTC time in the database to a Local Date time for the user
     * @param ts
     * @return
     */
    public static LocalDateTime UTCtoLocalTime(Timestamp ts) {

        LocalDateTime ldt = ts.toLocalDateTime();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of(ZoneId.systemDefault().toString()));
        //ZonedDateTime tzdt = zdt.withZoneSameInstant(ZoneId.systemDefault());
        LocalDateTime tldt = zdt.toLocalDateTime();

        return tldt;
    }

    /**
     * This method handles converting the Local Date Time back into UTC time for database placement
     * @param ldt
     * @return
     */
    public static Timestamp LocalTimetoUTC(LocalDateTime ldt) {
        ZonedDateTime tzdt = ldt.atZone(ZoneId.of("UTC"));
        //ZonedDateTime zdt = tzdt.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime uldt = tzdt.toLocalDateTime();
        Timestamp ts = Timestamp.valueOf(uldt);

        return ts;
    }

    /**
     * This method handles converting LocalDateTime into EST time for logical comparison in the program
     * @param ldt
     * @return
     */
    public static LocalDateTime LocalTimetoEST(LocalDateTime ldt) {
        ZonedDateTime tzdt = ldt.atZone(ZoneId.of(ZoneId.systemDefault().toString()));
        ZonedDateTime zdt = tzdt.withZoneSameInstant(ZoneId.of("America/New_York"));
        LocalDateTime tldt = zdt.toLocalDateTime();

        return tldt;
    }

}
