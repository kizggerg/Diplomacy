package ubc.projects.model.game;

import ubc.projects.exceptions.IllegalOrderException;
import ubc.projects.model.game.orders.Hold;
import ubc.projects.model.game.orders.Order;
import ubc.projects.model.map.Place;

/**
 * Created by greggzik on 2017-04-10.
 * The Fleet or Army of an individual player
 */
public abstract class Unit {
    protected Place location;
    protected Order order;   // Could be null

    public Unit(Place location) {
        this.location = location;
        location.occupy();
        order = null;
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    /**
     * Sets up a hold order on the unit.
     */
    public void setToHold() {
        order = new Hold();
    }

    /**
     * Sets up a move order on the Unit.
     * @param destination            The desired location to move to.
     * @throws IllegalOrderException Thrown when the order is ill-formed.
     */
    public abstract void setToMove(Place destination) throws IllegalOrderException;

    /** TODO: Implement Methods
     * Sets up a support order on the Unit.
     * @param destination             The location to support.
     * @param unit                    The unit whose order is being supported.
     * @throws IllegalOrderException  Thrown when the order is ill-formed.
     */
    //public abstract void setToSupport(Place destination, Unit unit) throws IllegalOrderException;
}
