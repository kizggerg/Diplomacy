package ubc.projects.model;

import ubc.projects.exceptions.PlaceDoesNotExistException;

import java.util.List;

/**
 * Created by greggzik on 2017-04-10.
 * Players are individual players of the game.
 * TODO: Implement and Test
 */
public class Player {
    private final Country country;
    private int numberOfSupplyCentres; // If == 18 then this player wins
    private List<Unit> units;                  // At the end of each year this size must be == numberOfSupplyCentres.

    public Player(Country country) {
        this.country = country;
        initializeCentres();
        }

    /**
     * Adds a army at the given place to the players list of units.
     * @param  str                          The abbreviation of the place to add.
     * @throws PlaceDoesNotExistException   Thrown when the given place does not exist on the board
     */
    public void addArmy(String str) throws PlaceDoesNotExistException {
        Place place = Board.getInstance().findPlace(str);
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place does not exist");
        Unit unit = new Army(place);
        units.add(unit);
    }

    /**
     * Adds a fleet at the given place to the players list of units.
     * @param  str                          The abbreviation of the place to add.
     * @throws PlaceDoesNotExistException   Thrown when the given place does not exist on the board
     */
    public void addFleet(String str) throws PlaceDoesNotExistException {
        Place place = Board.getInstance().findPlace(str);
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place does not exist");
        Unit unit = new Fleet(place);
        units.add(unit);
    }

    /**
     * Creates initial conditions to begin the game by placing all starting units in their correct places.
     * TODO: Complete Method
     */
    private void initializeCentres() {
        numberOfSupplyCentres = 3;

        switch (country) {
            case ENGLAND:

                break;
            case FRANCE:

                break;
            case AUSTRA_HUNGARY:

                break;
            case GERMANY:

                break;
            case ITALY:

                break;
            case TURKEY:

                break;
            case RUSSIA:
                numberOfSupplyCentres = 4;
                break;
        }
    }


}
