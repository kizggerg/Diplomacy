package ubc.projects.exceptions;

/**
 * Created by greggzik on 2017-04-10.
 * Thrown when a place does not exist on the board.
 * TODO: Test
 */
public class PlaceDoesNotExistException  extends Exception{
    public PlaceDoesNotExistException(String message) {
        super(message);
    }
}
