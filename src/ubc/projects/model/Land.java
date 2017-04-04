package ubc.projects.model;

/**
 * Created by greggzik on 2017-04-04.
 * The class representing accessible land on the board
 * Only armies can occupy landlocked land.
 */
public class Land extends Place {
    private boolean landlocked;

    public Land (String name) {
        super(name);
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
}
