package abilities;

import common.Constants;
import heroes.Hero;

public class Deflect extends Ability {
    private float basePercentage;
    private float perLevelPercentage;
    private float maximumPercentage;
    private float receivedDamage;

    public Deflect() {
        basePercentage = Constants.BASE_DAMAGE_DEFLECT;
        perLevelPercentage = Constants.PER_LEVEL_BASE_DAMAGE_DEFLECT;
        maximumPercentage = Constants.MAXIMUM_PERCENTAGE;
    }

    public float getDamage() {
        return multiplier * Math.min(basePercentage + level * perLevelPercentage,
                maximumPercentage) * receivedDamage;
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        receivedDamage = source.getBaseTakenDamage();
        target.receive(this);
    }
}
