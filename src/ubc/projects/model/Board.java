package ubc.projects.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by greggzik on 2017-04-04.
 * Represents the Diplomacy Board layout, whose structure is constant.
 * Single Design Pattern Used.
 */
public class Board {
    private static Board instance = new Board();
    private Map<String, Place> places = new HashMap<String, Place>();

    public static Board getInstance() {
        return instance;
    }

    private Board() {
        setUpPlaces();
    }

    /**
     * Returns true if there is a place mapped by the key str.
     * @param str    The abbreviation key for the place
     * @return       True is there is a place w/ key == str.
     */
    public boolean containsPlace(String str) {
        return places.containsKey(str);
    }

    /**
     * Returns the place with key == str if the place exists, otherwise returns null.
     * @param str   The key of the expected place.
     * @return      The place if key maps to a valid one, else null.
     */
    public Place findPlace(String str) {
        if (containsPlace(str)) return places.get(str);
        else return null;
    }

    /**
     * Creates and sets up place objects and adds them to the hashmap in accordance to their abbreviated names.
     * For reference, see the Board Game map included in the source files to see which abbreviation maps to which place.
     */
    private void setUpPlaces() {
        // Creates Place Objects

        // Capital Cities
        Capital_City bre = new Capital_City("Brest", false, Country.FRANCE);
        Capital_City par = new Capital_City("Paris", true, Country.FRANCE);
        Capital_City mar = new Capital_City("Marseilles", false, Country.FRANCE);
        Capital_City ven = new Capital_City("Venezia", false, Country.ITALY);
        Capital_City rom = new Capital_City("Roma", false, Country.ITALY);
        Capital_City nap = new Capital_City("Napoli", false, Country.ITALY);
        Capital_City tri = new Capital_City("Trieste", false, Country.AUSTRA_HUNGARY);
        Capital_City bud = new Capital_City("Budapest", true, Country.AUSTRA_HUNGARY);
        Capital_City vie = new Capital_City("Vienna", true, Country.AUSTRA_HUNGARY);
        Capital_City con = new Capital_City("Constantinople", false, Country.TURKEY);
        Capital_City smy = new Capital_City("Smyrna", false, Country.TURKEY);
        Capital_City ank = new Capital_City("Ankara", false, Country.TURKEY);
        Capital_City sev = new Capital_City("Stevastopol", false, Country.RUSSIA);
        Capital_City mos = new Capital_City("Moscow", true, Country.RUSSIA);
        Capital_City war = new Capital_City("Warsaw", true, Country.RUSSIA);
        Capital_City stp = new Capital_City("Saint Petersburg", false, Country.RUSSIA);
        Capital_City mun = new Capital_City("Munich", true, Country.GERMANY);
        Capital_City ber = new Capital_City("Berlin", false, Country.GERMANY);
        Capital_City kie = new Capital_City("Kiel", false, Country.GERMANY);
        Capital_City lon = new Capital_City("London", false, Country.ENGLAND);
        Capital_City lpl = new Capital_City("Liverpool", false, Country.ENGLAND);
        Capital_City edi = new Capital_City("Edinburgh", false, Country.ENGLAND);
        Capital_City por = new Capital_City("Portugal", false, null);
        Capital_City spa = new Capital_City("Spain", false, null);
        Capital_City ser = new Capital_City("Serbia", true, null);
        Capital_City gre = new Capital_City("Greece", false, null);
        Capital_City bul = new Capital_City("Bulgaria", false, null);
        Capital_City rum = new Capital_City("Rumania", false, null);
        Capital_City nwy = new Capital_City("Norway", false, null);
        Capital_City den = new Capital_City("Denmark", false, null);
        Capital_City swe = new Capital_City("Sweden", false, null);
        Capital_City tun = new Capital_City("Tunisia", false, null);
        Capital_City bel = new Capital_City("Belgium", false, null);
        Capital_City hol = new Capital_City("Holland", false, null);

        // Seas
        Sea nat = new Sea("North Atlantic Sea");
        Sea nrg = new Sea("Norwegian Sea");
        Sea bar = new Sea("Barents Sea");
        Sea iri = new Sea("Irish Sea");
        Sea nth = new Sea("North Sea");
        Sea eng = new Sea("English Channel");
        Sea ska = new Sea("Skagerrak Strait");
        Sea hel = new Sea("Helgoland Bight");
        Sea bal = new Sea("Baltic Sea");
        Sea bot = new Sea("Gulf of Bothnia");
        Sea mid = new Sea("Mid Atlantic Sea");
        Sea wes = new Sea("West Mediterranean Sea");
        Sea lyo = new Sea("Gulf of Lyon");
        Sea tyn = new Sea("Tyrhennian Sea");
        Sea adr = new Sea("Adriatic Sea");
        Sea ion = new Sea("Ionian Sea");
        Sea aeg = new Sea("Aegean Sea");
        Sea eas = new Sea("East Mediterranean Sea");
        Sea bla = new Sea("Black Sea");

        // Other Lands
        Land cly = new Land("Clyde", false);
        Land wal = new Land("Wales", false);
        Land yor = new Land("York", false);
        Land fin = new Land("Finland", false);
        Land lvn = new Land("Livonia", false);
        Land ukr = new Land("Ukraine", true);
        Land pru = new Land("Prussia", false);
        Land sil = new Land("Silesia", true);
        Land gal = new Land("Galicia", true);
        Land boh = new Land("Bohemia", true);
        Land ruh = new Land("Ruhr", true);
        Land pic = new Land("Picardy", false);
        Land bur = new Land("Burgundy", true);
        Land gas = new Land("Gascony", false);
        Land pie = new Land("Piemonte", false);
        Land app = new Land("Apulia", false);
        Land tus = new Land("Tuscany", false);
        Land naf = new Land("North Africa", false);
        Land arm = new Land("Armenia", false);
        Land syr = new Land("Syria", false);
        Land alb = new Land("Albania", false);
        Land trl = new Land("Tyrolia", true);

        // Adds adjacents to all places

        nat.addAdjacents(mid, iri, lpl, cly, nrg);
        nrg.addAdjacents(cly, edi, nth, nwy, bar);
        bar.addAdjacents(stp, nwy);
        iri.addAdjacents(mid, eng, wal, lpl);
        eng.addAdjacents(mid, wal, lon, bre, pic, bel, nth);
        nth.addAdjacents(edi, yor, lon, bel, hol, hel, den, ska, nwy);
        hel.addAdjacents(hol, den, kie);
        ska.addAdjacents(nwy, swe, den, bal);
        bal.addAdjacents(swe, den, kie, ber, pru, lvn, bot);
        bot.addAdjacents(swe, fin, stp, lvn);
        mid.addAdjacents(bre, gas, spa, por, naf, wes);
        wes.addAdjacents(naf, spa, lyo, tyn, tun);
        lyo.addAdjacents(spa, mar, pie, tus, tyn);
        tyn.addAdjacents(tun, ion, nap, rom, tus);
        ion.addAdjacents(tun, nap, app, adr, alb, gre, aeg, eas);
        adr.addAdjacents(app, ven, tri, alb);
        aeg.addAdjacents(gre, smy, bul, con, eas);
        eas.addAdjacents(smy, syr);
        bla.addAdjacents(sev, rum, bul, con, ank, arm);
        cly.addAdjacents(edi, lpl);
        edi.addAdjacents(cly, lpl, yor);
        lpl.addAdjacents(cly, edi, yor, wal);
        wal.addAdjacents(lpl, yor, lon);
        lon.addAdjacents(wal, yor);
        nwy.addAdjacents(swe, fin, stp);
        swe.addAdjacents(nwy, den, fin);
        fin.addAdjacents(nwy, swe, stp);
        stp.addAdjacents(nwy, fin, lvn, mos);
        mos.addAdjacents(stp, lvn, war, ukr, sev);
        lvn.addAdjacents(stp, mos, war, pru);
        war.addAdjacents(mos, lvn, pru, sil, gal, ukr);
        ukr.addAdjacents(mos, war, gal, rum, sev);
        sev.addAdjacents(mos, ukr, rum, arm);
        arm.addAdjacents(sev, ank, syr, smy);
        syr.addAdjacents(arm, smy);
        smy.addAdjacents(con, ank, arm, syr);
        ank.addAdjacents(arm, smy, con);
        con.addAdjacents(ank, smy, bul);
        gre.addAdjacents(alb, ser, bul);
        bul.addAdjacents(gre, con, rum, ser);
        rum.addAdjacents(sev, ukr, gal, bud, ser, bul);
        ser.addAdjacents(rum, bul, gre, alb, tri, bud);
        alb.addAdjacents(gre, ser, tri);
        tri.addAdjacents(ven, trl, vie, bud, ser, alb);
        bud.addAdjacents(vie, tri, ser, rum, gal);
        gal.addAdjacents(rum, bud, vie, boh, sil, war, ukr);
        vie.addAdjacents(boh, gal, bud, tri, trl);
        trl.addAdjacents(ven, tri, vie, boh, mun);
        ven.addAdjacents(tri, trl, pie, tus, rom, app);
        app.addAdjacents(ven, rom, nap);
        nap.addAdjacents(app, rom);
        rom.addAdjacents(nap, app, ven, tus);
        tus.addAdjacents(rom, ven, pie);
        pie.addAdjacents(tus, ven, mar);
        tun.addAdjacents(naf);
        naf.addAdjacents(tun);
        pru.addAdjacents(ber, sil, war, lvn);
        sil.addAdjacents(ber, mun, boh, gal, war, pru);
        boh.addAdjacents(sil, mun, trl, vie, gal);
        mun.addAdjacents(trl, boh, sil, ber, kie, ruh, bur);
        ber.addAdjacents(kie, mun, sil, pru);
        kie.addAdjacents(den, hol, ruh, mun, ber);
        den.addAdjacents(swe, kie);
        ruh.addAdjacents(kie, mun, bur, bel, hol);
        hol.addAdjacents(kie, ruh, bel);
        bel.addAdjacents(hol, ruh, bur, pic);
        bur.addAdjacents(mun, ruh, bel, pic, par, gas, mar);
        pic.addAdjacents(bel, bur, par, bre);
        par.addAdjacents(bre, pic, bur, gas);
        bre.addAdjacents(pic, par, gas);
        gas.addAdjacents(bre, par, bur, mar, spa);
        mar.addAdjacents(bur, gas, spa, pie);
        spa.addAdjacents(por, gas, mar);
        por.addAdjacents(spa);

        // Adds all places to Map
        places.put("nat", nat);
        places.put("nrg", nrg);
        places.put("bar", bar);
        places.put("mid", mid);
        places.put("eng", eng);
        places.put("nth", nth);
        places.put("ska", ska);
        places.put("hel", hel);
        places.put("bal", bal);
        places.put("bot", bot);
        places.put("iri", iri);
        places.put("wes", wes);
        places.put("lyo", lyo);
        places.put("tyn", tyn);
        places.put("ion", ion);
        places.put("adr", adr);
        places.put("aeg", aeg);
        places.put("eas", eas);
        places.put("bla", bla);
        places.put("cly", cly);
        places.put("edi", edi);
        places.put("lpl", lpl);
        places.put("yor", yor);
        places.put("wal", wal);
        places.put("lon", lon);
        places.put("nwy", nwy);
        places.put("swe", swe);
        places.put("fin", fin);
        places.put("stp", stp);
        places.put("lvn", lvn);
        places.put("mos", mos);
        places.put("sev", sev);
        places.put("war", war);
        places.put("ukr", ukr);
        places.put("arm", arm);
        places.put("syr", syr);
        places.put("smy", smy);
        places.put("ank", ank);
        places.put("con", con);
        places.put("gre", gre);
        places.put("bul", bul);
        places.put("alb", alb);
        places.put("ser", ser);
        places.put("rum", rum);
        places.put("tri", tri);
        places.put("bud", bud);
        places.put("gal", gal);
        places.put("vie", vie);
        places.put("trl", trl);
        places.put("boh", boh);
        places.put("sil", sil);
        places.put("pru", pru);
        places.put("ber", ber);
        places.put("mun", mun);
        places.put("ruh", ruh);
        places.put("kie", kie);
        places.put("den", den);
        places.put("hol", hol);
        places.put("bel", bel);
        places.put("pic", pic);
        places.put("bur", bur);
        places.put("par", par);
        places.put("bre", bre);
        places.put("gas", gas);
        places.put("por", por);
        places.put("spa", spa);
        places.put("mar", mar);
        places.put("pie", pie);
        places.put("tus", tus);
        places.put("rom", rom);
        places.put("nap", nap);
        places.put("app", app);
        places.put("ven", ven);
        places.put("naf", naf);
        places.put("tun", tun);
    }
}
