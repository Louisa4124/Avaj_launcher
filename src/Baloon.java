class Baloon extends Aircraft{

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates.increaseLongitude(2);
                coordinates.increaseHeight(4);
                Logger.log(this + ": Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates.increaseHeight(-5);
                Logger.log(this + ": Damn you rain! You messed up my balloon.");
                break;
            case "FOG":
                coordinates.increaseHeight(-3);
                Logger.log(this + ": Visibility: zero. Confidence: also zero.");
                break;
            case "SNOW":
                coordinates.increaseHeight(-15);
                Logger.log(this + ": Great. Now we're a flying snowman.");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            Logger.log(this + ": landing.");
            weatherTower.unregister(this);
        }
    }
}
