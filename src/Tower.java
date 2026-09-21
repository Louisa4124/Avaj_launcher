import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        Logger.log("Tower says: " + flyable.getType() + "#" 
            + flyable.getName() + "(" + flyable.getId() 
            + ") registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Logger.log("Tower says: " + flyable.getType() + "#" 
            + flyable.getName() + "(" + flyable.getId() 
            + ") unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable flyable : new ArrayList<>(observers)) {
            flyable.updateConditions();
        }
    }
}
