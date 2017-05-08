package ubc.projects.model;

import ubc.projects.exceptions.PlaceDoesNotExistException;

import java.util.List;

/**
 * Created by greggzik on 2017-04-10.
 * Players are individual players of the game.
 * TODO: Test
 */
public class Player {
    private final Country country;
    private int numberOfSupplyCentres;  // If == 18 then this player wins
    private List<Unit> units;           // At the end of each year this size must be == numberOfSupplyCentres.

    public Player(Country country) {
        this.country = country;
        initializeCentres();
        }

    /**
     * Adds a army at the given place to the players list of units.
     * @param  name                         The abbreviation of the place to add.
     * @throws PlaceDoesNotExistException   Thrown when the given place does not exist on the board
     */
    public void addArmy(String name) throws PlaceDoesNotExistException {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place does not exist");
        Unit unit = new Army(place);
        units.add(unit);
    }

    /**
     * Adds a fleet at the given place to the players list of units.
     * @param  name                         The abbreviation of the place to add.
     * @throws PlaceDoesNotExistException   Thrown when the given place does not exist on the board
     */
    public void addFleet(String name) throws PlaceDoesNotExistException {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place does not exist");
        Unit unit = new Fleet(place);
        units.add(unit);
    }

    /**
     * Adds a fleet at the given place to the players list of units.
     * @param  name                         The abbreviation of the place to add.
     * @param  coast                        The coast of the place to add (SC or OC)
     * @throws PlaceDoesNotExistException   Thrown when the given place does not exist on the board
     */
    public void addFleet(String name, String coast) throws PlaceDoesNotExistException {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place does not exist");
        Unit unit = new Fleet(place, coast);
        units.add(unit);
    }

    /**
     * Creates initial conditions to begin the game by placing all starting units in their correct places
     */
    private void initializeCentres() {
        numberOfSupplyCentres = 3;

        try {
            switch (country) {
                case ENGLAND:
                    addArmy("lvp");
                    addFleet("lon");
                    addFleet("edi");
                    break;
                case FRANCE:
                    addArmy("par");
                    addArmy("mar");
                    addFleet("bre");
                    break;
                case AUSTRA_HUNGARY:
                    addArmy("vie");
                    addArmy("bud");
                    addFleet("tri");
                    break;
                case GERMANY:
                    addArmy("ber");
                    addArmy("mun");
                    addFleet("kie");
                    break;
                case ITALY:
                    addArmy("ven");
                    addArmy("rom");
                    addFleet("nap");
                    break;
                case TURKEY:
                    addArmy("con");
                    addArmy("smy");
                    addFleet("ank");
                    break;
                case RUSSIA:
                    numberOfSupplyCentres = 4;
                    addArmy("mos");
                    addArmy("war");
                    addFleet("sev");
                    addFleet("stp");
                    break;
            }
        }
        catch (PlaceDoesNotExistException e) {
            throw new UnsupportedOperationException("Initialization Failed");
        }
    }


}
