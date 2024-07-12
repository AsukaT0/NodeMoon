module com.asuka.nodemoonv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.asuka.nodemoonv1 to javafx.fxml;
    exports com.asuka.nodemoonv1;
}