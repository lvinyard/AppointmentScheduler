package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AppointmentsQuery {


    public static ObservableList<Appointments> getAllAppointments(String options) throws SQLException, Exception{
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sqlStatement;

        switch(options) {
            case "week": sqlStatement = "Select * from appointments";
            break;
            case "month": sqlStatement = "Select * from appointments";
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
            Appointments appointmentsResult = new Appointments(resAppointment_Id, resTitle, resDescription, resLocation, resType, resStart, resEnd, resCreate_Date, resCreated_by, resLast_Update, resUpdatedBy, resCustomerId, resUserId, resContactId);
            allAppointments.add(appointmentsResult);
        }
        return allAppointments;
    }

    public static LocalDateTime UTCtoLocalTime(Timestamp ts) {
        LocalDateTime ldt = ts.toLocalDateTime();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of(ZoneId.systemDefault().toString()));
        ZonedDateTime utczdt = zdt.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime ldtIn = utczdt.toLocalDateTime();

        ZonedDateTime zdtOut = ldtIn.atZone(ZoneId.of("UTC"));
        ZonedDateTime zdtOutToLocalTZ = zdtOut.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
        LocalDateTime ldtOutFinal = zdt.toLocalDateTime();

        System.out.println(ts);
        System.out.println(ldt);
        System.out.println(zdt);
        System.out.println(utczdt);
        System.out.println(ldtIn);
        System.out.println(zdtOut);
        System.out.println(zdtOutToLocalTZ);
        System.out.println(ldtOutFinal);
        System.out.println(ZoneId.systemDefault().toString());


        return ldt;
    }


}
