module blackjackapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens blackjackapp to javafx.fxml;
    exports blackjackapp;
}
