package edu.uwi.soscai.component;

import java.io.IOException;
import java.net.URL;

import edu.uwi.soscai.App;
import edu.uwi.soscai.misc.Dashboard;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class WeatherDashboard extends VBox implements Dashboard {
    private final ListProperty<WeatherCard> weatherList = new SimpleListProperty<>(FXCollections.observableArrayList());
    private final ToggleGroup selectGroup = new ToggleGroup();

    public WeatherDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(WEATHER_DASHBOARD);
            loader.setRoot(this);
            loader.setController(new DashboardController());
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<WeatherCard> getWeatherList() {
        return weatherList.get();
    }

    public ListProperty<WeatherCard> weatherListProperty() {
        return weatherList;
    }

    private class DashboardController {
        @FXML
        private HBox weatherArr;

        @FXML
        public final Label emptyLabel = new Label("No Weather Updates");

        @FXML
        private void initialize() {
            emptyLabel.setMaxWidth(Double.MAX_VALUE);
            emptyLabel.setMaxHeight(Double.MAX_VALUE);
            emptyLabel
                    .setStyle("-fx-font-size: 36pt; -fx-text-fill: grey; -fx-font-weight: bold;-fx-alignment:center;");
            weatherArr.getChildren().add(emptyLabel);
            HBox.setHgrow(emptyLabel, Priority.ALWAYS);
            weatherList.addListener(new WeatherListListener());
        }

        private class WeatherListListener implements ListChangeListener<WeatherCard> {

            @Override
            public void onChanged(Change<? extends WeatherCard> c) {
                while (c.next()) {
                    if (c.wasPermutated()) {
                    } else if (c.wasUpdated()) {
                    } else {
                        if (c.getList().isEmpty()) {
                            weatherArr.getChildren().clear();
                            weatherArr.getChildren().add(emptyLabel);
                        } else {
                            if (weatherArr.getChildren().contains(emptyLabel))
                                weatherArr.getChildren().remove(emptyLabel);
                            for (WeatherCard card : c.getAddedSubList()) {
                                weatherArr.getChildren().add(card);
                                HBox.setHgrow(card, Priority.ALWAYS);
                                selectGroup.getToggles().add(card);
                            }
                            for (WeatherCard card : c.getRemoved()) {
                                weatherArr.getChildren().remove(card);
                                selectGroup.getToggles().remove(card);

                            }
                        }
                    }
                }
            }

        }

    }

    private static final URL WEATHER_DASHBOARD = App.class
            .getResource("component/layout/dashboard/weather-dashboard.fxml");
}
