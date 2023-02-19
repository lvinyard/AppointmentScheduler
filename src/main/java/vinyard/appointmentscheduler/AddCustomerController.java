package vinyard.appointmentscheduler;

import helper.Alerts;
import helper.CountryQuery;
import helper.CustomersQuery;
import helper.DivisionQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * This class handles the login in the Add Customer Screen
 */
public class AddCustomerController implements Initializable {
    public TextField CustomerIdField;
    public TextField NameField;
    public TextField AddressField;
    public TextField PostalCodeField;
    public TextField PhoneNumberField;
    public ComboBox DivisionField;
    public ComboBox CountryField;

    /**
     * This method is invoked when the Cancel Button is pressed. Takes user back to main screen.
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
     * This method is invoked when the Save Button is pressed. Saves Customer to the database.
     * @param actionEvent
     * @throws Exception
     */
    public void SaveButton(ActionEvent actionEvent) throws Exception {

        if(DivisionField.getSelectionModel().getSelectedItem() == null){
            Alerts.errorLog("Please choose a division.");
            return;
        }
        int updateId = Integer.parseInt(CustomerIdField.getText());
        String updateName = NameField.getText();
        String updateAddress = AddressField.getText();
        String updatePostal = PostalCodeField.getText();
        String updatePhone = PhoneNumberField.getText();
        int updateDivision = DivisionQuery.getDivisionId(String.valueOf(DivisionField.getSelectionModel().getSelectedItem()));


        if(updateName != "" && updateAddress != "" && updatePostal != "" && updatePhone != ""){

            try{
                //Do update
                helper.CustomersQuery.AddCustomer(updateId, updateName, updateAddress, updatePostal, updatePhone, updateDivision);

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
     * This method is called on init of this scene. This loads all data into the form.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            CustomerIdField.setText(String.valueOf(CustomersQuery.newCustomerId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CountryField.selectionModelProperty();
        DivisionField.selectionModelProperty();

        try {
            CountryField.getItems().addAll(CountryQuery.getAllCountriesName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        CountryField.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {

                try {
                    DivisionField.getItems().clear();
                    DivisionField.getItems().addAll(DivisionQuery.getDivisionsNames(CountryQuery.findCountryId(String.valueOf(CountryField.getSelectionModel().getSelectedItem()))));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                DivisionField.setDisable(false);
            }
        });
    }
}