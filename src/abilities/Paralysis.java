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
        baseDamage = 40f;
        perLevelDamage = 10f;
        baseRoundDamage = 40f;
        perLevelRoundDamage = 10f;
        rounds = 3;
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

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        rounds = 3;
        if (Map.getInstance().getField(source.getRow(), source.getColumn()) == Constants.ROGUE_LAND_MODIFIER_CHAR) {
            rounds *= 2;
        }
        target.receive(this);
    }
}
