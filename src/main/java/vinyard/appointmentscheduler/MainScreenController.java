package vinyard.appointmentscheduler;

import helper.UsersQuery;
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
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    public TableColumn ColumnnDivision;
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
    @FXML
    private Label welcomeText;


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

    public void DeleteCustomerButton(ActionEvent actionEvent) {
        Customers deleteCustomer = CustomerTable.getSelectionModel().getSelectedItem();
        if(deleteCustomer != null){

        }else{
            helper.Alerts.errorLog("No Customer is selected");
        }
    }

    public void ModifyCustomerButton(ActionEvent actionEvent) throws IOException {

        Customers modifyCustomer = CustomerTable.getSelectionModel().getSelectedItem();
        if(modifyCustomer != null){

            //Pass Customer to Modify Customer Controller
            ModifyCustomerController.getModifyCustomer(modifyCustomer);

            //Change Scene to Modify Customer Screen
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_ModifyCustomer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 361, 354);
            stage.setTitle("Modify Product Form");
            stage.setScene(scene);
            stage.show();

        }else{
            helper.Alerts.errorLog("No Customer is selected");
        }
    }
    public void AddCustomerButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Add Customer Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_AddCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 361, 354);
        stage.setTitle("Modify Product Form");
        stage.setScene(scene);
        stage.show();
    }
    public void DeleteAppointmentButton(ActionEvent actionEvent) {

        Appointments deleteAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if(deleteAppointment != null){

        }else{
            helper.Alerts.errorLog("No Appointment is selected");
        }
    }
    public void ModifyAppointmentButton(ActionEvent actionEvent) throws IOException {

        Appointments modifyAppointment = AppointmentTable.getSelectionModel().getSelectedItem();
        if(modifyAppointment != null){

            //Pass Customer to Modify Customer Controller
            ModifyAppointmentController.getModifyAppointment(modifyAppointment);

            //Change Scene to Modify Appointment Screen
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_ModifyAppointment.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 504, 471);
            stage.setTitle("Modify Appointment");
            stage.setScene(scene);
            stage.show();

        }else{
            helper.Alerts.errorLog("No Appointment is selected");
        }
    }
    public void AddAppointmentButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Main Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_AddAppointment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 504, 471);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
    }
    public void ReportsButton(ActionEvent actionEvent) throws IOException {

        //Change Scene to Report Screen
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_Reporting.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 724, 458);
        stage.setTitle("Reports");
        stage.setScene(scene);
        stage.show();
    }
    public void ExitButton(ActionEvent actionEvent) {
    }

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
            ColumnnDivision.setCellValueFactory(new PropertyValueFactory<>("Division_Id"));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}