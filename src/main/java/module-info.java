module com.example.seminarjavafxsql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.seminarjavafxsql to javafx.fxml;
    exports com.example.seminarjavafxsql;
}