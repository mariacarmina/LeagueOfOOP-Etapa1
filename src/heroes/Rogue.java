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


public class Rogue extends Hero {
    public Rogue(final int row, final int column, final int id) {
        super(row, column, Constants.ROGUE_HP, Constants.ROGUE_EXTRA_HP, "Rogue", id);
        abilities.add(new Backstab());
        abilities.add(new Paralysis());
        heroStrategy = new RogueStrategy();
    }

    /**
     * .
     * prin metoda accept, i se atribuie lui Rogue particularitatile ingerului
     * care il viziteaza
     *
     * @param angel - ingerul care viziteaza eroul
     */

    @Override
    public void accept(final Angel angel) {
        angel.visit(this);
    }


    /**
     * @param fireblast se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Fireblast fireblast) {
        multiplier = Constants.ROGUE_MODIFIER_FIREBLAST;
        super.receive(fireblast);
    }

    /**
     * @param ignite se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *               se apeleaza metoda de receive din Hero.
     */

    public void receive(final Ignite ignite) {
        multiplier = Constants.ROGUE_MODIFIER_IGNITE;
        super.receive(ignite);
    }

    /**
     * @param execute se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Execute execute) {
        multiplier = Constants.ROGUE_MODIFIER_EXECUTE;
        super.receive(execute);
    }

    /**
     * @param slam se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *             se apeleaza metoda de receive din Hero.
     */

    public void receive(final Slam slam) {
        multiplier = Constants.ROGUE_MODIFIER_SLAM;
        super.receive(slam);
    }

    /**
     * @param drain se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *              se apeleaza metoda de receive din Hero.
     */

    public void receive(final Drain drain) {
        multiplier = Constants.ROGUE_MODIFIER_DRAIN;
        super.receive(drain);
    }

    /**
     * @param deflect se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Deflect deflect) {
        multiplier = Constants.ROGUE_MODIFIER_DEFLECT;
        super.receive(deflect);
    }

    /**
     * @param backstab se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                 se apeleaza metoda de receive din Hero.
     */

    public void receive(final Backstab backstab) {
        multiplier = Constants.ROGUE_MODIFIER_BACKSTAB;
        super.receive(backstab);
    }

    /**
     * @param paralysis se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Paralysis paralysis) {
        multiplier = Constants.ROGUE_MODIFIER_PARALYSIS;
        super.receive(paralysis);
    }

    /**
     * @return landModifier
     * returneaza modificatorul specific terenului unde are loc lupta
     */

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column)
                == Constants.ROGUE_LAND_MODIFIER_CHAR) {
            return Constants.ROGUE_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    /**
     * @throws IOException afiseaza stats-urile jucatorului
     */

    public void print() throws IOException {
        FileLogger out = FileLogger.getLogger();
        if (this.isDead()) {
            out.write("R dead\n");
        } else {
            out.write("R " + level + " " + currentXP + " " + currentHP + " "
                    + row + " " + column + "\n");

        }
    }
}
