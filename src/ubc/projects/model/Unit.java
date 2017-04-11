package ubc.projects.model;

/**
 * Created by greggzik on 2017-04-10.
 * The Fleet or Army of an individual player
 * TODO: Implement and Test
 */
public abstract class Unit {
    private Place location;

    public Unit(Place location) {
        this.location = location;
    }
}
