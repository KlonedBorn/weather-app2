module edu.uwi.soscai {
    requires transitive javafx.controls;

    requires transitive javafx.fxml;

    requires transitive javafx.graphics;

    requires javafx.base;

    requires org.controlsfx.controls;

    requires commons.io;

    requires transitive org.json;

    requires java.net.http;

    opens edu.uwi.soscai to javafx.fxml;

    exports edu.uwi.soscai;

    opens edu.uwi.soscai.component to javafx.fxml;

    exports edu.uwi.soscai.component;

    opens edu.uwi.soscai.controller to javafx.fxml;

    exports edu.uwi.soscai.controller;

    opens edu.uwi.soscai.model to javafx.fxml;

    exports edu.uwi.soscai.model;
}
