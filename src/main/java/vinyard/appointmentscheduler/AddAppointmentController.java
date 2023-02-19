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
import model.Appointments;
import model.Contacts;
import model.Customers;
import model.Users;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

/**
 * This class handles the Add Appointment screen
 */
public class AddAppointmentController implements Initializable {
    public DatePicker EndDate;
    public DatePicker StartDate;
    public ComboBox CustomerIdField;
    public ComboBox UserIdField;
    public ComboBox EndTimeField;
    public TextField AppointmentIdField;
    public TextField TitleField;
    public TextField DescField;
    public TextField LocationField;
    public TextField TypeField;
    public ComboBox StartTime;
    public ComboBox ContactIdField;
    public ComboBox EndTimeHours;
    public ComboBox StartTimeHours;
    public ComboBox StartTimeMinutes;
    public ComboBox EndTimeMinutes;
    private ObservableList<String> hours = FXCollections.observableArrayList();
    private ObservableList<String> minutes = FXCollections.observableArrayList();

    /**
     * This method is called when the Cancel button is pressed. Loads Main Screen.
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
     * This method is called when the Save Button is pressed. Saves Appointment into the database and takes user to main screen
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

        int newAppointmentId = Integer.parseInt(AppointmentIdField.getText());
        String newTitle = TitleField.getText();
        String newDescription = DescField.getText();
        String newLocation = LocationField.getText();
        int newContactId = ((Contacts) ContactIdField.getSelectionModel().getSelectedItem()).getContact_Id();
        String newType = TypeField.getText();
        int newCustomerId = ((Customers) CustomerIdField.getSelectionModel().getSelectedItem()).getCustomer_Id();
        int newUserId = ((Users) UserIdField.getSelectionModel().getSelectedItem()).getUserId();
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

        ObservableList<Appointments> customerAppointments = AppointmentsQuery.getAllAppointmentsforCustomer(newCustomerId);
        //Check if Customer has any overlapping appointments
        for(Appointments appt : customerAppointments){
            //Skip modified appt id
            if(newAppointmentId == appt.getAppointment_Id()){
                continue;
            }
            if(startDateTime.isAfter(appt.getStart()) && startDateTime.isBefore(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + newCustomerId + "." );
                return;
            }
            if(endDateTime.isAfter(appt.getStart()) && endDateTime.isBefore(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + newCustomerId + "." );
                return;
            }
            if(startDateTime.isBefore(appt.getStart()) && endDateTime.isAfter(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + newCustomerId + "." );
                return;
            }
            if(startDateTime.isBefore(appt.getStart()) && endDateTime.isAfter(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + newCustomerId + "." );
                return;
            }
            if(startDateTime.isEqual(appt.getStart()) || endDateTime.isEqual(appt.getEnd())){
                Alerts.errorLog("This meeting overlaps with appointment ID: " + appt.getAppointment_Id() + " for customer ID: " + newCustomerId + "." );
                return;
            }
        }


        if(newTitle != "" && newDescription != "" && newLocation != "" && newType != ""){

            try{
                //Do update
                helper.AppointmentsQuery.newAppointment(newAppointmentId, newTitle, newDescription, newLocation, newType, AppointmentsQuery.LocalTimetoUTC(startDateTime), AppointmentsQuery.LocalTimetoUTC(endDateTime), newCustomerId, newUserId, newContactId);

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
     * This method is ran on init.
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
        try {
            AppointmentIdField.setText(String.valueOf(AppointmentsQuery.newAppointmentId()));
            ContactIdField.getItems().addAll(ContactsQuery.getAllContacts());
            UserIdField.getItems().addAll(UsersQuery.getAllUsers());
            CustomerIdField.getItems().addAll(CustomersQuery.getAllCustomers());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}