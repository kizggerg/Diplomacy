package ubc.projects.model.game;

import ubc.projects.exceptions.IllegalOrderException;
import ubc.projects.model.game.orders.Convoy;
import ubc.projects.model.game.orders.Move;
import ubc.projects.model.game.orders.Support;
import ubc.projects.model.map.Land;
import ubc.projects.model.map.Place;
import ubc.projects.model.map.Sea;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Sets up a convoy order on the Unit
     * @param destination             The desired location for the unit to arrive.
     * @param orderedConvoyShips      The intermittent (ordered from closest to location to closest to destination)
     *                                convoy ships to take the army to its destination.
     * @throws IllegalOrderException  Thrown when destination is a Sea, equal to destination, if the convoyShips do not
     *                                form a valid path to the destination, or if a fleet on land was used.
     */
    public void setToConvoy(Place destination, Fleet... orderedConvoyShips) throws IllegalOrderException {
        if (!(destination instanceof Land)) throw new IllegalOrderException("Army cannot convoy to a Sea");
        if (destination.equals(location)) throw new IllegalOrderException("This is not a convoy, make a hold order instead.");

        Place prev = location;
        Place current;
        List<Sea> route = new ArrayList<>();

        for (int i = 0; i < orderedConvoyShips.length; i++) {
            current = orderedConvoyShips[i].getLocation();

            if (!(current instanceof Sea)) throw new IllegalOrderException("Convoying fleets must be in the Sea");
            if (!current.isAdjacentTo(prev)) throw new IllegalOrderException("Convoy does not form a valid path to destination");
            if (i == orderedConvoyShips.length - 1)
                if (!current.isAdjacentTo(destination))
                    throw new IllegalOrderException("Convoy does not form a valid path to destination");

            route.add((Sea) current);
            prev = current;
        }

        order = new Convoy((Land)destination, this, route);
    }

    @Override
    public String toString() {
        return "Army at " + location.toString();
    }
}
