package ubc.projects.model.game;

import ubc.projects.exceptions.IllegalOrderException;
import ubc.projects.model.game.orders.Move;
import ubc.projects.model.game.orders.Support;
import ubc.projects.model.map.Place;
import ubc.projects.model.map.Sea;

/**
 * Created by greggzik on 2017-04-10.
 * An army of some player
 */
public class Army extends Unit {

    public Army(Place location) {
        super(location);
    }

    /**
     * Sets a move order in play if is has valid construction.
     * @param destination              The desired location to move the unit.
     * @throws IllegalOrderException   Thrown when destination is a Sea, not adjacent to location, or is equal to location.
     */
    public void setToMove(Place destination) throws IllegalOrderException {
        if (destination instanceof Sea) throw new IllegalOrderException("Cannot move Army to Sea");
        if (destination.equals(location)) throw new IllegalOrderException("This is not a move, make a hold order instead.");
        if (!location.isAdjacentTo(destination)) throw new IllegalOrderException("Destination is not Adjacent to Current Location.");
        order = new Move(destination);
    }

    /**
     * Sets up a support order on the Unit
     * @param destination             The location to support.
     * @param unit                    The unit whose order is being supported.
     * @throws IllegalOrderException  Thrown when destination is a Sea, not adjacent to location, or is equal to location.
     */
    public void setToSupport(Place destination, Unit unit) throws IllegalOrderException {
        if (destination instanceof Sea) throw new IllegalOrderException("Army cannot support orders from the Sea");
        if (destination.equals(location)) throw new IllegalOrderException("This is not a support, make a hold order instead.");
        if (!location.isAdjacentTo(destination)) throw new IllegalOrderException("Supporting Destination is not Adjacent to Current Location.");
        order = new Support(destination, unit);
    }

}
