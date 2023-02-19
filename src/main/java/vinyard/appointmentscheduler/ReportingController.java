package vinyard.appointmentscheduler;

import helper.ContactsQuery;
import helper.CountryQuery;
import helper.DivisionQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Contacts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class handles the controls and logic for the reports scene
 */
public class ReportingController implements Initializable {
    public TableView reportTable3;
    public TableView reportTable2;
    public TableView reportTable1;
    public ComboBox ContactField;
    public TableColumn ColumnAppId;
    public TableColumn ColumnTitle;
    public TableColumn ColumnType;
    public TableColumn ColumnDesc;
    public TableColumn ColumnStart;
    public TableColumn ColumnEnd;
    public TableColumn ColumnCustomerId;
    public TableColumn report2Month;
    public TableColumn report2Type;
    public TableColumn report2Num;
    public TableColumn report3Division;
    public TableColumn report3Num;

    /**
     * This method is called when the cancel button is pressed. Brings user back to Main screen.
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
     * This method is called on init of the scene.
     * Loads all data into the reports
     *
     * LAMBDA on Line 91
     * The justification for this Lambda expression is that is simplifies the code where another method would be required.
     * The Lambda expression takes in 3 parameters, and you are able to see the entire logic of the listener in the same
     * code block as it is being utilized in.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ContactField.getItems().addAll(ContactsQuery.getAllContacts());

            reportTable2.getItems().clear();
            reportTable2.setItems(helper.AppointmentsQuery.getAppByMonthType());

            report2Month.setCellValueFactory(new PropertyValueFactory<>("Month"));
            report2Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
            report2Num.setCellValueFactory(new PropertyValueFactory<>("Count"));

            reportTable3.getItems().clear();
            reportTable3.setItems(helper.CustomersQuery.getCountbyDivision());

            report3Division.setCellValueFactory(new PropertyValueFactory<>("Division_Id"));
            report3Num.setCellValueFactory(new PropertyValueFactory<>("Count"));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ContactField.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {

                try {
                    reportTable1.getItems().clear();
                    reportTable1.setItems(helper.AppointmentsQuery.getAllAppointmentsforContact(((Contacts) ContactField.getSelectionModel().getSelectedItem()).getContact_Id()));

                    ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
                    ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                    ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
                    ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                    ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
                    ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
                    ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}