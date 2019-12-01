package abilities;

import common.Constants;
import heroes.Hero;
import main.Map;

public class Backstab extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private int rounds;
    private boolean critical;

    public Backstab() {
        rounds = 0;
        baseDamage = Constants.BASE_DAMAGE_BACKSTAB;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_BACKSTAB;
    }

    public float getDamage() {
        float result = (baseDamage + level * perLevelDamage);
        result *= multiplier;
        if (critical) {
            result *= Constants.BONUS_CRITICAL;
        }
        return result;
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        critical = rounds % Constants.CRITICAL_ROUNDS == 0
                && Map.getInstance().getField(source.getRow(), source.getColumn())
                == Constants.ROGUE_LAND_MODIFIER_CHAR;
        rounds++;
        target.receive(this);
    }
}
