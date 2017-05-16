package ubc.projects.model.game;

import ubc.projects.exceptions.IllegalOrderException;
import ubc.projects.exceptions.PlaceDoesNotExistException;
import ubc.projects.model.game.orders.Convoy;
import ubc.projects.model.game.orders.Move;
import ubc.projects.model.game.orders.Support;
import ubc.projects.model.map.Exceptional_Capital_City;
import ubc.projects.model.map.Land;
import ubc.projects.model.map.Place;
import ubc.projects.model.map.Sea;

/**
 * Created by greggzik on 2017-04-10.
 * A fleet of some player
 */
public class Fleet extends Unit {

    public Fleet(Place location) {
        super(location);
    }

    public Fleet(Place location, String coast) {
        super(location);

        if (location instanceof Exceptional_Capital_City) {
            try {
                Exceptional_Capital_City theLocation = (Exceptional_Capital_City) location;
                addToCoast(theLocation, coast);
            }
            catch (PlaceDoesNotExistException e) {
                System.out.println(e.toString());
                System.exit(1);
            }
        }
    }

    /**
     * Represents the additional information of a coast to the exceptional capital city.
     * @param location                       The exceptional capital city to occupy.
     * @param coast                          "SC" or "OC" defining the particular coastline to occupy.
     * @throws PlaceDoesNotExistException    Thrown when the coast is neither "SC" nor "OC".
     */
    private void addToCoast(Exceptional_Capital_City location, String coast) throws PlaceDoesNotExistException {
        if (coast.toLowerCase().trim().equals("sc")) {
            setLocation(location.getSouthCoast());
        }
        else if (coast.toLowerCase().trim().equals("oc")) {
            setLocation(location.getOtherCoast());
        }
        else throw new PlaceDoesNotExistException("Coast does not exist");
    }

    /**
     * Sets a move order in play if is has valid construction.
     * @param destination            The desired location to move to.
     * @throws IllegalOrderException Thrown when destination is landlocked, an exceptional capital city without a specified coast,
     *                                      is equal to current location, or is non-adjacent to current location.
     */
    public void setToMove(Place destination) throws IllegalOrderException {
        if (destination instanceof Land) {
            if (((Land) destination).isLandlocked()) throw new IllegalOrderException("Cannot move Fleet to Landlocked Land");
            if (destination instanceof Exceptional_Capital_City) throw new  IllegalOrderException("Must specific the Coast to Move");
        }
        if (destination.equals(location)) throw new IllegalOrderException("This is not a move, make a hold order instead.");
        if (!location.isAdjacentTo(destination)) throw new IllegalOrderException("Destination is not Adjacent to Current Location.");
        order = new Move(destination);
    }

    /**
     * Sets up a support order on the Unit
     * @param destination             The location to support.
     * @param unit                    The unit whose order is being supported.
     * @throws IllegalOrderException  Thrown when destination is landlocked, equal to current location, or non-adjacent
     *                                       to current location.
     */
    public void setToSupport(Place destination, Unit unit) throws IllegalOrderException {
        if (destination instanceof Land) {
            if (((Land) destination).isLandlocked()) throw new IllegalOrderException("Fleets cannot Support a Landlocked Destination");
        }
        if (destination.equals(location)) throw new IllegalOrderException("This is not a support, make a hold order instead.");
        if (!location.isAdjacentTo(destination)) throw new IllegalOrderException("Destination is not Adjacent to Current Location.");
        order = new Support(destination, unit);
    }

    /**
     * Sets up a convoy order on the Unit
     * @param destination             The place where the army ought to end up.
     * @param unitToConvoy            The army to convoy
     * @throws IllegalOrderException  Thrown when destination is not Land, or if this location is not a Sea.
     */
    public void setToConvoy(Place destination, Army unitToConvoy) throws IllegalOrderException {
        if (!(location instanceof Sea)) throw new IllegalOrderException("Only fleets on the Sea can Convoy");
        if (!(destination instanceof Land)) throw new IllegalOrderException("Cannot convoy Army to Sea");
        order = new Convoy((Land) destination, unitToConvoy);
    }
}
