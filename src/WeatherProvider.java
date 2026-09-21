// Singleton

public class WeatherProvider{

    private static WeatherProvider instance;
    private WeatherProvider() {}
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[(int) (Math.random() * weather.length)];
    }
}
