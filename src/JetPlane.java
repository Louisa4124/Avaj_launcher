class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); // calls the superclass of jetplane (aircraft)
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                latitude += 10;
                height += 2;
                if (height > 100)
                    height = 100;
                break;
            case "RAIN":
                latitude += 5;
                break;
            case "FOG":
                latitude += 1;
                break;
            case "SNOW":
                height -= 7;
                if (height < 0)
                    height = 0;
                break;
        }
    }
}
