package ubc.projects.model;

/**
 * Created by greggzik on 2017-04-04.
 * Represents the Diplomacy Board layout, whose structure is constant.
 * Single Design Pattern Used.
 */
public class Board {
    private static Board instance = new Board();

    public static Board getInstance() {
        return instance;
    }

    private Board() {

    }

    private void setUpPlaces() {
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
        Sea nat = new Sea("North Atlantic");
        Sea nrg = new Sea("Norwegian Sea");
        Sea bar = new Sea("Barents Sea");
        Sea irl = new Sea("Irish Sea");
        Sea nth = new Sea("North Sea");
        Sea eng = new Sea("English Channel");
        Sea ska = new Sea("Skagerrak");
        Sea hel = new Sea("Helgoland Bight");
        Sea bal = new Sea("Baltic Sea");
        Sea bot = new Sea("Gulf of Bothnia");
        Sea mid = new Sea("Mid Atlantic");
        Sea wes = new Sea("West Mediterranean");
        Sea lyo = new Sea("Gulf of Lyon");
        Sea tyn = new Sea("Tyrhennian Sea");
        Sea adr = new Sea("Adriatic Sea");
        Sea ion = new Sea("Ionian Sea");
        Sea aeg = new Sea("Aegean Sea");
        Sea eas = new Sea("East Mediterranean");
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

    }
}
