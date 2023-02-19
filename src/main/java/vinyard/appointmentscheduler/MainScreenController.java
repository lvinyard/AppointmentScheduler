package vinyard.appointmentscheduler;

import helper.Alerts;
import helper.AppointmentsQuery;
import helper.CustomersQuery;
import helper.UsersQuery;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;
import model.Customers;
import model.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * This class handles the controls and logic for the main screen
 */
public class MainScreenController implements Initializable {
    public TableColumn ColumnDivision;
    public TableColumn ColumnLastUpdateBy;
    public TableColumn ColumnLastUpdate;
    public TableColumn ColumnCreated;
    public TableColumn ColumnPhone;
    public TableColumn ColumnPostalCode;
    public TableColumn ColumnAddress;
    public TableColumn ColumnName;
    public TableColumn ColumnCustId;
    public TableView<Customers> CustomerTable;
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
    public TableView<Appointments> AppointmentTable;
    public TableColumn ColumnCreatedDate;
    public RadioButton RadioMonth;
    public RadioButton RadioWeek;
    public RadioButton RadioAll;

    /**
     * This method is called when the Radio All Button is pressed
     * @param actionEvent
     * @throws Exception
     */
    public void RadioAllButton(ActionEvent actionEvent) throws Exception {
        //Appointment Table
        String filter = "All";
        AppointmentTable.setItems(helper.AppointmentsQuery.getAllAppointments(filter));

        ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
        ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ColumnLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        ColumnContact.setCellValueFactory(new PropertyValueFactory<>("Contact_id"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
        ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("User_Id"));

    }

    /**
     * This method is called when the Radio Week Button is pressed
     * @param actionEvent
     * @throws Exception
     */
    public void RadioWeekButton(ActionEvent actionEvent) throws Exception {
        //Appointment Table
        String filter = "week";
        AppointmentTable.setItems(helper.AppointmentsQuery.getAllAppointments(filter));

        ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
        ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ColumnLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        ColumnContact.setCellValueFactory(new PropertyValueFactory<>("Contact_id"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
        ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("User_Id"));

    }

    /**
     * This method is called when the Radio month Button is pressed
     * @param actionEvent
     * @throws Exception
     */
    public void RadioMonthButton(ActionEvent actionEvent) throws Exception {
        //Appointment Table
        String filter = "month";
        AppointmentTable.setItems(helper.AppointmentsQuery.getAllAppointments(filter));

        ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
        ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ColumnLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
        ColumnContact.setCellValueFactory(new PropertyValueFactory<>("Contact_id"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
        ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
        ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
        ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("User_Id"));

    }

    /**
     * This method is called when the Delete Customer Button is pressed.
     * For a customer to be deleted, all appointments associated with
     * the customer is deleted first.
     *
     * @param actionEvent
     * @throws Exception
     */
    public void DeleteCustomerButton(ActionEvent actionEvent) throws Exception {
        Customers deleteCustomer = CustomerTable.getSelectionModel().getSelectedItem();
        if (deleteCustomer != null) {

            if(Alerts.ConfirmationLog("Are you sure you want to delete customer ID: " + deleteCustomer.getCustomer_Id() +".\nAll appointments for this customer will be deleted as well.")) {

                ObservableList<Appointments> customersAppointments = AppointmentsQuery.getAllAppointmentsforCustomer(deleteCustomer.getCustomer_Id());

                if (customersAppointments.size() > 0) {
                    for (Appointments app : customersAppointments) {
                        AppointmentsQuery.deleteAppointment(app.getAppointment_Id());
                    }
                }
                //Delete Customer
                CustomersQuery.deleteCustomer(deleteCustomer.getCustomer_Id());

                Alerts.alertLog("Customer ID: " + deleteCustomer.getCustomer_Id() + " " + deleteCustomer.getCustomer_Name() + " has been deleted.\n" + "All appointments for this customer has been deleted as well.");
                //Repopulate Table
                //Customer Table
                CustomerTable.setItems(helper.CustomersQuery.getAllCustomers());

                ColumnCustId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
                ColumnName.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
                ColumnAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
                ColumnPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
                ColumnPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
                ColumnCreatedDate.setCellValueFactory(new PropertyValueFactory<>("Create_Date"));
                ColumnCreated.setCellValueFactory(new PropertyValueFactory<>("Created_By"));
                ColumnLastUpdate.setCellValueFactory(new PropertyValueFactory<>("Last_Update"));
                ColumnLastUpdateBy.setCellValueFactory(new PropertyValueFactory<>("Updated_By"));
                ColumnDivision.setCellValueFactory(new PropertyValueFactory<>("Division_Id"));

                RadioAll.setSelected(true);

                AppointmentTable.setItems(helper.AppointmentsQuery.getAllAppointments("All"));

                ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
                ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
                ColumnLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
                ColumnContact.setCellValueFactory(new PropertyValueFactory<>("Contact_id"));
                ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
                ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
                ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
                ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("User_Id"));
            }

        } else {
            helper.Alerts.errorLog("No Customer is selected");
        }
    }

    /**
     * This method is called when the Modify Customer button is pressed.
     * Passes selected customer to the Modify Customer scene.
     * @param actionEvent
     * @throws IOException
     */
    public void ModifyCustomerButton(ActionEvent actionEvent) throws IOException {

        Customers modifyCustomer = CustomerTable.getSelectionModel().getSelectedItem();
        if (modifyCustomer != null) {

            //Pass Customer to Modify Customer Controller
            ModifyCustomerController.getModifyCustomer(modifyCustomer);

            //Change Scene to Modify Customer Screen
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_ModifyCustomer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 361, 354);
            stage.setTitle("Modify Product Form");
            stage.setScene(scene);
            stage.show();

        } else {
            helper.Alerts.errorLog("No Customer is selected");
        }
    }

    /**
     * This method is called when the Add customer button is pressed.
     * The add customer scene is called.
     * @param actionEvent
     * @throws IOException
     */
    public void AddCustomerButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Add Customer Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_AddCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 361, 354);
        stage.setTitle("Modify Product Form");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is called when the Delete Appointment button is called.
     * Selected Appointment is deleted.
     * @param actionEvent
     * @throws Exception
     */
    public void DeleteAppointmentButton(ActionEvent actionEvent) throws Exception {

        Appointments deleteAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if (deleteAppointment != null) {

            AppointmentsQuery.deleteAppointment(deleteAppointment.getAppointment_Id());

            Alerts.alertLog("Appointment ID: " + deleteAppointment.getAppointment_Id() + " with Type " + deleteAppointment.getType() + " has been deleted.");

            RadioAll.setSelected(true);

            AppointmentTable.setItems(helper.AppointmentsQuery.getAllAppointments("All"));

            ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
            ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
            ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
            ColumnLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
            ColumnContact.setCellValueFactory(new PropertyValueFactory<>("Contact_id"));
            ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
            ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
            ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
            ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
            ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("User_Id"));

        } else {
            helper.Alerts.errorLog("No Appointment is selected");
        }
    }

    /**
     * This method is called when the Modify Appointment button is pressed.
     * Select appointment is passed to the Modify Appointment controller.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void ModifyAppointmentButton(ActionEvent actionEvent) throws IOException {

        Appointments modifyAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if (modifyAppointment != null) {

            //Pass Customer to Modify Customer Controller
            ModifyAppointmentController.getModifyAppointment(modifyAppointment);

            //Change Scene to Modify Appointment Screen
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_ModifyAppointment.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 504, 471);
            stage.setTitle("Modify Appointment");
            stage.setScene(scene);
            stage.show();

        } else {
            helper.Alerts.errorLog("No Appointment is selected");
        }
    }

    /**
     * This method is called when the Add Appointment button is pressed.
     * Add appointment scene starts.
     * @param actionEvent
     * @throws IOException
     */
    public void AddAppointmentButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Main Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_AddAppointment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 504, 471);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is called when the Report button is pressed.
     * This changes the scene to the report scene.
     * @param actionEvent
     * @throws IOException
     */
    public void ReportsButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Report Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_Reporting.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 724, 458);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is called on Init of this scene
     * Loads all data into the tables
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //Get Radio Button Filter
        //Create toggle group for Radio Buttons
        ToggleGroup group = new ToggleGroup();
        RadioAll.setToggleGroup(group);
        RadioMonth.setToggleGroup(group);
        RadioWeek.setToggleGroup(group);

        //Fill Tables
        try {
            //Appointment Table
            String filter = "All";
            AppointmentTable.setItems(helper.AppointmentsQuery.getAllAppointments(filter));

            ColumnAppId.setCellValueFactory(new PropertyValueFactory<>("Appointment_Id"));
            ColumnTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
            ColumnDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
            ColumnLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
            ColumnContact.setCellValueFactory(new PropertyValueFactory<>("Contact_id"));
            ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
            ColumnStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
            ColumnEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
            ColumnCustomerId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
            ColumnUserId.setCellValueFactory(new PropertyValueFactory<>("User_Id"));

            //Customer Table
            CustomerTable.setItems(helper.CustomersQuery.getAllCustomers());

            ColumnCustId.setCellValueFactory(new PropertyValueFactory<>("Customer_Id"));
            ColumnName.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
            ColumnAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            ColumnPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
            ColumnPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            ColumnCreatedDate.setCellValueFactory(new PropertyValueFactory<>("Create_Date"));
            ColumnCreated.setCellValueFactory(new PropertyValueFactory<>("Created_By"));
            ColumnLastUpdate.setCellValueFactory(new PropertyValueFactory<>("Last_Update"));
            ColumnLastUpdateBy.setCellValueFactory(new PropertyValueFactory<>("Updated_By"));
            ColumnDivision.setCellValueFactory(new PropertyValueFactory<>("Division_Id"));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method is called when the Logout button is called.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void logoutButton(ActionEvent actionEvent) throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("Language_files/rb");
        //Change Scene to Report Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_Login.fxml"));
        fxmlLoader.setResources(rb);
        Scene scene = new Scene(fxmlLoader.load(), 430, 203);
        stage.setTitle(rb.getString("Login"));
        stage.setScene(scene);
        stage.show();

    }
}