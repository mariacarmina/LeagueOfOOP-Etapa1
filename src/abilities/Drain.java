package abilities;

import common.Constants;
import heroes.Hero;

public class Drain extends Ability {
    private float basePercentage;
    private float perLevelPercentage;

    public Drain() {
        basePercentage = Constants.BASE_DAMAGE_DRAIN;
        perLevelPercentage = Constants.PER_LEVEL_BASE_DAMAGE_DRAIN;
    }

    public float getDamage(float opponentHP) {
        return multiplier * (basePercentage + level * perLevelPercentage) * opponentHP;
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}