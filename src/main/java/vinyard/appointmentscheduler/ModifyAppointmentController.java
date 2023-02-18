package vinyard.appointmentscheduler;

import helper.AppointmentsQuery;
import helper.ContactsQuery;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyAppointmentController implements Initializable {
    public DatePicker EndDate;
    public DatePicker StartDate;
    public TextField CustomerIdField;
    public TextField UserIdField;
    public ComboBox EndTimeField;
    public TextField AppointmentIdField;
    public TextField TitleField;
    public TextField DescField;
    public TextField LocationField;
    public TextField TypeField;
    public ComboBox StartTime;
    public ComboBox ContactIdField;
    private static Appointments modifyAppointment = null;

    public ModifyAppointmentController() throws Exception {
    }

    public static void getModifyAppointment(Appointments appointment){
        modifyAppointment = appointment;
    }

    public void CancelButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Main Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Modify Product Form");
        stage.setScene(scene);
        stage.show();
    }

    public void SaveButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Main Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Modify Product Form");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Load modify appointment into form
        AppointmentIdField.setText(String.valueOf(modifyAppointment.getAppointment_Id()));
        TitleField.setText(modifyAppointment.getTitle());
        DescField.setText(modifyAppointment.getDescription());
        LocationField.setText(modifyAppointment.getLocation());
        try {
            ContactIdField.getItems().addAll(ContactsQuery.getAllContactIds());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TypeField.setText(modifyAppointment.getType());

        AppointmentsQuery.UTCtoLocalTime(modifyAppointment.getStart());



    }
}