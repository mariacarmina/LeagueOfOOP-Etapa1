package abilities;

import common.Constants;
import heroes.Hero;
import main.Map;

public class Paralysis extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseRoundDamage;
    private float perLevelRoundDamage;
    private int rounds;

    public Paralysis() {
        baseDamage = Constants.BASE_DAMAGE_PARALYSIS;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_PARALYSIS;
        baseRoundDamage = Constants.DAMAGE_PER_ROUND_PARALYSIS;
        perLevelRoundDamage = Constants.PER_LEVEL_DAMAGE_PER_ROUND_PARALYSIS;
        rounds = Constants.PARALYSIS_ROUNDS;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public float getRoundDamage() {
        return multiplier * (baseRoundDamage + level * perLevelRoundDamage);
    }

    public int getRounds() {
        return rounds;
    }

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        rounds = Constants.PARALYSIS_ROUNDS;
        if (Map.getInstance().getField(source.getRow(), source.getColumn())
                == Constants.ROGUE_LAND_MODIFIER_CHAR) {
            rounds *= 2;
        }
        target.receive(this);
    }
}
