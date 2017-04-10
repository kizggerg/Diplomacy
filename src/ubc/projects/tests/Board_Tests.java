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
        testIndividualPlace("wes", "West Mediterranean Sea", Sea.class, false,
                null, 6, "spa", "mid", "naf", "tun", "tyn", "lyo");
        testIndividualPlace("lyo", "Gulf of Lyon", Sea.class, false,
                null, 6, "wes", "tyn", "tus", "pie", "mar", "spa");
        testIndividualPlace("tyn", "Tyrrhenian Sea", Sea.class, false,
                null, 7, "lyo", "wes", "tun", "ion", "nap", "rom",
                "tus");
        testIndividualPlace("ion", "Ionian Sea", Sea.class, false,
                null, 9, "tun", "tyn", "nap", "app", "adr", "alb",
                "gre", "aeg", "eas");
        testIndividualPlace("adr", "Adriatic Sea", Sea.class, false,
                null, 5, "ion", "app", "ven", "tri", "alb");
        testIndividualPlace("aeg", "Aegean Sea", Sea.class, false,
                null, 6, "ion", "eas", "smy", "con", "bul", "gre");
        testIndividualPlace("eas", "East Mediterranean Sea", Sea.class, false,
                null, 4, "ion", "aeg", "smy", "syr");
        testIndividualPlace("bla", "Black Sea", Sea.class, false,
                null, 6, "con", "bul", "rum", "sev", "arm", "ank");
        testIndividualPlace("naf", "North Africa", Land.class, false,
                null, 3, "mid", "wes", "tun");
        testIndividualPlace("tun", "Tunisia", Capital_City.class, false,
                null, 4, "naf", "wes", "tyn", "ion");
        testIndividualPlace("syr", "Syria", Land.class, false,
                null, 3, "eas", "smy", "arm");
        testIndividualPlace("arm", "Armenia", Land.class, false,
                null, 5, "syr", "smy", "ank", "bla", "sev");
        testIndividualPlace("smy", "Smyrna", Capital_City.class, false,
                Country.TURKEY, 6, "eas", "aeg", "con", "ank", "arm", "syr");
        testIndividualPlace("con", "Constantinople", Capital_City.class, false,
                Country.TURKEY, 5, "bla", "bul", "aeg", "smy", "ank");
        testIndividualPlace("ank", "Ankara", Capital_City.class, false,
                Country.TURKEY, 4, "bla", "arm", "smy", "con");
        testIndividualPlace("sev", "Sevastopol", Capital_City.class, false,
                Country.RUSSIA, 5, "arm", "bla", "rum", "ukr", "mos");
        testIndividualPlace("ukr", "Ukraine", Land.class, true,
                null, 5, "war", "gal", "rum", "sev", "mos");
        testIndividualPlace("war", "Warsaw", Capital_City.class, true,
                Country.RUSSIA, 6, "pru", "sil", "gal", "ukr", "mos", "lvn");
        testIndividualPlace("mos", "Moscow", Capital_City.class, true,
                Country.RUSSIA, 5, "stp", "lvn", "war", "ukr", "sev");
        testIndividualPlace("lvn", "Livonia", Land.class, false,
                null, 6, "stp", "bot", "bal", "pru", "war", "mos");
        testIndividualPlace("stp", "Saint Petersburg", Capital_City.class, false,
                Country.RUSSIA, 6, "bar", "nwy", "fin", "bot", "lvn", "mos");
        testIndividualPlace("fin", "Finland", Land.class, false,
                null, 4, "nwy", "swe", "bot", "stp");
        testIndividualPlace("swe", "Sweden", Capital_City.class, false,
                null, 6, "fin", "nwy", "ska", "den", "bal", "bot");
        testIndividualPlace("nwy", "Norway", Capital_City.class, false,
                null, 7, "bar", "nrg", "nth", "ska", "swe", "fin",
                "stp");
        testIndividualPlace("den", "Denmark", Capital_City.class, false,
                null, 6, "swe", "ska", "nth", "hel", "bal", "kie");
        testIndividualPlace("lon", "London", Capital_City.class, false,
                Country.ENGLAND, 4, "eng", "wal", "yor", "nth");
        testIndividualPlace("wal", "Wales", Land.class, false,
                null, 5, "lpl", "yor", "lon", "eng", "iri");
        testIndividualPlace("lpl", "Liverpool", Capital_City.class, false,
                Country.ENGLAND, 6, "iri", "wal", "yor", "edi", "cly", "nat");
        testIndividualPlace("cly", "Clyde", Land.class, false,
                null, 4, "nat", "nrg", "edi", "lpl");
        testIndividualPlace("edi", "Edinburgh",Capital_City.class, false,
                Country.ENGLAND, 5, "nrg", "cly", "lpl", "yor", "nth");
        testIndividualPlace("yor", "York", Land.class, false,
                null, 5, "edi", "lpl", "wal", "lon", "nth");
        testIndividualPlace("por", "Portugal", Capital_City.class, false,
                null, 2, "spa", "mid");
        testIndividualPlace("spa", "Spain", Capital_City.class, false,
                null, 6, "mid", "wes", "lyo", "mar", "gas", "por");
        testIndividualPlace("mar", "Marseilles", Capital_City.class, false,
                Country.FRANCE, 5, "bur", "gas", "spa", "lyo", "pie");
        testIndividualPlace("gas", "Gascony", Land.class, false,
                null, 6, "mid", "spa", "mar", "bur", "par", "bre");
        testIndividualPlace("bur", "Burgundy", Land.class, true,
                null, 7, "mar", "gas", "par", "pic", "bel", "ruh",
                "mun");
        testIndividualPlace("par", "Paris", Capital_City.class, true,
                Country.FRANCE, 4, "pic", "bre", "gas", "bur");
        testIndividualPlace("bre", "Brest", Capital_City.class, false,
                Country.FRANCE, 5, "eng", "mid", "gas", "par", "pic");
        testIndividualPlace("pic", "Picardy", Land.class, false,
                null, 5, "bre", "par", "bur", "bel", "eng");
        testIndividualPlace("bel", "Belgium", Capital_City.class, false,
                null, 6, "pic", "bur", "ruh", "hol", "nth", "eng");
        testIndividualPlace("hol", "Holland", Capital_City.class, false,
                null, 5, "bel", "ruh", "kie", "hel", "nth");
        testIndividualPlace("ruh", "Ruhr", Land.class, true,
                null, 5, "hol", "bel", "bur", "mun", "kie");
        testIndividualPlace("kie", "Kiel", Capital_City.class, false,
                Country.GERMANY, 7, "hol", "ruh", "mun", "ber", "bal", "den",
                "hel");
        testIndividualPlace("ber", "Berlin", Capital_City.class, false,
                Country.GERMANY, 5, "bal", "kie", "mun", "sil", "pru");
        testIndividualPlace("mun", "Munich", Capital_City.class, true,
                Country.GERMANY, 7, "bur", "ruh", "kie", "ber", "sil", "boh",
                "trl");
        testIndividualPlace("pru", "Prussia", Land.class, false,
                null, 5, "bal", "ber", "sil", "war", "lvn");
        testIndividualPlace("sil", "Silesia", Land.class, true,
                null, 6, "pru", "ber", "mun", "boh", "gal", "war");
        testIndividualPlace("boh", "Bohemia", Land.class, true,
                null, 5, "sil", "mun", "trl", "vie", "gal");
        testIndividualPlace("trl", "Tyrolia", Land.class, true,
                null, 5, "mun", "boh", "vie", "tri", "ven");
        testIndividualPlace("tri", "Trieste", Capital_City.class, false,
                Country.AUSTRA_HUNGARY, 7, "ven", "trl", "vie", "bud", "ser", "alb",
                "adr");
        testIndividualPlace("vie", "Vienna", Capital_City.class, true,
                Country.AUSTRA_HUNGARY, 5, "boh", "gal", "bud", "tri", "trl");
        testIndividualPlace("bud", "Budapest", Capital_City.class, true,
                Country.AUSTRA_HUNGARY, 5, "vie", "gal", "rum", "ser", "tri");
        testIndividualPlace("gal", "Galicia", Land.class, true,
                null, 7, "sil", "boh", "vie", "bud", "rum", "ukr",
                "war");
        testIndividualPlace("rum", "Rumania", Capital_City.class, false,
                null, 7, "sev", "ukr", "gal", "bud", "ser", "bul",
                "bla");
        testIndividualPlace("bul", "Bulgaria", Capital_City.class, false,
                null, 6, "bla", "con", "aeg", "gre", "ser", "rum");
        testIndividualPlace("ser", "Serbia", Capital_City.class, true,
                null, 6, "tri", "alb", "gre", "bul", "rum", "bud");
        testIndividualPlace("alb", "Albania", Land.class, false,
                null, 5, "adr", "ion", "gre", "ser", "tri");
        testIndividualPlace("gre", "Greece", Capital_City.class, false,
                null, 5, "ion", "aeg", "bul", "ser", "alb");
        testIndividualPlace("ven", "Venezia", Capital_City.class, false,
                Country.ITALY, 7, "tri", "trl", "pie", "tus", "rom", "app",
                "adr");
        testIndividualPlace("pie", "Piemonte", Land.class, false,
                null, 4, "mar", "lyo", "tus", "ven");
        testIndividualPlace("tus", "Tuscany", Land.class, false,
                null, 5, "pie", "lyo", "tyn", "rom", "ven");
        testIndividualPlace("rom", "Roma", Capital_City.class, false,
                Country.ITALY, 5, "tyn", "nap", "app", "ven", "tus");
        testIndividualPlace("nap", "Napoli", Capital_City.class, false,
                Country.ITALY, 4, "rom", "tyn", "ion", "app");
        testIndividualPlace("app", "Apulia", Land.class, false,
                null, 5, "ven", "rom", "nap", "ion", "adr");
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
        assertEquals(numOfAdjacents, expectedAdjacents.length);
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
