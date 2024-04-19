package edu.uwi.soscai.component;

import java.io.IOException;
import java.net.URL;

import edu.uwi.soscai.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AlertDashboard extends GridPane {
    public AlertDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(ALERT_DASHBOARD);
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final URL ALERT_DASHBOARD = App.class
            .getResource("component/layout/dashboard/alert-dashboard.fxml");
}
