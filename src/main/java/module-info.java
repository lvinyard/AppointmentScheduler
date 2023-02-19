module vinyard.appointmentscheduler {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens vinyard.appointmentscheduler to javafx.fxml;
    exports vinyard.appointmentscheduler;
    exports model;
    exports helper;
}