package ubc.projects.model.game.orders;

import ubc.projects.model.game.Unit;
import ubc.projects.model.map.Place;

/**
 * Created by greggzik on 2017-05-14.
 * Represents a Unit supporting a unit.
 */
public class Support implements Order {
    private Place destination;
    private Unit unitToSupport;

    public Support(Place destination, Unit unitToSupport) {
        this.destination = destination;
        this.unitToSupport = unitToSupport;
    }

    public Place getDestination() {return destination;}

    public Unit getUnitToSupport() {return unitToSupport;}

    @Override
    public String getType() {
        return "Support";
    }

    @Override
    public String toString() {
        return "Supporting " + unitToSupport.toString() + " at/going to " + destination.toString();
    }
}
