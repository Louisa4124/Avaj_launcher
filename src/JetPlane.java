class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); // calls the superclass of jetplane (aircraft)
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates.increaseLatitude(10);
                coordinates.increaseHeight(2);
                Logger.log(this + ": The sun is shining bright!");
                break;
            case "RAIN":
                coordinates.increaseLatitude(5);
                Logger.log(this + ": It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates.increaseLatitude(1);
                Logger.log(this + ": The fog is getting thicker!");
                break;
            case "SNOW":
                coordinates.increaseHeight(-7);
                Logger.log(this + ": OMG! Winter is coming!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            Logger.log(this + ": landing.");
            weatherTower.unregister(this);
        }
    }
}
