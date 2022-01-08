module com.dms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.dms to javafx.fxml;
    opens com.dms.View to javafx.fxml;
    opens com.dms.Controller to javafx.fxml;


    exports com.dms;
    exports com.dms.Po;
    exports com.dms.View;
    exports com.dms.Controller;

    exports com.dms.DmsUtils; // 爱了
    exports com.dms.Ex;
    exports com.dms.Dao;
    exports com.dms.Service.Implementation;
    exports com.dms.Service.Interfaces;

}