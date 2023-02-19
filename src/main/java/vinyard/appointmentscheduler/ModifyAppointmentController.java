package vinyard.appointmentscheduler;

import helper.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Appointments;
import model.Contacts;
import model.Customers;
import model.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

/**
 * This class handles the controls and logic of the Modify appointment scene.
 */
public class ModifyAppointmentController implements Initializable {
    public DatePicker EndDate;
    public DatePicker StartDate;
    public ComboBox CustomerIdField;
    public ComboBox UserIdField;
    public ComboBox EndTimeHours;
    public TextField AppointmentIdField;
    public TextField TitleField;
    public TextField DescField;
    public TextField LocationField;
    public TextField TypeField;
    public ComboBox StartTimeHours;
    public ComboBox ContactIdField;
    private static Appointments modifyAppointment = null;
    public ComboBox EndTimeMinutes;
    public ComboBox StartTimeMinutes;
    private ObservableList<String> hours = FXCollections.observableArrayList();
    private ObservableList<String> minutes = FXCollections.observableArrayList();

    /**
     * This method is for passing the appointment being modified.
     * @param appointment
     */
    public static void getModifyAppointment(Appointments appointment){
        modifyAppointment = appointment;
    }

    /**
     * This method is called when the Cancel Button is pressed. Brings user back to the Main scene.
     * @param actionEvent
     * @throws IOException
     */
    public void CancelButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Main Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Appointment Scheduler");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is called when the Save Button is pressed. The Appointment being modifed is saved to the database.
     * @param actionEvent
     * @throws Exception
     */
    public void SaveButton(ActionEvent actionEvent) throws Exception {

        if(StartDate.getValue() == null || StartTimeHours.getSelectionModel().getSelectedItem() == null || StartTimeMinutes.getSelectionModel().getSelectedItem() == null){
            Alerts.errorLog("Please choose a Start Date and Time.");
            return;
        }
        if(EndDate.getValue() == null || EndTimeHours.getSelectionModel().getSelectedItem() == null || EndTimeMinutes.getSelectionModel().getSelectedItem() == null){
            Alerts.errorLog("Please choose an End Date and Time.");
            return;
        }
        if(CustomerIdField.getSelectionModel().getSelectedItem() == null || ContactIdField.getSelectionModel().getSelectedItem() == null || UserIdField.getSelectionModel().getSelectedItem() == null){
            Alerts.errorLog("Please make a selection for Customer, Contact, and User.");
            return;
        }

        int updateAppointmentId = Integer.parseInt(AppointmentIdField.getText());
        String updateTitle = TitleField.getText();
        String updateDescription = DescField.getText();
        String updateLocation = LocationField.getText();
        int updateContactId = ((Contacts) ContactIdField.getSelectionModel().getSelectedItem()).getContact_Id();
        String updateType = TypeField.getText();
        int updateCustomerId = ((Customers) CustomerIdField.getSelectionModel().getSelectedItem()).getCustomer_Id();
        int updateUserId = ((Users) UserIdField.getSelectionModel().getSelectedItem()).getUserId();
        LocalDateTime startDateTime = StartDate.getValue().atTime(Integer.parseInt(StartTimeHours.getValue().toString()), Integer.parseInt(StartTimeMinutes.getValue().toString()));

        LocalDateTime endDateTime = EndDate.getValue().atTime(Integer.parseInt(EndTimeHours.getValue().toString()), Integer.parseInt(EndTimeMinutes.getValue().toString()));

        //Do Time Checks (Overlap, etc.)

        //Check if End DateTime is Greater than Start Date Time
        if(endDateTime.isBefore(startDateTime) || endDateTime.isEqual(startDateTime)){
            Alerts.errorLog("End Date and Time must be after Start Date Time");
            return;
        }
        //Check if Start and End Date Time is in EST Work hours
        if(AppointmentsQuery.LocalTimetoEST(startDateTime).getHour() < 8 || AppointmentsQuery.LocalTimetoEST(startDateTime).getHour() > 22 ){
            Alerts.errorLog("Start Time does not fall between the business hours of 8 AM to 10 PM EST.");
            return;
        }
        if(AppointmentsQuery.LocalTimetoEST(endDateTime).getHour() < 8 || AppointmentsQuery.LocalTimetoEST(endDateTime).getHour() > 22 ){
            Alerts.errorLog("End Time does not fall between the business hours of 8 AM to 10 PM EST.");
            return;
        }
        if(AppointmentsQuery.LocalTimetoEST(endDateTime).getHour() == 22 && AppointmentsQuery.LocalTimetoEST(endDateTime).getMinute() != 00){
            Alerts.errorLog("End Time does not fall between the business hours of 8 AM to 10 PM EST.");
            return;
        }
        //Check if Start Data and End Date are in the same day
        if(ChronoUnit.HOURS.between(startDateTime, endDateTime) > 14){
            Alerts.errorLog("Meetings must be in between business hours.");
            return;
        }

        ObservableList<Appointments> customerAppointments = AppointmentsQuery.getAllAppointmentsforCustomer(updateCustomerId);
        //Check if Customer has any overlapping appointments
        for(Appointments appt : customerAppointments){
            //Skip modified appt id
           if(updateAppointmentId == appt.getAppointment_Id()){
               continue;
            }

            if(startDateTime.isAfter(appt.getStart()) && startDateTime.isBefore(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + updateCustomerId + "." );
                return;
            }
            if(endDateTime.isAfter(appt.getStart()) && endDateTime.isBefore(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + updateCustomerId + "." );
                return;
            }
            if(startDateTime.isBefore(appt.getStart()) && endDateTime.isAfter(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + updateCustomerId + "." );
                return;
            }
            if(startDateTime.isBefore(appt.getStart()) && endDateTime.isAfter(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + updateCustomerId + "." );
                return;
            }
            if(startDateTime.isEqual(appt.getStart()) || endDateTime.isEqual(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + updateCustomerId + "." );
                return;
            }
        }


        if(updateTitle != "" && updateDescription != "" && updateLocation != "" && updateType != ""){

            try{
                //Do update
                helper.AppointmentsQuery.updateAppointment(updateAppointmentId, updateTitle, updateDescription, updateLocation, updateType, AppointmentsQuery.LocalTimetoUTC(startDateTime), AppointmentsQuery.LocalTimetoUTC(endDateTime), updateCustomerId, updateUserId, updateContactId);

                //Change Scene to Main Screen
                Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_MainScreen.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
                stage.setTitle("Appointment Scheduler");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }else{
            Alerts.errorLog("One of the fields is not populated.");
        }

    }

    /**
     * This method is called on init of this scene.
     * The appointment being modified is looded into the form
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hours.addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11","12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
        minutes.addAll("00", "15", "30", "45");
        StartTimeHours.setItems(hours);
        StartTimeMinutes.setItems(minutes);
        EndTimeHours.setItems(hours);
        EndTimeMinutes.setItems(minutes);

        //Load modify appointment into form
        AppointmentIdField.setText(String.valueOf(modifyAppointment.getAppointment_Id()));
        TitleField.setText(modifyAppointment.getTitle());
        DescField.setText(modifyAppointment.getDescription());
        LocationField.setText(modifyAppointment.getLocation());
        try {
            ContactIdField.getItems().addAll(ContactsQuery.getAllContacts());
            ContactIdField.setValue(ContactsQuery.getContact(modifyAppointment.getContact_id()));
            UserIdField.getItems().addAll(UsersQuery.getAllUsers());
            UserIdField.setValue(UsersQuery.getUser(modifyAppointment.getUser_Id()));
            CustomerIdField.getItems().addAll(CustomersQuery.getAllCustomers());
            CustomerIdField.setValue(CustomersQuery.getCustomer(modifyAppointment.getCustomer_Id()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TypeField.setText(modifyAppointment.getType());
        StartDate.setValue(modifyAppointment.getStart().toLocalDate());
        EndDate.setValue(modifyAppointment.getEnd().toLocalDate());
        StartTimeHours.setValue(String.format("%02d", modifyAppointment.getStart().toLocalTime().getHour()));
        EndTimeHours.setValue(String.format("%02d", modifyAppointment.getEnd().toLocalTime().getHour()));
        StartTimeMinutes.setValue(String.format("%02d", modifyAppointment.getStart().toLocalTime().getMinute()));
        EndTimeMinutes.setValue(String.format("%02d", modifyAppointment.getEnd().toLocalTime().getMinute()));

    }
}