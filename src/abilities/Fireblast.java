package abilities;

import heroes.Hero;

public class Fireblast extends Ability {
    private float baseDamage;
    private float perLevelDamage;

    public Fireblast() {
        baseDamage = 350f;
        perLevelDamage = 50f;
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
