package abilities;

import common.Constants;
import heroes.Hero;

public class Slam extends Ability {
    private float baseDamage;
    private float perLevelDamage;

    public Slam() {
        baseDamage = Constants.BASE_DAMAGE_SLAM;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_SLAM;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}
