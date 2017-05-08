package ubc.projects.model;

/**
 * Created by greggzik on 2017-04-04.
 * The class representing an accessible sea (body of water) on the board.
 * Only fleets or convoyed armies can occupy the sea.
 */
public class Sea extends Place {

    public Sea (String name) {
        super(name);
    }

    /**
     * Adds each adjacent place if the place isn't already added or if the adjacent isn't landlocked.
     * @param adjacent   The list of properties adjacent to this.
     */
    protected void addAdjacent(Place adjacent) {
        if (adjacent instanceof Land) {
            Land temp = (Land) adjacent;
            if (temp.isLandlocked()) return;
        }

        if (!(adjacentPlaces.contains(adjacent))) {
            adjacentPlaces.add(adjacent);
            adjacent.addAdjacent(this);
        }
    }

}
