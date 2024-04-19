package edu.uwi.soscai.model;

import java.time.LocalDate;

public class DayForecast {
    private LocalDate forecastDate;
    private TemperatureData temperatureData;
    private TemperatureData feelsLikeData;
    private double pressure;
    private int humidity;
    private WeatherData weatherData;
    private double windSpeed;
    private int windDirection;
    private double windGust;
    private int clouds;
    private double rainVolume;
    private double snowVolume;
    private double probabilityOfPrecipitation;

    public DayForecast() {
        // Default constructor
    }


    public LocalDate getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(LocalDate forecastDate) {
        this.forecastDate = forecastDate;
    }

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(TemperatureData temperatureData) {
        this.temperatureData = temperatureData;
    }

    public TemperatureData getFeelsLikeData() {
        return feelsLikeData;
    }

    public void setFeelsLikeData(TemperatureData feelsLikeData) {
        this.feelsLikeData = feelsLikeData;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double rainVolume) {
        this.rainVolume = rainVolume;
    }

    public double getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(double snowVolume) {
        this.snowVolume = snowVolume;
    }

    public double getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public void setProbabilityOfPrecipitation(double probabilityOfPrecipitation) {
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }

    // Nested classes representing temperature data and weather data

    public static class TemperatureData {
        private double day;
        private double min;
        private double max;
        private double night;
        private double evening;
        private double morning;

        // Getters and setters for temperature data fields
        // Implement as needed
    }

    public static class WeatherData {
        private int id;
        private String main;
        private String description;
        private String icon;

        // Getters and setters for weather data fields
        // Implement as needed
    }
}
