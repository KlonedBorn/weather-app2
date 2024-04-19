package edu.uwi.soscai.misc;

import java.util.List;
import java.util.Random;

import edu.uwi.soscai.component.WeatherCard;
import edu.uwi.soscai.model.WeatherCondition;

public class WeatherCardFactory {
    private double[] temp_range;
    private double[] feel_like_range;
    private double temp_change;
    private double feel_like_change;

    public WeatherCardFactory(double[] temp_range, double[] feel_like_range, double temp_change,
            double feel_like_change) {
        this.temp_range = temp_range;
        this.feel_like_range = feel_like_range;
        this.temp_change = temp_change;
        this.feel_like_change = feel_like_change;
    }

    public List<WeatherCard> generate(int start_time, int count, boolean hour_or_day) {
        List<WeatherCard> cards = new java.util.ArrayList<>();
        Random rand = new Random();
        double temp = temp_range[0] + (temp_range[1] - temp_range[0]) * rand.nextDouble();
        double feelLike = feel_like_range[0] + (feel_like_range[1] - feel_like_range[0]) * rand.nextDouble();
        int time = start_time;
        for (int i = 0; i < count; i++) {
            WeatherCondition cond = WeatherCondition.values()[rand.nextInt(WeatherCondition.values().length)];
            WeatherCard card = new WeatherCard(time, cond, temp, feelLike, hour_or_day);
            cards.add(card);
            temp = temp + (temp_change * rand.nextDouble()) - temp_change / 2.0;
            feelLike = feelLike + (feel_like_change * rand.nextDouble()) - feel_like_change / 2.0;
            time++;
            time = hour_or_day ? (time % 24) : (time % 7);
        }
        return cards;
    }
}
