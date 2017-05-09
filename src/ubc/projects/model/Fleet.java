package ubc.projects.model;

import ubc.projects.exceptions.PlaceDoesNotExistException;

/**
 * Created by greggzik on 2017-04-10.
 * A fleet of some player
 * TODO: Test Basic Functionality, Implement Move and Retreat Functionality.
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
}
