package ubc.projects.model.game.orders;

import ubc.projects.model.map.Land;
import ubc.projects.model.map.Sea;

/**
 * Created by greggzik on 2017-05-14.
 */
public class Convoy implements Order {
    Land destination;
    Sea route;

    public Convoy(Land destination, Sea route) {
        this.destination = destination;
        this.route = route;
    }

}
