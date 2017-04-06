package ubc.projects.tests;

import org.junit.Before;
import org.junit.Test;
import ubc.projects.model.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by greggzik on 2017-04-05.
 * Tests the functionality and correctness of the board.
 */
public class Board_Tests {
    Board board;

    @Before
    public void setUp() {
        board = Board.getInstance();
    }

    /**
     * Determines if the board's methods are functioning properly.
     */
    @Test
    public void testFunctionality() {
        assertFalse(board.containsPlace("fake"));
        assertTrue(board.containsPlace("spa"));
        assertEquals(null, board.findPlace("fake"));

        Place test_CC = new Capital_City("Paris", Country.FRANCE);
        Place test_L  = new Land("Finland", false);
        Place test_S  = new Sea("Black Sea");

        assertEquals(test_CC, board.findPlace("par"));
        assertEquals(test_L, board.findPlace("fin"));
        assertEquals(test_S, board.findPlace("bla"));
    }

    /**
     * Determines if the board is correct according to the abbreviation map in the source files.
     */
    @Test
    public void testCorrectness() {

    }

}
