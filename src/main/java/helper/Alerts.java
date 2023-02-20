package helper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Appointments;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

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
     * This method handles user confirmation.
     *
     * LAMBDA -
     * This method features the use of a lambda. The lamdba
     * in this function provides a cleaner function by reducing the lines of code.
     * This not only saving time writing but is easier for others to understand as all the code is  in front of them.
     * Without this Lamdba I would need an additional function to handle to response.
     *
     * @param error
     * @return
     */
    public static boolean ConfirmationLog(String error) {
        AtomicBoolean result = new AtomicBoolean(false);
        Alert confirmationLog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationLog.setContentText(error);

        confirmationLog.showAndWait().ifPresent((response -> {
            if(response == ButtonType.OK){

                result.set(true);
            }else{
                result.set(false);
            }

        }));
        return result.get();
    }

}
