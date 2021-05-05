module ru.specialist.java.fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    opens ru.specialist.java.fx to javafx.fxml;
    opens ru.specialist.java.fx.controller to javafx.fxml;
    opens ru.specialist.java.fx.view to javafx.base;
    opens ru.specialist.java.fx.view.hw to javafx.base;

    exports ru.specialist.java.fx;
    exports ru.specialist.java.fx.controller to javafx.fxml;
    exports ru.specialist.java.fx.view to javafx.graphics;
    exports ru.specialist.java.fx.view.hw to javafx.graphics;
}