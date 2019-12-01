package abilities;

import common.Constants;
import heroes.Hero;

public class Fireblast extends Ability {
    private float baseDamage;
    private float perLevelDamage;

    public Fireblast() {
        baseDamage = Constants.BASE_DAMAGE_FIREBLAST;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_FIREBLAST;
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
