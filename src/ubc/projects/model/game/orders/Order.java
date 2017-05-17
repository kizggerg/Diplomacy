package ubc.projects.model.game.orders;

/**
 * Created by greggzik on 2017-05-14.
 * Represent an order a unit can do.
 */
public interface Order {

    /**
     * Return the name of the order type (Move, Support, Hold, or Convoy).
     * @return    The name of the order type.
     */
    public String getType();

}
