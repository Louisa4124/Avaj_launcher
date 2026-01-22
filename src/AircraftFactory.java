// Singleton

public final class AircraftFactory Singleton {

    private static AircraftFactory INSTANCE;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AircraftFactory();
        }
        return INSTANCE;
    }

    public Flyable* newAircraft(String p_type, String p_name, Coordinates p_coordinates) {

    }
}
