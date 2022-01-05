module com.dms.dms20221 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dms.dms20221 to javafx.fxml;
    exports com.dms.dms20221;
}