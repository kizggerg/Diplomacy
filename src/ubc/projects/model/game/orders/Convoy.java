package ubc.projects.model.game.orders;

import ubc.projects.model.game.Army;
import ubc.projects.model.map.Land;
import ubc.projects.model.map.Place;
import ubc.projects.model.map.Sea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greggzik on 2017-05-14.
 */
public class Convoy implements Order {
    private Land destination;
    private Army unitToConvoy;
    private List<Sea> route;

    public Convoy(Land destination, Army unitToConvy, List<Sea> route) {
        this.destination = destination;
        this.unitToConvoy = unitToConvy;
        this.route = route;
    }

    public Convoy(Land destination, Army unitToConvoy, Sea route){
        this.destination = destination;
        this.unitToConvoy = unitToConvoy;
        this.route = new ArrayList<>();
        this.route.add(route);
    }

    public Convoy(Land destination, Army unitToConvy) {
        this.destination = destination;
        this.unitToConvoy = unitToConvy;
        route = null;
    }

    public Army getUnitToConvoy() {return unitToConvoy;}

    public Place getDestination() {return destination;}

    @Override
    public String getType() {
        return "Convoy";
    }

    @Override
    public String toString() {
        return "Convoying to " + destination.toString();
    }
}
