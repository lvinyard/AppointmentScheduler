package vinyard.appointmentscheduler;

import helper.Alerts;
import helper.CountryQuery;
import helper.DivisionQuery;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Countries;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

/**
 * This class handles the controls and logic of the Modify Customer scene.
 */
public class ModifyCustomerController implements Initializable {
    public TextField CustomerIdField;
    public TextField NameField;
    public TextField AddressField;
    public TextField PostalCodeField;
    public TextField PhoneNumberField;
    public ComboBox DivisionField;
    public ComboBox CountryField;
    private static Customers modifyCustomer = null;

    /**
     * This method is called to pass the modified customer from main scene to this scene
     * @param customer
     */
    public static void getModifyCustomer(Customers customer){
        modifyCustomer = customer;
    }

    /**
     * This method is called when the Cancel button is pressed.
     * Scene changed back to main screen.
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
     * This method is called when the Save Button is pressed.
     * The modified Customer is updated in the database.
     * @param actionEvent
     * @throws Exception
     */
    public void SaveButton(ActionEvent actionEvent) throws Exception {

        if(DivisionField.getSelectionModel().getSelectedItem() == null){
            Alerts.errorLog("Please choose a division.");
            return;
        }

        String updateName = NameField.getText();
        String updateAddress = AddressField.getText();
        String updatePostal = PostalCodeField.getText();
        String updatePhone = PhoneNumberField.getText();
        int updateDivision = DivisionQuery.getDivisionId(String.valueOf(DivisionField.getSelectionModel().getSelectedItem()));


        if(updateName != "" && updateAddress != "" && updatePostal != "" && updatePhone != ""){

            try{
                //Do update
                helper.CustomersQuery.updateCustomer(modifyCustomer.getCustomer_Id(), updateName, updateAddress, updatePostal, updatePhone, updateDivision);

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
     * This method is called on init of the scene.
     * Loads all the modified customer details into the form.
     *
     * LAMBDA on Line 133
     * The justification for this Lambda expression is that is simplifies the code where another method would be required.
     * The Lambda expression takes in 3 parameters, and you are able to see the entire logic of the listener in the same
     * code block as it is being utilized in.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Load ModifyCustomer to screen
        CustomerIdField.setText(String.valueOf(modifyCustomer.getCustomer_Id()));
        NameField.setText(modifyCustomer.getCustomer_Name());
        AddressField.setText(modifyCustomer.getAddress());
        PostalCodeField.setText(modifyCustomer.getPostalCode());
        PhoneNumberField.setText(modifyCustomer.getPhone());
        CountryField.selectionModelProperty();
        DivisionField.selectionModelProperty();
        try {
            CountryField.getItems().addAll(CountryQuery.getAllCountriesName());
            DivisionField.getItems().addAll(DivisionQuery.getDivisionsNames(CountryQuery.findCountryId(modifyCustomer.getDivision_Id())));
            DivisionField.setValue(helper.DivisionQuery.getDivisionName(modifyCustomer.getDivision_Id()));
            CountryField.setValue(helper.CountryQuery.findCountryName(helper.CountryQuery.findCountryId(modifyCustomer.getDivision_Id())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CountryField.valueProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal != null) {

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