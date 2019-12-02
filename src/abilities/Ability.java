package abilities;

import heroes.Hero;

public abstract class Ability {
    public int level;
    public float multiplier;

    /**
     * @param level setter pentru nivelul atacatorului
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     *
     * @param multiplier
     * setter pentru modificatorul de teren
     */
    public void setMultiplier(final float multiplier) {
        this.multiplier = multiplier;
    }

    public abstract void cast(Hero source, Hero target);
}
