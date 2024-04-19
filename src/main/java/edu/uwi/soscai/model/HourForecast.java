package edu.uwi.soscai.model;

import java.time.LocalDateTime;

public class HourForecast {
    private LocalDateTime forecastTime;
    private TemperatureData temperatureData;
    private WeatherData weatherData;
    private CloudData cloudData;
    private WindData windData;
    private PrecipitationData precipitationData;
    private VisibilityData visibilityData;
    private double probabilityOfPrecipitation;
    private SystemData systemData;
    private String forecastTimeText;

    public HourForecast() {
    }

    public HourForecast(LocalDateTime forecastTime, TemperatureData temperatureData, WeatherData weatherData,
            CloudData cloudData, WindData windData, PrecipitationData precipitationData, VisibilityData visibilityData,
            double probabilityOfPrecipitation, SystemData systemData, String forecastTimeText) {
        this.forecastTime = forecastTime;
        this.temperatureData = temperatureData;
        this.weatherData = weatherData;
        this.cloudData = cloudData;
        this.windData = windData;
        this.precipitationData = precipitationData;
        this.visibilityData = visibilityData;
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
        this.systemData = systemData;
        this.forecastTimeText = forecastTimeText;
    }

    public LocalDateTime getForecastTime() {
        return forecastTime;
    }

    public void setForecastTime(LocalDateTime forecastTime) {
        this.forecastTime = forecastTime;
    }

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(TemperatureData temperatureData) {
        this.temperatureData = temperatureData;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public CloudData getCloudData() {
        return cloudData;
    }

    public void setCloudData(CloudData cloudData) {
        this.cloudData = cloudData;
    }

    public WindData getWindData() {
        return windData;
    }

    public void setWindData(WindData windData) {
        this.windData = windData;
    }

    public PrecipitationData getPrecipitationData() {
        return precipitationData;
    }

    public void setPrecipitationData(PrecipitationData precipitationData) {
        this.precipitationData = precipitationData;
    }

    public VisibilityData getVisibilityData() {
        return visibilityData;
    }

    public void setVisibilityData(VisibilityData visibilityData) {
        this.visibilityData = visibilityData;
    }

    public double getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public void setProbabilityOfPrecipitation(double probabilityOfPrecipitation) {
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }

    public SystemData getSystemData() {
        return systemData;
    }

    public void setSystemData(SystemData systemData) {
        this.systemData = systemData;
    }

    public String getForecastTimeText() {
        return forecastTimeText;
    }

    public void setForecastTimeText(String forecastTimeText) {
        this.forecastTimeText = forecastTimeText;
    }

    // Nested classes representing different data structures

    public static class TemperatureData {
        private double temperature;
        private double feelsLike;
        private double minTemperature;
        private double maxTemperature;
        private double pressure;
        private double seaLevelPressure;
        private double groundLevelPressure;
        private int humidity;

        public TemperatureData() {
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public double getMinTemperature() {
            return minTemperature;
        }

        public void setMinTemperature(double minTemperature) {
            this.minTemperature = minTemperature;
        }

        public double getMaxTemperature() {
            return maxTemperature;
        }

        public void setMaxTemperature(double maxTemperature) {
            this.maxTemperature = maxTemperature;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public double getSeaLevelPressure() {
            return seaLevelPressure;
        }

        public void setSeaLevelPressure(double seaLevelPressure) {
            this.seaLevelPressure = seaLevelPressure;
        }

        public double getGroundLevelPressure() {
            return groundLevelPressure;
        }

        public void setGroundLevelPressure(double groundLevelPressure) {
            this.groundLevelPressure = groundLevelPressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

    }

    public static class WeatherData {
        private int weatherId;
        private String weatherGroup;
        private String weatherDescription;
        private String weatherIconId;
        private WeatherCondition weatherCondition;

        public WeatherData() {
        }

        public WeatherData(int weatherId, String weatherGroup, String weatherDescription, String weatherIconId) {
            this.weatherId = weatherId;
            this.weatherGroup = weatherGroup;
            this.weatherDescription = weatherDescription;
            this.weatherIconId = weatherIconId;
            this.weatherCondition = WeatherCondition.getConditionFromId(weatherId);
        }

        public int getWeatherId() {
            return weatherId;
        }

        public void setWeatherId(int weatherId) {
            this.weatherId = weatherId;
        }

        public String getWeatherGroup() {
            return weatherGroup;
        }

        public void setWeatherGroup(String weatherGroup) {
            this.weatherGroup = weatherGroup;
        }

        public String getWeatherDescription() {
            return weatherDescription;
        }

        public void setWeatherDescription(String weatherDescription) {
            this.weatherDescription = weatherDescription;
        }

        public String getWeatherIconId() {
            return weatherIconId;
        }

        public void setWeatherIconId(String weatherIconId) {
            this.weatherIconId = weatherIconId;
        }

        public WeatherCondition getCondition() {
            return WeatherCondition.getConditionFromId(weatherId);
        }

        public WeatherCondition getWeatherCondition() {
            return weatherCondition;
        }
    }

    public static class CloudData {
        private int cloudinessPercentage;

        public CloudData() {
        }

        public int getCloudinessPercentage() {
            return cloudinessPercentage;
        }

        public void setCloudinessPercentage(int cloudinessPercentage) {
            this.cloudinessPercentage = cloudinessPercentage;
        }

    }

    public static class WindData {
        private double windSpeed;
        private int windDirection;
        private double windGust;

        public WindData() {
        }

        public WindData(double windSpeed, int windDirection, double windGust) {
            this.windSpeed = windSpeed;
            this.windDirection = windDirection;
            this.windGust = windGust;
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
    }

    public static class PrecipitationData {
        private double rainVolumeLastHour;
        private double snowVolumeLastHour;

        public PrecipitationData() {
        }

        public PrecipitationData(double rainVolumeLastHour, double snowVolumeLastHour) {
            this.rainVolumeLastHour = rainVolumeLastHour;
            this.snowVolumeLastHour = snowVolumeLastHour;
        }

        public double getRainVolumeLastHour() {
            return rainVolumeLastHour;
        }

        public void setRainVolumeLastHour(double rainVolumeLastHour) {
            this.rainVolumeLastHour = rainVolumeLastHour;
        }

        public double getSnowVolumeLastHour() {
            return snowVolumeLastHour;
        }

        public void setSnowVolumeLastHour(double snowVolumeLastHour) {
            this.snowVolumeLastHour = snowVolumeLastHour;
        }

    }

    public static class VisibilityData {
        private int averageVisibility;

        public VisibilityData() {
        }

        public VisibilityData(int averageVisibility) {
            this.averageVisibility = averageVisibility;
        }

        public int getAverageVisibility() {
            return averageVisibility;
        }

        public void setAverageVisibility(int averageVisibility) {
            this.averageVisibility = averageVisibility;
        }

    }

    public static class SystemData {
        private String partOfDay;

        public SystemData() {
        }

        public SystemData(String partOfDay) {
            this.partOfDay = partOfDay;
        }

        public String getPartOfDay() {
            return partOfDay;
        }

        public void setPartOfDay(String partOfDay) {
            this.partOfDay = partOfDay;
        }

    }
}
