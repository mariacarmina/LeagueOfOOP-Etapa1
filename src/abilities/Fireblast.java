package abilities;

import common.Constants;
import heroes.Hero;

public class Fireblast extends Ability {
    private float baseDamage;
    private float perLevelDamage;

    public Fireblast() {
        baseDamage = Constants.BASE_DAMAGE_FIREBLAST;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_FIREBLAST;
    }

    /**
     * @return result
     * returneaza damage-ul acestei abilitati, fara modificatori de rasa.
     */
    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    /**
     * @param source reprezinta jucatorul care dispune de aceasta abilitate
     * @param target reprezinta jucatorul atacat
     *               metoda reprezinta atacul lui source asupra lui target
     *               target apeleaza metoda de receive din clasa specifica de erou,
     *               unde se adauga modificatorul de rasa.
     */

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
//        source.setStrategyMultiplier(source.getStrategyMultiplier());
//        source.setAngelMultiplier(source.getAngelMultiplier());
        target.receive(this);
    }
}
