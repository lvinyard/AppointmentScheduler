package vinyard.appointmentscheduler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AddCustomerController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}