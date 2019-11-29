package abilities;

import heroes.Hero;

public class Deflect extends Ability {
    private float basePercentage;
    private float perLevelPercentage;
    private float maximumPercentage;
    private float receivedDamage;

    public Deflect() {
        basePercentage = 0.35f;
        perLevelPercentage = 0.02f;
        maximumPercentage = 0.7f;
    }

    public float getDamage() {
        return multiplier * Math.min(basePercentage + level * perLevelPercentage, maximumPercentage) * receivedDamage;
    }

    public void cast(Hero source, Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        receivedDamage = source.getBaseTakenDamage();
        target.receive(this);
    }
}
