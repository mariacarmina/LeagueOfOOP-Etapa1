package abilities;

import common.Constants;
import heroes.Hero;

public class Execute extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseHPLimit;
    private float perLevelHPLimit;
    private float maximumHPLimit;

    public Execute() {
        baseDamage = Constants.BASE_DAMAGE_EXECUTE;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_EXECUTE;
        baseHPLimit = Constants.BASE_LIMIT_HP_EXECUTE;
        perLevelHPLimit = Constants.PER_LEVEL_LIMIT_HP_EXECUTE;
        maximumHPLimit = Constants.MAXIMUM_HP_EXECUTE;
    }

    /**
     * @return result
     * returneaza damage-ul acestei abilitati, fara modificatori de rasa.
     */

    public float getDamage() {
        return multiplier * (baseDamage + level * perLevelDamage);
    }

    /**
     * @return HPLimit
     * calculeaza pragul de HP, crescand odata cu procentul de
     * 20% si 1% per nivel pana la un maxim de 40%.
     */

    public float getHPLimit() {
        return Math.min(maximumHPLimit, baseHPLimit + level * perLevelHPLimit);
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
        //source.setAngelMultiplier(source.getAngelMultiplier());
        target.receive(this);
    }
}
