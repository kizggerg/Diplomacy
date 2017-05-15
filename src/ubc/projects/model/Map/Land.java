package ubc.projects.model.map;

/**
 * Created by greggzik on 2017-04-04.
 * The class representing accessible land on the board
 * Only armies can occupy landlocked land, and only land can be adjacent to landlocked places.
 */
public class Land extends Place {
    private boolean landlocked;

    public Land (String name) {
        super(name); landlocked = false;
    }

    public Land (String name, boolean landlocked) {
        super(name);
        this.landlocked = landlocked;
    }

    public void setToLandlocked() {
        landlocked = true;
    }

    public boolean isLandlocked() {
        return landlocked;
    }

    /**
     * Adds the adjacent place if it isn't already added or if this is landlocked and the adjacent is a Sea
     * @param adjacent    The place to be added as an adjacent place.
     */
    protected void addAdjacent(Place adjacent) {
        if (landlocked && (adjacent instanceof Sea)) return;

        if (!adjacentPlaces.contains(adjacent)) {
            adjacentPlaces.add(adjacent);
            adjacent.addAdjacent(this);
        }
    }
}
