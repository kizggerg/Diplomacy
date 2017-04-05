package ubc.projects.tests;

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

    @Before
    public void setUp() {
        testCapital = new Capital_City("a", false, Country.ENGLAND);
        testLand = new Land("b", true);
        testSea = new Sea("c");
    }

    @Test
    /**
     * Tests the functionality of addAdjacents in normal circumstances
     */
    public void testAdjacentAddsNormal() {
        List<Place> temp = new ArrayList<Place>();
        temp.add(testSea);
        temp.add(testLand);

        try {
            testCapital.addAdjacents(temp);

            // Tests to see if places were actually added
            assertTrue(testCapital.isAdjacentTo(testLand));
            assertTrue(testCapital.isAdjacentTo(testSea));
            assertEquals(2, testCapital.numberOfAdjacents());

            assertTrue(testLand.isAdjacentTo(testCapital));
            assertEquals(1,testLand.numberOfAdjacents());
            //assertTrue(testSea.isAdjacentTo(testCapital));
            //assertEquals(1, testSea.numberOfAdjacents());

            // Tests to see if places are not duplicated
            testCapital.addAdjacents(temp);
            assertEquals(2, testCapital.numberOfAdjacents());

        } catch (StackOverflowError e) {  // Occurs in infinite mutual recursion addition
            e.printStackTrace();
            fail();
        }
    }

    @Test
    /**
     * Tests addAdjacents when adding a Sea place to be adjacent to a landlocked place and visa versa
     */
    public void testAdjacentToWater() {
        List<Place> temp = new ArrayList<Place>();
        temp.add(testSea);
        temp.add(testCapital);

        testLand.addAdjacents(temp);
        assertEquals(1, testLand.numberOfAdjacents());
        assertFalse(testLand.isAdjacentTo(testSea));
        assertFalse(testSea.isAdjacentTo(testLand));

        testSea.addAdjacent(testLand);
        assertFalse(testSea.isAdjacentTo(testLand));
        assertFalse(testLand.isAdjacentTo(testSea));
        assertEquals(0, testSea.numberOfAdjacents());

    }
}
