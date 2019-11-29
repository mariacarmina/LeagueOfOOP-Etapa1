package heroes;

public final class HeroFactory {
    private static HeroFactory instance = null;

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero getHeroByType(String heroType, int positionRow, int positionColumn) {
        if (heroType.equals("P")) {
            return new Pyromancer(positionRow, positionColumn);
        } else if (heroType.equals("K")) {
            return new Knight(positionRow, positionColumn);
        } else if (heroType.equals("R")) {
            return new Rogue(positionRow, positionColumn);
        } else if (heroType.equals("W")) {
            return new Wizard(positionRow, positionColumn);
        }
        return null;
    }
}
