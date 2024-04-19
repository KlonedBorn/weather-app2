package edu.uwi.soscai.model;

import java.net.URL;

import edu.uwi.soscai.App;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum WeatherCondition {
    CLOUDY_DAY("/cloudy-day.png"), CLOUDY_WINDY("/cloudy-windy.png"), CLOUDY("/cloudy.png"),
    HEAVY_RAIN("/heavy-rain.png"),
    PARTLY_CLOUDY("/partly-cloudy.png"), RAINY_DAY("/rainy-day.png"),
    SCATTERED_THUNDERSTORMS("/scattered-thunderstorms.png"),
    SNOWY("/snowy.png"), STORM("/storm.png"), SUNNY("/sunny.png"), THUNDERSTORM("/thunderstorm.png"),
    WINDY("/windy.png");

    private final URL imgPath;

    WeatherCondition(String imgPath) {
        this.imgPath = App.class.getResource("img/condition" + imgPath);
    }

    public Image getIcon() {
        Image img = new Image(imgPath.toExternalForm());
        return img;
    }

    public ImageView getView(double s) {
        Image img = getIcon();
        ImageView iv = new ImageView(img);
        iv.setPreserveRatio(true);
        iv.setFitWidth(s);
        iv.setFitHeight(s);
        return iv;
    }

    // Method to map weather ID to WeatherCondition
    public static WeatherCondition getConditionFromId(int weatherId) {
        switch (weatherId) {
            // Group 2xx: Thunderstorm
            case 200:
            case 201:
            case 202:
            case 210:
            case 211:
            case 212:
            case 221:
            case 230:
            case 231:
            case 232:
                return THUNDERSTORM;

            // Group 3xx: Drizzle
            case 300:
            case 301:
            case 302:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                return SCATTERED_THUNDERSTORMS; // Using same icon for drizzle as specified in your example

            // Group 5xx: Rain
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 511:
            case 520:
            case 521:
            case 522:
            case 531:
                return HEAVY_RAIN;

            // Group 6xx: Snow
            case 600:
            case 601:
            case 602:
            case 611:
            case 612:
            case 613:
            case 615:
            case 616:
            case 620:
            case 621:
            case 622:
                return SNOWY;

            // Group 7xx: Atmosphere
            case 701:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
            case 762:
            case 771:
            case 781:
                return CLOUDY; // Using same icon for atmosphere as specified in your example

            // Group 800: Clear
            case 800:
                return SUNNY;

            // Group 80x: Clouds
            case 801:
            case 802:
            case 803:
            case 804:
                return CLOUDY_DAY;

            default:
                return SUNNY;
        }
    }
}
