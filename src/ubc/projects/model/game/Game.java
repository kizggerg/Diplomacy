package ubc.projects.model.game;

import ubc.projects.model.map.Board;
import ubc.projects.model.map.Country;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by greggzik on 2017-05-07.
 * The Diplomacy Board Game
 * TODO: Test Basic Functionality
 */
public class Game {
    private Board board;
    private Set<Player> players;
    private int year;
    private Season season;

    public Game() {
       board = Board.getInstance();
       year = 1901;
       season = Season.SPRING;
       initializePlayers();
    }

    /**
     * Initializes the players' initial units on the board.
     */
    public void initializePlayers() {
        Player austria = new Player(Country.AUSTRA_HUNGARY);
        Player england = new Player(Country.ENGLAND);
        Player germany = new Player(Country.GERMANY);
        Player italy = new Player(Country.ITALY);
        Player france = new Player(Country.FRANCE);
        Player turkey = new Player(Country.TURKEY);
        Player russia = new Player(Country.RUSSIA);
        addPlayers(austria, england, germany, italy, france, turkey, russia);
    }

    /**
     * Returns the player who is controlling the given country.
     * @param country     The country that is controlled by the returning player.
     * @return            The player controlling the corresponding country.
     */
    public Player getPlayer(Country country) {
        for (Player player : players) {
            if (player.getCountry() == country) return player;
        }
        throw new IllegalStateException("Player formatting error");
    }

    /**
     * Adds the arbitrary number of players to this.players.
     * @param players    An arbitrary number of players.
     */
    private void addPlayers(Player... players) {
        if (this.players == null) this.players = new HashSet<Player>();
        for (Player player : players) {
            this.players.add(player);
        }
    }

    public String getPhase() {
        return season.toString() + " " + year;
    }

}
