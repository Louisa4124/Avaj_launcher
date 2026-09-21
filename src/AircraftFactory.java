// Singleton

public class AircraftFactory {

    private static AircraftFactory instance;
    private static long id = 1;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        id++;

        switch (p_type) {
            case "Baloon" -> {
                return new Baloon(id, p_name, p_coordinates);
            }
            case "JetPlane" -> {
                return new JetPlane(id, p_name, p_coordinates);
            }
            case "Helicopter" -> {
                return new Helicopter(id, p_name, p_coordinates);
            }
            default -> {
                throw new UnsupportedOperationException("Aircraft type does not exist: " + p_type);
            }
        }
    }
}
