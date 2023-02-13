package vinyard.appointmentscheduler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    public TableColumn ColumnnDivision;
    public TableColumn ColumnLastUpdateBy;
    public TableColumn ColumnLastUpdate;
    public TableColumn ColumnCreated;
    public TableColumn ColumnPhone;
    public TableColumn ColumnPostalCode;
    public TableColumn ColumnAddress;
    public TableColumn ColumnName;
    public TableColumn ColumnCustId;
    public TableView CustomerTable;
    public TableColumn ColumnUserId;
    public TableColumn ColumnCustomerId;
    public TableColumn ColumnEnd;
    public TableColumn ColumnStart;
    public TableColumn ColumnType;
    public TableColumn ColumnContact;
    public TableColumn ColumnLocation;
    public TableColumn ColumnDesc;
    public TableColumn ColumnTitle;
    public TableColumn ColumnAppId;
    public TableView AppointmentTable;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void RadioAllButton(ActionEvent actionEvent) {
    }


    public void RadioWeekButton(ActionEvent actionEvent) {
    }

    public void RadioMonthButton(ActionEvent actionEvent) {
    }

    public void DeleteCustomerButton(ActionEvent actionEvent) {
    }

    public void ModifyCustomerButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Modify Customer Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_ModifyCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Modify Product Form");
        stage.setScene(scene);
        stage.show();
    }
    public void AddCustomerButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Add Customer Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_AddCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Modify Product Form");
        stage.setScene(scene);
        stage.show();
    }
    public void DeleteAppointmentButton(ActionEvent actionEvent) {
    }
    public void ModifyAppointmentButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Modify Appointment Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_ModifyAppointment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Modify Appointment");
        stage.setScene(scene);
        stage.show();
    }
    public void AddAppointmentButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Main Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_AddAppointment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
    }
    public void ReportsButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Report Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_Report.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }
    public void ExitButton(ActionEvent actionEvent) {
    }
}