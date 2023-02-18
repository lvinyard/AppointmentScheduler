package vinyard.appointmentscheduler;

import helper.Alerts;
import helper.UsersQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class LoginController implements Initializable {
    public TextField UsernameField;
    public javafx.scene.control.PasswordField PasswordField;
    public Button loginButton;
    public Button cancelButton;
    public Text usernameText;
    public Text passwordText;
    public Text locationText;
    public Label LocationField;
    public Label LanguageField;
    public Text languageText;
    ZoneId zoneId = ZoneId.systemDefault();
    @FXML
    private Label welcomeText;
    ResourceBundle rb;


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
            Alerts.errorLog(rb.getString("LoginError"));
        }
    }

    public void CancelButton(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //gets resource
        this.rb = rb;
        System.out.println(Locale.getDefault());

        //Sets all text as correct language
        usernameText.setText(rb.getString("Username"));
        passwordText.setText(rb.getString("Password"));
        locationText.setText(rb.getString("Location"));
        languageText.setText(rb.getString("Language"));
        loginButton.setText(rb.getString("Login"));
        cancelButton.setText(rb.getString("Cancel"));
        LanguageField.setText(String.valueOf(Locale.getDefault()));
        LocationField.setText(String.valueOf(zoneId));


    }
}