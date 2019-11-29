package com.abilities;

import com.common.Constants;
import com.heroes.Hero;
import com.main.Map;

public class Backstab extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private int rounds;

    public Backstab() {
        rounds = 0;
        baseDamage = 200f;
        perLevelDamage = 20f;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        if (rounds % 3 == 0 && Map.getInstance().getField(source.getRow(), source.getColumn()) == Constants.ROGUE_LAND_MODIFIER_CHAR) {
            multiplier *= 1.5f;
        }
        rounds++;
        target.receive(this);
    }
}
