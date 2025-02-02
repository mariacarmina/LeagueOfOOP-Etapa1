package angels;

public class AngelFactory {
    private static AngelFactory instance = null;

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    /**
     * contribuie la realizarea Factory Pattern, returnand
     * un tip de inger corespunzator angelType-ului primit ca parametru
     * si citit in clasa GameInputLoader.
     *
     * @param angelType      - tipul ingerului
     * @param positionRow    - linia pe care e spawnat ingerul
     * @param positionColumn - coloana pe care e spawnat ingerul
     * @return
     */

    public Angel getAngelByType(final String angelType, final int positionRow,
                                final int positionColumn) {
        if (angelType.equals("DamageAngel")) {
            return new DamageAngel(positionRow, positionColumn);
        } else if (angelType.equals("DarkAngel")) {
            return new DarkAngel(positionRow, positionColumn);
        } else if (angelType.equals("Dracula")) {
            return new Dracula(positionRow, positionColumn);
        } else if (angelType.equals("GoodBoy")) {
            return new GoodBoy(positionRow, positionColumn);
        } else if (angelType.equals("LevelUpAngel")) {
            return new LevelUpAngel(positionRow, positionColumn);
        } else if (angelType.equals("LifeGiver")) {
            return new LifeGiver(positionRow, positionColumn);
        } else if (angelType.equals("SmallAngel")) {
            return new SmallAngel(positionRow, positionColumn);
        } else if (angelType.equals("Spawner")) {
            return new Spawner(positionRow, positionColumn);
        } else if (angelType.equals("TheDoomer")) {
            return new TheDoomer(positionRow, positionColumn);
        } else if (angelType.equals("XPAngel")) {
            return new XPAngel(positionRow, positionColumn);
        }
        return null;
    }

}
