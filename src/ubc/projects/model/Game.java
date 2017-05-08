package ubc.projects.model;

/**
 * Created by greggzik on 2017-05-07.
 * The Diplomacy Board Game
 * Singleton Design Pattern Used
 * TODO: Implement and Test
 */
public class Game {
    private static Game instance;
    private Board board;

    private Game() {
       board = Board.getInstance();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }
}
