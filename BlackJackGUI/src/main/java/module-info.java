module com.mycompany.blackjackgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.blackjackgui to javafx.fxml;
    exports com.mycompany.blackjackgui;
}
