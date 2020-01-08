package heroes;

public final class HeroFactory {
    private static HeroFactory instance = null;
    private int objectCounter;

    private HeroFactory() {
        objectCounter = 0;
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero getHeroByType(final String heroType, final int positionRow,
                              final int positionColumn) {
        int nextHeroID = objectCounter;
        objectCounter++;
        if (heroType.equals("P")) {
            return new Pyromancer(positionRow, positionColumn, nextHeroID);
        } else if (heroType.equals("K")) {
            return new Knight(positionRow, positionColumn, nextHeroID);
        } else if (heroType.equals("R")) {
            return new Rogue(positionRow, positionColumn, nextHeroID);
        } else if (heroType.equals("W")) {
            return new Wizard(positionRow, positionColumn, nextHeroID);
        }
        return null;
    }
}
