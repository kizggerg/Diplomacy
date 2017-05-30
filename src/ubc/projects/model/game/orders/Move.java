package ubc.projects.model.game.orders;

import ubc.projects.model.map.Place;

/**
 * Created by greggzik on 2017-05-14.
 * Represents a unit moving to another location.
 */
public class Move implements Order {
    private Place destination;

    public Move(Place destination) {
        super();
        this.destination = destination;
    }

    public Place getDestination() {return destination;}

    @Override
    public String getType() {
        return "Move";
    }

    @Override
    public String toString() {
        return "Move to " + destination.toString();
    }
}
