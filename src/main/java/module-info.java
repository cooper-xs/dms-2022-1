module com.dms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires junit;


    opens com.dms to javafx.fxml;
    opens View to javafx.fxml;
    exports com.dms;
    exports View;
}