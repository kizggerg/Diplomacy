package ubc.projects.model.game.orders;

/**
 * Created by greggzik on 2017-05-14.
 * Represents a unit holding its position.
 */
public class Hold implements Order {

    public Hold() {
        super();
    }

    @Override
    public String getType() {
        return "Hold";
    }
}
