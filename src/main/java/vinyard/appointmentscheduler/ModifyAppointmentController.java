package vinyard.appointmentscheduler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyAppointmentController {
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
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
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
}