package ubc.projects.model.game.orders;

import ubc.projects.model.map.Place;

/**
 * Created by greggzik on 2017-05-14.
 * Represents a unit moving to another location.
 */
public class Move implements Order {
    Place destination;

    public Move(Place destination) {
        super();
        this.destination = destination;
    }

    @Override
    public String getType() {
        return "Move";
    }
}
