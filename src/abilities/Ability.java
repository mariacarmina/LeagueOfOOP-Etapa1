package abilities;

import heroes.Hero;

public abstract class Ability {
    public int level;
    public float multiplier;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public abstract void cast(Hero source, Hero target);
}
