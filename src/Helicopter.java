public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates.increaseLongitude(10);
                coordinates.increaseHeight(2);
                Logger.log(this + ": This is hot.");
                break;
            case "RAIN":
                coordinates.increaseLongitude(5);
                Logger.log(this + ": Rain is pouring down!");
                break;
            case "FOG":
                coordinates.increaseLongitude(1);
                Logger.log(this + ": Dense fog! I can barely see anything.");
                break;
            case "SNOW":
                coordinates.increaseHeight(-12);
                Logger.log(this + ": My rotor is going to freeze!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            Logger.log(this + ": landing.");
            weatherTower.unregister(this);
        }
    }
}
