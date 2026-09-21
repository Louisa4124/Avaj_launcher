public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void increaseLongitude(int value) { longitude += value; }

    public void increaseLatitude(int value) { latitude += value; }

    public void increaseHeight(int value) {
        height += value;
        if (height > 100)
            height = 100;
    }
}
