//TODO: Refactor addAdjacents to account for landlocked adding water.

package ubc.projects.model;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by greggzik on 2017-04-04.
 * The abstract class representing a place on the board
 */
public abstract class Place {
    protected String name;                       // The name of the place on the board
    protected Collection<Place> adjacentPlaces;  // The accessible places adjacent to this place
    protected boolean occupied;                  // Whether or not a player is currently occupying the space

    Place (String name) {
        this.name = name;
        occupied = false;
        adjacentPlaces = new ArrayList<Place>();
    }

    public void occupy() {
        occupied = true;
    }

    public void unoccupy() {
        occupied = false;
    }

    private void addAdjacent(Place adjacent) {
        adjacentPlaces.add(adjacent);
    }

    /**
     * Adds this as adjacent to all place in the list and visa versa.
     * Invariant: adjacentPlaces must not have duplicates.
     * @param adjacents   The list of properties adjacent to this.
     */
    public void addAdjacents(Collection<Place> adjacents) {
        for (Place adjacent : adjacents) {
            if (!adjacentPlaces.contains(adjacent)) {
                adjacentPlaces.add(adjacent);
                adjacent.addAdjacent(this);
            }
        }
    }

    /**
     * Returns whether this place is adjacent to the given place
     * @param adjacent   The place whose adjacency is questions
     * @return           True if place is adjacent.
     */
    public boolean isAdjacentTo(Place adjacent) {
        return adjacentPlaces.contains(adjacent);
    }

    /**
     * Returns the number of adjacent places surrounding this place
     * @return   Number of adjacents
     */
    public int numberOfAdjacents() {
        return adjacentPlaces.size();
    }

    @Override
    /**
     * Two places are equal if they have the same name.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;

        Place place = (Place) o;

        return name.equals(place.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}