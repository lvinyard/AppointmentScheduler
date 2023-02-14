package vinyard.appointmentscheduler;

import helper.Alerts;
import helper.UsersQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField UsernameField;
    public javafx.scene.control.PasswordField PasswordField;
    public Label LocationText;
    public Label LanguageText;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void LoginButton(ActionEvent actionEvent) throws Exception {

        try{
            UsersQuery.logOnUser(UsernameField.getText(), PasswordField.getText());


            //Change Scene to Main Screen
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_MainScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
            stage.setTitle("Modify Product Form");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            Alerts.errorLog("Incorrect Login");
        }
    }

    public void CancelButton(ActionEvent actionEvent) {
    }
}