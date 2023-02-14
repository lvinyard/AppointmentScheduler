package helper;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {
    /**
     * This method handles presenting errors to the user
     * @param error
     */
    public void errorLog(String error){
        Alert errorLog = new Alert(Alert.AlertType.ERROR);
        errorLog.setContentText(error);
        errorLog.show();
    }

    /**
     * This method handles user confirmation
     * @param error
     * @return
     */
    public boolean ConfirmationLog(String error){
        Alert confirmationLog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationLog.setContentText(error);
        Optional<ButtonType> result = confirmationLog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        }else{
            return false;
        }
    }

}
