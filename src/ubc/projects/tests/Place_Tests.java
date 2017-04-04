package ubc.projects.tests;

import ubc.projects.model.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by greggzik on 2017-04-04.
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
    public void testAdjacentAddsNormal() {
        List<Place> temp = new ArrayList<Place>();
        temp.add(testSea);
        temp.add(testLand);

        try {
            testCapital.addAdjacents(temp);

            // Tests to see if places were actually added
            assertTrue(testCapital.isAdjacentTo(testLand));
            assertTrue(testCapital.isAdjacentTo(testSea));
            assertEquals(testCapital.numberOfAdjacents(), 2);

            assertTrue(testLand.isAdjacentTo(testCapital));
            assertEquals(testLand.numberOfAdjacents(), 1);
            assertTrue(testSea.isAdjacentTo(testCapital));
            assertEquals(testSea.numberOfAdjacents(), 1);

            // Tests to see if places are not duplicated
            testCapital.addAdjacents(temp);
            assertEquals(testCapital.numberOfAdjacents(), 2);

        } catch (RuntimeException e) {  // Occurs in infinite mutual recursion addition
            e.printStackTrace();
            fail();
        }
    }

    //TODO: Test Landlocked adding water
}
