package ubc.projects.model.game.orders;

import ubc.projects.model.game.Unit;
import ubc.projects.model.map.Place;

/**
 * Created by greggzik on 2017-05-14.
 * Represents a Unit supporting a unit.
 */
public class Support implements Order {
    Place destination;
    Unit unitToSupport;

    public Support(Place destination, Unit unitToSupport) {
        this.destination = destination;
        this.unitToSupport = unitToSupport;
    }
}