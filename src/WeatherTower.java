public final class WeatherTower extends Tower {

    private static WeatherTower INSTANCE;
    private WeatherTower() {}

    public static WeatherTower getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherTower();
        }
        return INSTANCE;
    }

    public String getWeather(Coordinates p_coordinates) {

    }

    public void changeWeather() {
        
    }
}
