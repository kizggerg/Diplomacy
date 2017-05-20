package ubc.projects.model.map;

/**
 * Created by greggzik on 2017-04-04.
 * Represents the 7 playable "Great Powers" in the game.
 */
public enum Country {
    ENGLAND, FRANCE, GERMANY, ITALY, AUSTRA_HUNGARY, TURKEY, RUSSIA;

    @Override
    public String toString() {
        if (super.equals(AUSTRA_HUNGARY)) {
            return "Austria-Hungary";
        }
        else return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}
