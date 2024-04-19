package edu.uwi.soscai.component;

import java.io.IOException;
import java.net.URL;

import edu.uwi.soscai.App;
import edu.uwi.soscai.model.WeatherCondition;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

public class WeatherCard extends ToggleButton {
    private final ObjectProperty<WeatherCondition> conditionProperty = new SimpleObjectProperty<>(this, "condition");
    private final DoubleProperty tempProperty = new SimpleDoubleProperty(this, "temp");
    private final DoubleProperty feelLikeProperty = new SimpleDoubleProperty(this, "feel-like");
    private final BooleanProperty hourOrDayProperty = new SimpleBooleanProperty(this, "hour-or-day");
    private final IntegerProperty timeProperty = new SimpleIntegerProperty(this, "time");

    public WeatherCard(int time, WeatherCondition condition, double temp, double feelLike, boolean hourOrDay) {
        super();
        this.timeProperty.set(time);
        this.conditionProperty.set(condition);
        this.tempProperty.set(temp);
        this.feelLikeProperty.set(feelLike);
        this.hourOrDayProperty.set(hourOrDay);
        try {
            FXMLLoader loader = new FXMLLoader(INFO_CARD_PATH);
            loader.setRoot(this);
            loader.setController(new CardController());
            loader.load();
        } catch (IOException e) {
        }
    }

    /**
     * Generates a demo weather card with random weather conditions and
     * temperature values.
     * 
     * @return A demo weather card
     */
    public static WeatherCard demo() {
        // Generate a random weather card
        WeatherCondition[] conditions = WeatherCondition.values();
        WeatherCondition condition = conditions[(int) (Math.random() * conditions.length)];
        double temp = Math.round(Math.random() * 40) + 10;
        double feelLike = Math.round(Math.random() * 10) - 5;
        boolean hourOrDay = (Math.random() < 0.5);
        int time = (hourOrDay ? (int) (Math.random() * 24) : (int) (Math.random() * 7));
        return new WeatherCard(time, condition, temp, feelLike, hourOrDay);
    }

    private class CardController {

        @FXML
        private ImageView condition_iv;

        @FXML
        private Label feelLike_lbl;

        @FXML
        private Label hourDay_lbl;

        @FXML
        private Label temp_lbl;

        @FXML
        void initialize() {
            hourDay_lbl.textProperty().bind(getTimeFormatBinding());
            temp_lbl.textProperty().bind(tempProperty.asString("%2.1f°C"));
            feelLike_lbl.textProperty().bind(feelLikeProperty.asString("°%2.1f°C"));
            condition_iv.imageProperty().bind(conditionProperty.map(WeatherCondition::getIcon));
        }

        private StringBinding getTimeFormatBinding() {
            return Bindings.createStringBinding(() -> {
                if (isHourOrDay()) {
                    int hour = getTime();
                    String suffix = "am";
                    if (hour >= 12) {
                        suffix = "pm";
                        if (hour > 12) {
                            hour -= 12;
                        }
                    }
                    return String.format("%d:%02d %s", hour, 0, suffix);
                } else {
                    return DAYS_OF_THE_WEEK[getTime() % DAYS_OF_THE_WEEK.length];
                }
            }, timeProperty, hourOrDayProperty);
        }

    }

    public WeatherCondition getCondition() {
        return conditionProperty.get();
    }

    public ObjectProperty<WeatherCondition> conditionProperty() {
        return conditionProperty;
    }

    public void setCondition(WeatherCondition condition) {
        conditionProperty.set(condition);
    }

    public double getTemp() {
        return tempProperty.get();
    }

    public DoubleProperty tempProperty() {
        return tempProperty;
    }

    public void setTemp(double temp) {
        tempProperty.set(temp);
    }

    public double getFeelLike() {
        return feelLikeProperty.get();
    }

    public DoubleProperty feelLikeProperty() {
        return feelLikeProperty;
    }

    public void setFeelLike(double feelLike) {
        feelLikeProperty.set(feelLike);
    }

    public boolean isHourOrDay() {
        return hourOrDayProperty.get();
    }

    public BooleanProperty hourOrDayProperty() {
        return hourOrDayProperty;
    }

    public void setHourOrDay(boolean hourOrDay) {
        hourOrDayProperty.set(hourOrDay);
    }

    public int getTime() {
        return timeProperty.get();
    }

    public IntegerProperty timeProperty() {
        return timeProperty;
    }

    public void setTime(int time) {
        timeProperty.set(time);
    }

    private static final String[] DAYS_OF_THE_WEEK = new String[] {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };
    private static final URL INFO_CARD_PATH = App.class.getResource("component/layout/card/info-card.fxml");

}
