package ubc.projects.model.game.orders;


import ubc.projects.model.game.Army;
import ubc.projects.model.game.Fleet;
import ubc.projects.model.game.Unit;
import ubc.projects.model.map.Place;

import java.util.*;

/**
 * Created by greggzik on 2017-05-30.
 * Singleton Design Pattern Used.
 */
public class Order_Manager {
    private static Order_Manager instance;
    private Map<Place, Map<Unit, Double>> data;


    private Order_Manager() {
        data = new HashMap<>();
    }

    public static Order_Manager getInstance() {
        if (instance == null) {
            instance = new Order_Manager();
        }

        return instance;
    }

    /**
     * Sorts the orders data from each unit and resolves conflicts.
     * @param units     The units to manage.
     */
    public void manageUnits(Collection<Unit> units) {
        Queue<Unit> holding, moving, convoying, supporting;
        holding = new PriorityQueue<>();
        moving = new PriorityQueue<>();
        convoying = new PriorityQueue<>();
        supporting = new PriorityQueue<>();

        for (Unit unit : units) {
            Order unitOrder = unit.getOrder();

            switch (unitOrder.getType()) {
                case "Move" : {
                    moving.add(unit);
                    break;
                }
                case "Support" : {
                    supporting.add(unit);
                    break;
                }
                case "Convoy" : {
                    convoying.add(unit);
                    break;
                }
                case "Hold" : {
                    holding.add(unit);
                    break;
                }
                default: break;
            }
        }

        for (Unit unit : holding) formatHoldData(unit);
        for (Unit unit : moving) formatMoveData(unit);
        for (Unit unit : convoying) formatHoldData(unit);
        for (Unit unit : supporting) formatSupportData(unit);

        resolveConflicts();
    }

    /**
     * Resolves all conflicts in Orders.
     * TODO: Implement this method.
     */
    private void resolveConflicts() {
        //STUB
    }

    /**
     * Formats the data for Move orders.
     * @param unit  The unit to be represented.
     */
    private void formatMoveData(Unit unit) {
        Place destination = ((Move)unit.getOrder()).getDestination();
        Map<Unit, Double> unitStrength = data.get(destination);

        if (unitStrength == null) {
            unitStrength = new HashMap<>();
            unitStrength.put(unit, 1.0);
            data.put(destination, unitStrength);
        }

        else {
            unitStrength.put(unit, 1.0);
        }
    }

    /**
     * Formats the data for Support Orders.
     * PRECONDITION: All Move, Hold, and Convoy orders have already been formatted.
     * @param unit  The unit to format the support order.
     */
    private void formatSupportData(Unit unit) {
        formatHoldData(unit);
        supportUnit(unit, ((Support)unit.getOrder()).getUnitToSupport());
    }

    /**
     * Formats the data for Convoying Orders.
     * ASSUMES: Only one convoying fleet in route. TODO: Make more robust
     * @param unit  The unit to format the convoy order.
     */
    private void formatConvoyData(Unit unit) {
        Convoy unitOrder = (Convoy)unit.getOrder();

        if (unit instanceof Army) {
            formatMoveData(unit);
        }

        else if (unit instanceof Fleet) { //Given assumption of only one convoying fleet.
            if (unit.getLocation().isAdjacentTo(unitOrder.getUnitToConvoy().getLocation()) &&
                    unit.getLocation().isAdjacentTo(unitOrder.getDestination())) {
                formatHoldData(unit);
            }
        }
    }

    /**
     * Formats the data for Hold Orders
     * @param unit  The unit to format the hold order.
     */
    private void formatHoldData(Unit unit) {
        Place location = unit.getLocation();
        Map<Unit, Double> unitStrength =  data.get(location);

        if (unitStrength == null) {
            unitStrength = new HashMap<>();
            unitStrength.put(unit, 1.5);
            data.put(location, unitStrength);
        }
        else {
            unitStrength.put(unit, 1.5);
        }
    }

    /**
     * Helper method used to increase strength to the unit to support.
     * @param supportingUnit    The unit providing the support
     * @param unitToSupport     The unit whose strength is to be increased by 1.
     */
    private void supportUnit(Unit supportingUnit, Unit unitToSupport) {
        Place supportingDestination = ((Support)supportingUnit.getOrder()).getDestination();
        Place intendedDestination = ((Move)unitToSupport.getOrder()).getDestination();

        if (supportingDestination.equals(intendedDestination)){
            Map<Unit, Double> unitStrength = data.get(intendedDestination);
            Double currentStrength = unitStrength.get(unitToSupport);
            unitStrength.put(unitToSupport, currentStrength + 1.0);

        }
    }





}
