package ubc.projects.model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * Created by greggzik on 2017-04-28.
 * Exceptional Capital Cities are non-landlocked Capital Cities with a divided coastline.
 */
public class Exceptional_Capital_City extends Capital_City {
    private Place southCoast, otherCoast;

    public Exceptional_Capital_City(String name, Country occupyingCountry) {
        super(name, occupyingCountry);
        southCoast = new Land(name + " SC", false);
        otherCoast = new Land(name + " OC", false);
    }

    public Place getSouthCoast() {
        return southCoast;
    }

    public Place getOtherCoast() {
        return otherCoast;
    }

    /**
     * Adds the adjacent places to the south coast and to the full city.
     * @param adjacents    The places to add.
     */
    public void addAdjacentsSouthCoast(Place... adjacents) {
        for (Place adjacent : adjacents) {
            addAdjacent(adjacent);
            southCoast.addAdjacent(adjacent);
        }
    }

    /**
     * Adds the adjacent places to the other coast and to the full city.
     * @param adjacents    The places to add.
     */
    public void addAdjacentsOtherCoast(Place... adjacents) {
        for (Place adjacent : adjacents) {
            addAdjacent(adjacent);
            otherCoast.addAdjacent(adjacent);
        }
    }

}
