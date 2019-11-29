package com.abilities;

import com.heroes.Hero;

public class Slam extends Ability {
    private float baseDamage;
    private float perLevelDamage;

    public Slam() {
        baseDamage = 100f;
        perLevelDamage = 40f;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}
