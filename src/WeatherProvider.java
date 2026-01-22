// Singleton

public class WeatherProvider Singleton {

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[(int) (Math.random() * weather.length)];
    }
}
