class Balloon extends Aircraft{

    public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();

        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                longitude += 2;
                height += 4;
                if (height > 100)
                    height = 100;
                break;
            case "RAIN":
                height -= 5;
                if (height < 0)
                    height = 0;
                break;
            case "FOG":
                height -= 3;
                if (height < 0)
                    height = 0;
                break;
            case "SNOW":
                height -= 15;
                if (height < 0)
                    height = 0;
                break;
        }
    }
}
