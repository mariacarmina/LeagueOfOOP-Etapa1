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
        baseDamage = 200f;
        perLevelDamage = 20f;
    }

    public float getDamage() {
        float result = (baseDamage + level * perLevelDamage);
        result *= multiplier;
        if (critical) {
            result *= 1.5f;
        }
        return result;
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        critical = rounds % 3 == 0 && Map.getInstance().getField(source.getRow(), source.getColumn()) == Constants.ROGUE_LAND_MODIFIER_CHAR;
        rounds++;
        target.receive(this);
    }
}
