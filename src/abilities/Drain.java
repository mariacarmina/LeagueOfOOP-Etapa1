package abilities;

import common.Constants;
import heroes.Hero;

public class Drain extends Ability {
    private float basePercentage;
    private float perLevelPercentage;

    public Drain() {
        basePercentage = Constants.BASE_DAMAGE_DRAIN;
        perLevelPercentage = Constants.PER_LEVEL_BASE_DAMAGE_DRAIN;
    }

    /**
     * @return result
     * returneaza damage-ul acestei abilitati, fara modificatori de rasa,
     * scazand proportional din viata oponentului
     */
    public float getDamage(final float opponentHP) {
        return multiplier * (basePercentage + level * perLevelPercentage) * opponentHP;
    }

    /**
     * returneaza damage-ul in procente fiind asemanatoare cu metoda getDamage.
     * percent reprezinta o parte din damage-ul de baza
     *
     * @param opponentHP
     * @param percent
     * @return
     */

    public float getDamagePercent(final float opponentHP, final float percent) {
        return multiplier * (basePercentage + level * perLevelPercentage) * percent * opponentHP;
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
        setAngelMultiplier(source.getAngelMultiplier());
        setStrategyMultiplier(source.getStrategyMultiplier());
        target.receive(this);
    }
}
