package abilities;

import common.Constants;
import heroes.Hero;
import main.Map;

public class Backstab extends Ability {
    private float baseDamage;
    private float perLevelDamage;
    private int rounds;
    private boolean critical;

    public Backstab() {
        rounds = 0;
        baseDamage = Constants.BASE_DAMAGE_BACKSTAB;
        perLevelDamage = Constants.PER_LEVEL_BASE_DAMAGE_BACKSTAB;
    }

    /**
     * @return result
     * returneaza damage-ul acestei abilitati cu posibilitate de critical hit cand este cazul,
     * fara modificatori de rasa.
     */
    public float getDamage() {
        float result = (baseDamage + level * perLevelDamage);
        result *= multiplier;
        if (critical) {
            result *= Constants.BONUS_CRITICAL;
        }
        return result;
    }

    /**
     * @param source reprezinta jucatorul care dispune de aceasta abilitate
     * @param target reprezinta jucatorul atacat
     *               metoda reprezinta atacul lui source asupra lui target
     *               target apeleaza metoda de receive din clasa specifica de erou,
     *               unde se adauga modificatorul de rasa.
     *               primeste bonus de critical hit o data la trei runde
     *               daca source se afla pe teren de Woods
     */
    public void cast(final Hero source, final Hero target) {
        setLevel(source.getLevel());
        setMultiplier(source.getLandModifier());
        //source.setAngelMultiplier(source.getAngelMultiplier());
        critical = rounds % Constants.CRITICAL_ROUNDS == 0
                && Map.getInstance().getField(source.getRow(), source.getColumn())
                == Constants.ROGUE_LAND_MODIFIER_CHAR;
        rounds++;
        target.receive(this);
    }
}
