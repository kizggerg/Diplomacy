package ubc.projects.tests;

import ubc.projects.exceptions.PlaceDoesNotExistException;
import ubc.projects.model.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by greggzik on 2017-04-04.
 * Tests the functionality of the Place class (and its subsequent children)
 */
public class Place_Tests {
    private Place testCapital;
    private Place testLand;
    private Place testSea;
    private Exceptional_Capital_City testExceptionalCapital;

    @Before
    public void setUp() {
        testCapital = new Capital_City("a", false, Country.ENGLAND);
        testLand = new Land("b", true);
        testSea = new Sea("c");
        testExceptionalCapital = new Exceptional_Capital_City("d", Country.RUSSIA);
    }

    @Test
    /**
     * Tests the functionality of addAdjacents in normal circumstances
     */
    public void testAdjacentAddsNormal() {
        try {
            testCapital.addAdjacents(testSea, testLand, testExceptionalCapital);

            // Tests to see if places were actually added
            assertTrue(testCapital.isAdjacentTo(testLand));
            assertTrue(testCapital.isAdjacentTo(testSea));
            assertTrue(testCapital.isAdjacentTo(testExceptionalCapital));
            assertEquals(3, testCapital.numberOfAdjacents());

            assertTrue(testLand.isAdjacentTo(testCapital));
            assertEquals(1,testLand.numberOfAdjacents());
            assertTrue(testSea.isAdjacentTo(testCapital));
            assertEquals(1, testSea.numberOfAdjacents());
            assertTrue(testExceptionalCapital.isAdjacentTo(testCapital));
            assertEquals(1,testExceptionalCapital.numberOfAdjacents());

            // Tests to see if places are not duplicated
            testCapital.addAdjacents(testSea, testLand, testExceptionalCapital);
            assertEquals(3, testCapital.numberOfAdjacents());

        } catch (StackOverflowError e) {  // Occurs in infinite mutual recursion
            e.printStackTrace();
            fail();
        }
    }

    @Test
    /**
     * Tests addAdjacents when adding a Sea place to be adjacent to a landlocked place and visa versa
     */
    public void testAdjacentToWater() {
        testLand.addAdjacents(testSea, testCapital);
        assertEquals(1, testLand.numberOfAdjacents());
        assertFalse(testLand.isAdjacentTo(testSea));
        assertFalse(testSea.isAdjacentTo(testLand));

        testSea.addAdjacents(testLand);
        assertFalse(testSea.isAdjacentTo(testLand));
        assertFalse(testLand.isAdjacentTo(testSea));
        assertEquals(0, testSea.numberOfAdjacents());
    }

    @Test
    /**
     * Tests the functionality of adding adjacents to exceptional coasts.
     */
    public void testExceptionalCapitalCoasts() {
        testExceptionalCapital.addAdjacentsSouthCoast(testLand, testSea);
        testExceptionalCapital.addAdjacentsOtherCoast(testCapital, testSea);
        assertTrue(testExceptionalCapital.getSouthCoast().isAdjacentTo(testLand));
        assertTrue(testExceptionalCapital.getSouthCoast().isAdjacentTo(testSea));
        assertFalse(testExceptionalCapital.getSouthCoast().isAdjacentTo(testCapital));
        assertEquals(2, testExceptionalCapital.getSouthCoast().numberOfAdjacents());
        assertTrue(testExceptionalCapital.getOtherCoast().isAdjacentTo(testCapital));
        assertTrue(testExceptionalCapital.getOtherCoast().isAdjacentTo(testSea));
        assertFalse(testExceptionalCapital.getOtherCoast().isAdjacentTo(testLand));
        assertEquals(2, testExceptionalCapital.getOtherCoast().numberOfAdjacents());
    }

}
