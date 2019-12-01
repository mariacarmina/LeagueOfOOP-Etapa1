package abilities;

import common.Constants;
import heroes.Hero;

public class Execute extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseHPLimit;
    private float perLevelHPLimit;
    private float maximumHPLimit;

    public Execute() {
        baseDamage = Constants.BASE_DAMAGE_EXECUTE;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_EXECUTE;
        baseHPLimit = Constants.BASE_LIMIT_HP_EXECUTE;
        perLevelHPLimit = Constants.PER_LEVEL_LIMIT_HP_EXECUTE;
        maximumHPLimit = Constants.MAXIMUM_HP_EXECUTE;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public float getHPLimit() {
        return Math.min(maximumHPLimit, baseHPLimit + level * perLevelHPLimit);
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}
