package abilities;

import common.Constants;
import heroes.Hero;
import main.Map;

public class Paralysis extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private float baseRoundDamage;
    private float perLevelRoundDamage;
    private int rounds;

    public Paralysis() {
        baseDamage = Constants.BASE_DAMAGE_PARALYSIS;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_PARALYSIS;
        baseRoundDamage = Constants.DAMAGE_PER_ROUND_PARALYSIS;
        perLevelRoundDamage = Constants.PER_LEVEL_DAMAGE_PER_ROUND_PARALYSIS;
        rounds = Constants.PARALYSIS_ROUNDS;
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
     * returneaza damage-ul overtime de 40, fara modificatori de rasa.
     */

    public float getRoundDamage() {
        return multiplier * (baseRoundDamage + level * perLevelRoundDamage);
    }

    /**
     *
     * @return rounds
     * getter pentru numarul de runde, pentru abilitatea
     * de imobilizare
     */

    public int getRounds() {
        return rounds;
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
     * numarul de runde de imobilizare este de 3, dar cand lupta se desfasoara
     * pe teren Woods, acesta poate da adversarului 6 runde de imobilizare.
     */

    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        rounds = Constants.PARALYSIS_ROUNDS;
        if (Map.getInstance().getField(source.getRow(), source.getColumn())
                == Constants.ROGUE_LAND_MODIFIER_CHAR) {
            rounds *= 2;
        }
        target.receive(this);
    }
}
