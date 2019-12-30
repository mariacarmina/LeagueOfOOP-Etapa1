package abilities;

import common.Constants;
import heroes.Hero;

public class Deflect extends Ability {
    private float basePercentage;
    private float perLevelPercentage;
    private float maximumPercentage;
    private float receivedDamage;

    public Deflect() {
        basePercentage = Constants.BASE_DAMAGE_DEFLECT;
        perLevelPercentage = Constants.PER_LEVEL_BASE_DAMAGE_DEFLECT;
        maximumPercentage = Constants.MAXIMUM_PERCENTAGE;
    }

    /**
     * @return result
     * returneaza damage-ul acestei abilitati, fara modificatori de rasa,
     * damage egal cu un procent din damage-ul total pe care îl primește
     * de la adversar, pana la un maxim de 70%.
     */
    public float getDamage() {
        return multiplier * Math.min(basePercentage + level * perLevelPercentage,
                maximumPercentage) * receivedDamage;
    }

    /**
     * @param source reprezinta jucatorul care dispune de aceasta abilitate
     * @param target reprezinta jucatorul atacat
     *               metoda reprezinta atacul lui source asupra lui target
     *               target apeleaza metoda de receive din clasa specifica de erou,
     *               unde se adauga modificatorul de rasa.
     *               damage-ul primit de la target aplicat lui source este stocat
     *               intr-o variabila receivedDamage ce este utila in calculul metodei anterioare.
     */
    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        //source.setAngelMultiplier(source.getAngelMultiplier());
        receivedDamage = source.getBaseTakenDamage();
        target.receive(this);
    }
}
