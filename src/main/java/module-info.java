module com.dms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.dms to javafx.fxml;
    exports com.dms;
    exports View;
}