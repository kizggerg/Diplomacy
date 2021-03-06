package ubc.projects.model.map;

/**
 * Created by greggzik on 2017-04-04.
 * Capital cities determine a player's influence throughout the game.
 */
public class Capital_City extends Land {
    private Country occupyingCountry; // Could be Null

    public Capital_City(String name, Country occupyingCountry) {
        super(name);
        this.occupyingCountry = occupyingCountry;
    }

    public Capital_City(String name, boolean landlocked, Country occupyingCountry) {
        super(name, landlocked);
        this.occupyingCountry = occupyingCountry;
    }

    public Country getOccupyingCountry() {return occupyingCountry;}

    public void changeOccupation(Country country) {
        occupyingCountry = country;
    }

}
