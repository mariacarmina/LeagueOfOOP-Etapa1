package abilities;

import common.Constants;
import heroes.Hero;

public class Ignite extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseRoundDamage;
    private float perLevelRoundDamage;

    public Ignite() {
        baseDamage = Constants.BASE_DAMAGE_IGNITE;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_IGNITE;
        baseRoundDamage = Constants.DAMAGE_PER_ROUND_IGNITE;
        perLevelRoundDamage = Constants.PER_LEVEL_DAMAGE_PER_ROUND_IGNITE;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public float getRoundDamage() {
        return multiplier * (baseRoundDamage + level * perLevelRoundDamage);
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}