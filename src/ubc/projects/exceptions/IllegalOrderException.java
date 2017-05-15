package ubc.projects.exceptions;

/**
 * Created by greggzik on 2017-05-14.
 * Occurs when an Illegal Order is Set.
 */
public class IllegalOrderException extends Exception{

    public IllegalOrderException(String message) {
        super(message);
    }

}
