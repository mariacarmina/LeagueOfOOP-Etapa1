package heroes;

import abilities.Backstab;
import abilities.Deflect;
import abilities.Drain;
import abilities.Execute;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Paralysis;
import abilities.Slam;
import angels.Angel;
import common.Constants;
import common.FileLogger;
import main.Map;

import java.io.IOException;

public class Knight extends Hero {

    public Knight(final int row, final int column, final int id) {
        super(row, column, Constants.KNIGHT_HP, Constants.KNIGHT_EXTRA_HP, "Knight", id);
        abilities.add(new Execute());
        abilities.add(new Slam());
        heroStrategy = new KnightStrategy();
    }

    /**
     * .
     * prin metoda accept, i se atribuie lui Knight particularitatile ingerului
     * care il viziteaza
     *
     * @param angel - ingerul care viziteaza eroul
     */

    @Override
    public void accept(final Angel angel) {
        angel.visit(this);
    }

    /**
     * @param fireblast se da amplificatorul de rasa, multiplier, aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */
    public void receive(final Fireblast fireblast) {
        multiplier = Constants.KNIGHT_MODIFIER_FIREBLAST;
        super.receive(fireblast);
    }

    /**
     * @param ignite se da amplificatorul de rasa, multiplier, aceasta abilitate
     *               se apeleaza metoda de receive din Hero.
     */

    public void receive(final Ignite ignite) {
        multiplier = Constants.KNIGHT_MODIFIER_IGNITE;
        super.receive(ignite);
    }

    /**
     * @param execute se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Execute execute) {
        multiplier = Constants.KNIGHT_MODIFIER_EXECUTE;
        unmodified = false;
        super.receive(execute);
    }

    /**
     * @param slam se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *             se apeleaza metoda de receive din Hero.
     */

    public void receive(final Slam slam) {
        multiplier = Constants.KNIGHT_MODIFIER_SLAM;
        super.receive(slam);
    }

    /**
     * @param drain se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *              se apeleaza metoda de receive din Hero.
     */

    public void receive(final Drain drain) {
        multiplier = Constants.KNIGHT_MODIFIER_DRAIN;
        super.receive(drain);
    }

    /**
     * @param deflect se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Deflect deflect) {
        multiplier = Constants.KNIGHT_MODIFIER_DEFLECT;
        super.receive(deflect);
    }

    /**
     * @param backstab se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                 se apeleaza metoda de receive din Hero.
     */

    public void receive(final Backstab backstab) {
        multiplier = Constants.KNIGHT_MODIFIER_BACKSTAB;
        super.receive(backstab);
    }

    /**
     * @param paralysis se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Paralysis paralysis) {
        multiplier = Constants.KNIGHT_MODIFIER_PARALYSIS;
        super.receive(paralysis);
    }

    /**
     * @return landModifier
     * returneaza modificatorul specific terenului unde are loc lupta
     */

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column)
                == Constants.KNIGHT_LAND_MODIFIER_CHAR) {
            return Constants.KNIGHT_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    /**
     * @throws IOException afiseaza stats-urile jucatorului
     */

    public void print() throws IOException {
        FileLogger out = FileLogger.getLogger();
        if (this.isDead()) {
            out.write("K dead\n");
        } else {
            out.write("K " + level + " " + currentXP + " " + currentHP + " "
                    + row + " " + column + "\n");

        }
    }

}
