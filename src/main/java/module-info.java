module com.mycompany.blackjackapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.blackjackapp to javafx.fxml;
    exports com.mycompany.blackjackapp;
}
