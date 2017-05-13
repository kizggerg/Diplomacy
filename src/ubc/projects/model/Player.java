package ubc.projects.model;

import org.junit.Before;
import ubc.projects.exceptions.PlaceDoesNotExistException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by greggzik on 2017-04-10.
 * Players are individual players of the game.
 * TODO: Test Basic Functionality
 */
public class Player {
    private final Country country;
    private int numberOfSupplyCentres;  // If == 18 then this player wins
    private List<Unit> units;           // At the end of each year this size must be == numberOfSupplyCentres.

    public Player(Country country) {
        this.country = country;
        units = new ArrayList<>();
        initializeCentres();
    }

     public Country getCountry() {
        return country;
     }

    /**
     * Adds a army at the given place to the players list of units.
     * @param  name                         The abbreviation of the place to add.
     * @throws PlaceDoesNotExistException   Thrown when the given place does not exist on the board
     */
    public void addArmy(String name) throws PlaceDoesNotExistException {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place " + name + " does not exist");
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
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place " + name + " does not exist");
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
        if (place == null) throw new PlaceDoesNotExistException("Cannot add unit: Place " + name + " does not exist");
        Unit unit = new Fleet(place, coast);
        units.add(unit);
    }

    /**
     * Returns an unmodifiable list of units.
     * @return    A list of units
     */
    public List<Unit> getUnits() {
        return Collections.unmodifiableList(units);
    }

    /**
     * Returns true if the place corresponding to the given name is occupied by this player.
     * @param name     The abbreviated name of the place.
     * @return         True if this player occupies the place, false otherwise.
     */
    public boolean occupies(String name) {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) return false;
        if (!place.isOccupied()) return false;

        for (Unit unit : units) {
            if (unit.getLocation().equals(place)) return true;
        }

        return false;
    }

    /**
     * Returns true if the place corresponding to the given name is occupied by this player with an army.
     * @param name     The abbreviated name of the place.
     * @return         True if this player occupies the place with an army, false otherwise.
     */
    public boolean occupiesWithArmy(String name) {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) return false;
        if (!place.isOccupied()) return false;

        for (Unit unit : units) {
            if (unit instanceof Army && unit.getLocation().equals(place)) return true;
        }

        return false;
    }

    /**
     * Returns true if the place corresponding to the given name is occupied by this player with a fleet.
     * @param name     The abbreviated name of the place.
     * @return         True if this player occupies the place with a fleet, false otherwise.
     */
    public boolean occupiesWithFleet(String name) {
        Place place = Board.getInstance().findPlace(name);
        if (place == null) return false;
        if (!place.isOccupied()) return false;

        if (place instanceof Exceptional_Capital_City) {
            Place south = ((Exceptional_Capital_City) place).getSouthCoast();
            Place other = ((Exceptional_Capital_City) place).getOtherCoast();

            for (Unit unit : units) {
                if (unit instanceof Fleet && (unit.getLocation().equals(south) || unit.getLocation().equals(other)))
                    return true;
            }

            return false;
        }
        else {
            for (Unit unit : units) {
                if (unit instanceof Fleet && unit.getLocation().equals(place)) return true;
            }

            return false;
        }
    }

    /**
     * Creates initial conditions to begin the game by placing all starting units in their correct places
     */
    private void initializeCentres() {
        numberOfSupplyCentres = 3;

        try {
            switch (country) {
                case ENGLAND:
                    addArmy("lpl");
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
                    addFleet("stp", "SC");
                    break;
                default: break;
            }
        }
        catch (PlaceDoesNotExistException e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }

    /**
     * Two players are equal if they control the same country.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        return country == player.country;
    }

    @Override
    public int hashCode() {
        return country.hashCode();
    }
}
