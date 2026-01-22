// Singleton

public final class WeatherProvider Singleton{

    private static WeatherProvider INSTANCE;
    private WeatherProvider() {}
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getProvider() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherProvider();
        }
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[(int) (Math.random() * weather.length)];
    }
}
