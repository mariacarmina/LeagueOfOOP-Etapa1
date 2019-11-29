package com.abilities;

import com.heroes.Hero;

public class Execute extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseHPLimit;
    private float perLevelHPLimit;
    private float maximumHPLimit;

    public Execute() {
        baseDamage = 200f;
        perLevelDamage = 30f;
        baseHPLimit = 0.2f;
        perLevelHPLimit = 0.01f;
        maximumHPLimit = 0.4f;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public float getHPLimit() {
        return Math.min(maximumHPLimit, baseHPLimit + level * perLevelHPLimit);
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}
