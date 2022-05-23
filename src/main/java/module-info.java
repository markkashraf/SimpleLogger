module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires org.apache.commons.codec;


    opens com.project to javafx.fxml;
    exports com.project;
}