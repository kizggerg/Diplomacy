package ubc.projects.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ubc.projects.model.*;

import java.beans.VetoableChangeListener;

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
        testIndividualPlace("nat", "North Atlantic Sea", Sea.class, false,
                null, 5, "mid", "iri", "lpl", "cly", "nrg");
        testIndividualPlace("nrg", "Norwegian Sea", Sea.class, false,
                null, 6, "nat", "cly", "edi", "nth", "nwy", "bar");
        testIndividualPlace("bar", "Barents Sea", Sea.class, false,
                null, 3, "nrg", "nwy", "stp");
        testIndividualPlace("mid", "Mid Atlantic Sea", Sea.class, false,
                null, 9, "nat", "iri", "eng", "bre", "gas",
                "spa", "por", "naf", "wes");
        testIndividualPlace("iri", "Irish Sea", Sea.class, false,
                null, 5, "nat", "mid", "eng", "wal", "lpl");
        testIndividualPlace("eng", "English Channel", Sea.class, false,
                null, 8, "iri", "mid", "bre", "pic", "bel",
                "nth", "lon", "wal");
        testIndividualPlace("nth", "North Sea", Sea.class, false,
                null, 11, "nrg", "edi", "yor", "lon", "eng", "bel",
                "hol", "hel", "den", "ska","nwy");
        testIndividualPlace("hel", "Helgoland Bight", Sea.class, false,
                null, 4, "nth", "hol", "kie", "den");
        testIndividualPlace("ska", "Skagerrak Strait", Sea.class, false,
                null, 5, "nth", "den", "bal", "swe", "nwy");
        testIndividualPlace("bal", "Baltic Sea", Sea.class, false,
                null, 8, "ska", "den", "kie", "ber", "pru", "lvn",
                "bot", "swe");
        testIndividualPlace("bot", "Gulf of Bothnia", Sea.class, false,
                null, 5, "swe", "bal", "lvn", "stp", "fin");

        // TODO: Still need to test all other seas and lands.
    }

    /**
     * Tests to determine if a particular place on the board has the correct parameters and correct adjacent places.
     * @param place              The abbreviation of the place to test.
     * @param expectedName       The expected full name of the place to test.
     * @param expectedClass      The expected class of the place to test.
     * @param isLandlocked       The expected landlocked parameter if the place is Land.
     * @param expectedCountry    The expected country parameter if the place is a Capital City
     * @param numOfAdjacents     The expected number of adjacent places.
     * @param expectedAdjacents  The abbreviations of all the expected adjacent places.
     */
    private void testIndividualPlace(String place, String expectedName, Class expectedClass, boolean isLandlocked,
                                     Country expectedCountry,  int numOfAdjacents, String... expectedAdjacents) {
        Place testPlace = board.findPlace(place);
        assertFalse(testPlace == null);
        testPlaceCorrectness(testPlace, expectedName, expectedClass, isLandlocked, expectedCountry);
        assertEquals(numOfAdjacents, testPlace.numberOfAdjacents());

        for (String adjacent : expectedAdjacents) {
            assertTrue(testPlace.isAdjacentTo(board.findPlace(adjacent)));
        }
    }

    /**
     * Determines if a place's parameters were entered correctly upon instantiation.
     * @param place            The test place whose parameters are to be verified.
     * @param expectedName     The full name of place test place.
     * @param expectedClass    The class of the place.
     * @param isLandlocked     If the place is land, the landlocked situation of the place.
     * @param expectedCountry  If the place is a capital city, the expected occupying country.
     */
    private void testPlaceCorrectness(Place place, String expectedName, Class expectedClass, boolean isLandlocked, Country expectedCountry) {
        assertEquals(expectedName, place.getName());
        assertEquals(expectedClass, place.getClass());

        if (place instanceof Land) {
            assertEquals(isLandlocked, ((Land) place).isLandlocked());
            if (place instanceof Capital_City) {
                assertEquals(expectedCountry, ((Capital_City) place).getOccupyingCountry());
            }
        }
    }

}
