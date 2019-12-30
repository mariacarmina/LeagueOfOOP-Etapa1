package heroes;

public abstract class HeroStrategy {
    protected int minLimit;
    protected int maxLimit;
    protected float attackBoost;
    protected float defenseBoost;
    protected int lossHP;
    protected int winHP;

    public HeroStrategy(int minLimit, int maxLimit, float attackBoost, float defenseBoost, int lossHP, int winHP) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.attackBoost = attackBoost;
        this.defenseBoost = defenseBoost;
        this.lossHP = lossHP;
        this.winHP = winHP;
    }

    public void attack(Hero hero) {
        hero.setCurrentHP(hero.getCurrentHP() - Math.round(hero.getCurrentHP() / lossHP));
        hero.setStrategyMultiplier(hero.getStrategyMultiplier() + attackBoost);
    }

    public void defense(Hero hero) {
        hero.setCurrentHP(hero.getCurrentHP() + Math.round(hero.getCurrentHP() / winHP));
        hero.setStrategyMultiplier(hero.getStrategyMultiplier() - defenseBoost);
    }

    public void choose(Hero hero) {
        if (hero.getMaxHP() / minLimit < hero.getCurrentHP()
                && hero.getCurrentHP() < hero.getMaxHP() / maxLimit) {
            attack(hero);
        } else if (hero.getCurrentHP() < hero.getMaxHP() / minLimit) {
            defense(hero);
        }
    }
}
