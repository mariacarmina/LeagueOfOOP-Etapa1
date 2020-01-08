package heroes;

public abstract class HeroStrategy {
    protected int minLimit;
    protected int maxLimit;
    protected float attackBoost;
    protected float defenseBoost;
    protected int lossHP;
    protected int winHP;

    public HeroStrategy(final int minLimit, final int maxLimit, final float attackBoost,
                        final float defenseBoost, final int lossHP, final int winHP) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.attackBoost = attackBoost;
        this.defenseBoost = defenseBoost;
        this.lossHP = lossHP;
        this.winHP = winHP;
    }

    /**
     * metoda attack defineste un tip de strategie a eroului.
     *
     * @param hero - eroul care adopta strategia de attack
     */

    public void attack(final Hero hero) {
        hero.setCurrentHP(hero.getCurrentHP() - (hero.getCurrentHP() / lossHP));
        hero.setStrategyMultiplier(hero.getStrategyMultiplier() + attackBoost);
    }

    /**
     * metoda defense defineste celalalt tip de strategie a eroului.
     *
     * @param hero - eroul care aplica strategia de defense
     */

    public void defense(final Hero hero) {
        hero.setCurrentHP(hero.getCurrentHP() + (hero.getCurrentHP() / winHP));
        hero.setStrategyMultiplier(hero.getStrategyMultiplier() - defenseBoost);
    }

    /**
     * in functie de HP-ul curent al eroului, o singura strategie va fi activata.
     *
     * @param hero
     */

    public void choose(final Hero hero) {
        if (hero.getMaxHP() / minLimit < hero.getCurrentHP()
                && hero.getCurrentHP() < hero.getMaxHP() / maxLimit) {
            attack(hero);
        } else if (hero.getCurrentHP() < hero.getMaxHP() / minLimit) {
            defense(hero);
        }
    }
}
