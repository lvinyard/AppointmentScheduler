package vinyard.appointmentscheduler;
import helper.JDBC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(new Locale("fr", "FR"));
        ResourceBundle rb = ResourceBundle.getBundle("Language_files/rb");
        System.out.println("You're language is set to " + Locale.getDefault());

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/vinyard/appointmentscheduler/AS_login.fxml"));
        fxmlLoader.setResources(rb);
        Scene scene = new Scene(fxmlLoader.load(), 430, 203);
        stage.setTitle(rb.getString("Login"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        JDBC.openConnection();
        launch();
        JDBC.closeConnection();
    }
}