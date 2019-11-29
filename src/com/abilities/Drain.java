package com.abilities;

import com.heroes.Hero;

public class Drain extends Ability {
    private float basePercentage;
    private float perLevelPercentage;

    public Drain() {
        basePercentage = 0.2f;
        perLevelPercentage = 0.05f;
    }

    public float getDamage(float opponentHP) {
        return multiplier * (basePercentage + level * perLevelPercentage) * opponentHP;
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}