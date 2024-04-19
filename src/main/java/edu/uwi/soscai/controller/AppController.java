package edu.uwi.soscai.controller;

import java.net.URL;
import java.util.ResourceBundle;

import edu.uwi.soscai.component.AlertDashboard;
import edu.uwi.soscai.component.WeatherDashboard;
import edu.uwi.soscai.misc.WeatherCardFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup hourSelect;

    @FXML
    private Tooltip message_tt;

    @FXML
    private TextField search_tf;

    @FXML
    private ToggleGroup tempUnit;

    @FXML
    private ToggleGroup weatherView;

    @FXML
    private ScrollPane content;

    private SwitchRootComponent switchRootComponent;

    @FXML
    void clearSearchBar(ActionEvent event) {

    }

    @FXML
    void showAppSettings(ActionEvent event) {

    }

    @FXML
    void initialize() {
        switchRootComponent = new SwitchRootComponent();

    }

    public class SwitchRootComponent implements ChangeListener<Toggle> {
        private final WeatherDashboard todayDashboard = new WeatherDashboard();
        private final WeatherDashboard weekDashboard = new WeatherDashboard();
        private final AlertDashboard alertDashboard = new AlertDashboard();

        public SwitchRootComponent() {
            weatherView.selectedToggleProperty().addListener(this);
            weatherView.getToggles().get(0).setSelected(true);
            double[] temp = new double[] { 20, 40 };
            WeatherCardFactory weatherCardFactory = new WeatherCardFactory(temp, temp, 0.25, 0.28);
            todayDashboard.getWeatherList().addAll(
                    weatherCardFactory.generate(13, 6, true));
            weekDashboard.getWeatherList().addAll(weatherCardFactory.generate(5, 14, false));
        }

        @Override
        public void changed(ObservableValue<? extends Toggle> o, Toggle l, Toggle n) {
            if (n == null) {
                weatherView.getToggles().get(0).setSelected(true);
                return;
            }
            if (l == n) {
                return;
            }
            if (n.getUserData().equals("NOW")) {
                content.setContent(todayDashboard);
            } else if (n.getUserData().equals("WEEKLY")) {
                content.setContent(weekDashboard);
            } else if (n.getUserData().equals("ALERTS")) {
                content.setContent(alertDashboard);
            }
        }
    }
}