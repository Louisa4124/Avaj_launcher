public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                longitude += 10;
                height += 2;
                if (height > 100)
                    height = 100;
                break;
            case "RAIN":
                longitude += 5;
                break;
            case "FOG":
                longitude += 1;
                break;
            case "SNOW":
                height -= 12;
                if (height < 0)
                    height = 0;
                break;
        }
    }
}
