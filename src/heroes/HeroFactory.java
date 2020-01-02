package heroes;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() {
    }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero getHeroByType(final String heroType, final int positionRow,
                              final int positionColumn, final int heroID) {
        if (heroType.equals("P")) {
            return new Pyromancer(positionRow, positionColumn, heroID);
        } else if (heroType.equals("K")) {
            return new Knight(positionRow, positionColumn, heroID);
        } else if (heroType.equals("R")) {
            return new Rogue(positionRow, positionColumn, heroID);
        } else if (heroType.equals("W")) {
            return new Wizard(positionRow, positionColumn, heroID);
        }
        return null;
    }
}
