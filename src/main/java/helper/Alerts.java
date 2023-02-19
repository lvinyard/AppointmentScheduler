package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Appointments;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * This helper class is responsible for the various alerts and
 * dialogs that is presented to the user.
 *
 */
public class Alerts {
    /**
     * This method handles presenting errors to the user
     * @param error
     */
    public static void errorLog(String error){
        Alert errorLog = new Alert(Alert.AlertType.ERROR);
        errorLog.setContentText(error);
        errorLog.show();
    }

    /**
     * This method handles presenting alerts to the user
     */
    public static void alertLog(String error){
        Alert errorLog = new Alert(Alert.AlertType.INFORMATION);
        errorLog.setContentText(error);
        errorLog.show();
    }

    /**
     * This method is called on sign in, and checks for any appointments in the next 15 minutes
     * @throws Exception
     */
    public static void logonAlert() throws Exception {
        ObservableList<Appointments> allAppointments = AppointmentsQuery.getAllAppointments("All");
        ObservableList<Appointments> upcomingAppointments = FXCollections.observableArrayList();
        String alert = "";
        for(Appointments app : allAppointments){
            if(app.getStart().isAfter(LocalDateTime.now()) && app.getStart().isBefore(LocalDateTime.now().plusMinutes(15)) ){
                upcomingAppointments.add(app);
                alert += "The appointment ID: " + app.getAppointment_Id() + " starts at " + app.getStart() + ".\n";
            }
        }
        if(upcomingAppointments.size() > 0){

            alertLog(alert);

        }else{
            alertLog("There are no appointments within the next 15 minutes.");
        }

    }

    /**
     * This method handles user confirmation
     * @param error
     * @return
     */
    public static boolean ConfirmationLog(String error){
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
