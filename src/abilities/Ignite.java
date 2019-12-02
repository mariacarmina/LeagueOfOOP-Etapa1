package abilities;

import common.Constants;
import heroes.Hero;

public class Ignite extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseRoundDamage;
    private float perLevelRoundDamage;

    public Ignite() {
        baseDamage = Constants.BASE_DAMAGE_IGNITE;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_IGNITE;
        baseRoundDamage = Constants.DAMAGE_PER_ROUND_IGNITE;
        perLevelRoundDamage = Constants.PER_LEVEL_DAMAGE_PER_ROUND_IGNITE;
    }

    /**
     * @return result
     * returneaza damage-ul acestei abilitati, fara modificatori de rasa.
     */

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    /**
     *
     * @return result
     * returneaza damage-ul overtime de 50, fara modificatori de rasa.
     */

    public float getRoundDamage() {
        return multiplier * (baseRoundDamage + level * perLevelRoundDamage);
    }

    /**
     *
     * @param source
     * reprezinta jucatorul care dispune de aceasta abilitate
     * @param target
     * reprezinta jucatorul atacat
     * metoda reprezinta atacul lui source asupra lui target
     * target apeleaza metoda de receive din clasa specifica de erou,
     * unde se adauga modificatorul de rasa.
     */

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        target.receive(this);
    }
}
