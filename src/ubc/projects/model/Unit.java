package ubc.projects.model;

/**
 * Created by greggzik on 2017-04-10.
 * The Fleet or Army of an individual player
 * TODO: Test Basic Functionality, Implement Move and Retreat Functionality.
 */
public abstract class Unit {
    private Place location;

    public Unit(Place location) {
        this.location = location;
        location.occupy();
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }
}
