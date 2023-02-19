package vinyard.appointmentscheduler;

import helper.Alerts;
import helper.UsersQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

/**
 * This class handles the logic of the Login screen
 */
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

    ResourceBundle rb;

    /**
     * File not Found exception
     * @throws FileNotFoundException
     */
    public LoginController() throws FileNotFoundException {

    }

    /**
     * This method is called when the login button is called. Validates login and then starts main scene.
     * @param actionEvent
     * @throws Exception
     */
    public void LoginButton(ActionEvent actionEvent) throws Exception {

        try{
            UsersQuery.logOnUser(UsernameField.getText(), PasswordField.getText());

            //Change Scene to Main Screen
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_MainScreen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1075, 617);
            stage.setTitle("Appointment Scheduler");
            stage.setScene(scene);
            stage.show();

            Alerts.logonAlert();

            PrintWriter pwLog = new PrintWriter( new FileOutputStream(new File("src/main/login_activity.txt"),true));
            pwLog.append(LocalDateTime.now().toString() + "| Login Attempt Successful for User " + UsernameField.getText() + ".\n");
            pwLog.close();

        } catch (Exception e) {
            System.out.println(e);
            Alerts.errorLog(rb.getString("LoginError"));

            PrintWriter pwLog = new PrintWriter( new FileOutputStream(new File("src/main/login_activity.txt"),true));
            pwLog.append(LocalDateTime.now().toString() + "| Login Attempt Failed for User " + UsernameField.getText() + ".\n");
            pwLog.close();
        }
    }

    /**
     * This method is called when the Exit Button is pressed.
     * @param actionEvent
     */
    public void CancelButton(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * This method is called on init of this scene.
     * @param url
     * @param rb
     */
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