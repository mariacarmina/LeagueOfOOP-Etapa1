package abilities;

import heroes.Hero;

public class Ignite extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseRoundDamage;
    private float perLevelRoundDamage;

    public Ignite() {
        baseDamage = 150f;
        perLevelDamage = 20f;
        baseRoundDamage = 50f;
        perLevelRoundDamage = 30f;
    }

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    public float getRoundDamage() {
        return multiplier * (baseRoundDamage + level * perLevelRoundDamage);
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}