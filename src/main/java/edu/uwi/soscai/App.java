package edu.uwi.soscai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(FXMLLoader.load(App.class.getResource("view/app.fxml")));
        stage.setTitle("Weather App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static final String GEOCODING_ENDPOINT = "http://api.openweathermap.org/geo/1.0/direct";
    public static final String API_KEY = "0ce3ce5b8c377a72d2347cd2a6bc9e22";
}
