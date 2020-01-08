package abilities;

import heroes.Hero;

public abstract class Ability {
    public int level;
    public float multiplier;
    public float angelMultiplier;
    public float strategyMultiplier;


    /**
     * @param level setter pentru nivelul atacatorului
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * @param multiplier setter pentru modificatorul de teren
     */
    public void setMultiplier(final float multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * @param strategyMultiplier setter pentru modificatorul de startegie
     */

    public void setStrategyMultiplier(final float strategyMultiplier) {
        this.strategyMultiplier = strategyMultiplier;
    }

    /**
     * @param source
     * @param target metoda cast este folosita pe post de attack intre source si target
     */

    public abstract void cast(Hero source, Hero target);

    /**
     *
     * @param angelMultiplier setter pentru modificatorul de la ingeri
     */

    public void setAngelMultiplier(final float angelMultiplier) {
        this.angelMultiplier = angelMultiplier;
    }
}
