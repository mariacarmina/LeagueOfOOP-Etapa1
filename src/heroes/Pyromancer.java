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
import main.Map;
import observer.Observer;

import java.io.BufferedWriter;
import java.io.IOException;

public class Pyromancer extends Hero {

    public Pyromancer(final int row, final int column, final int ID) {
        super(row, column, Constants.PYROMANCER_HP, Constants.PYROMANCER_EXTRA_HP, "Pyromancer", ID);
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
        heroStrategy = new PyromancerStrategy();
    }

    @Override
    public void accept(Angel angel) {
        angel.visit(this);
    }

//    @Override
//    public void accept(DamageAngel damageAngel) {
//        damageAngel.visit(this);
//    }
//
//    @Override
//    public void accept(DarkAngel darkAngel) {
//        darkAngel.visit(this);
//    }
//
//    @Override
//    public void accept(Dracula dracula) {
//        dracula.visit(this);
//    }
//
//    @Override
//    public void accept(GoodBoy goodBoy) {
//        goodBoy.visit(this);
//    }
//
//    @Override
//    public void accept(LevelUpAngel levelUpAngel) {
//        levelUpAngel.visit(this);
//    }
//
//    @Override
//    public void accept(LifeGiver lifeGiver) {
//        lifeGiver.visit(this);
//    }
//
//    @Override
//    public void accept(SmallAngel smallAngel) {
//        smallAngel.visit(this);
//    }
//
//    @Override
//    public void accept(Spawner spawner) {
//        spawner.visit(this);
//    }
//
//    @Override
//    public void accept(TheDoomer theDoomer) {
//        theDoomer.visit(this);
//    }
//
//    @Override
//    public void accept(XPAngel xpAngel) {
//        xpAngel.visit(this);
//    }

    /**
     * @param fireblast se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Fireblast fireblast) {
        multiplier = Constants.PYROMANCER_MODIFIER_FIREBLAST;
        super.receive(fireblast);
    }

    /**
     * @param ignite se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *               se apeleaza metoda de receive din Hero.
     */

    public void receive(final Ignite ignite) {
        multiplier = Constants.PYROMANCER_MODIFIER_IGNITE;
        super.receive(ignite);
    }

    /**
     * @param execute se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Execute execute) {
        multiplier = Constants.PYROMANCER_MODIFIER_EXECUTE;
        super.receive(execute);
    }

    /**
     * @param slam se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *             se apeleaza metoda de receive din Hero.
     */

    public void receive(final Slam slam) {
        multiplier = Constants.PYROMANCER_MODIFIER_SLAM;
        super.receive(slam);
    }

    /**
     * @param drain se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *              se apeleaza metoda de receive din Hero.
     */

    public void receive(final Drain drain) {
        multiplier = Constants.PYROMANCER_MODIFIER_DRAIN;
        super.receive(drain);
    }

    /**
     * @param deflect se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Deflect deflect) {
        multiplier = Constants.PYROMANCER_MODIFIER_DEFLECT;
        super.receive(deflect);
    }

    /**
     * @param backstab se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                 se apeleaza metoda de receive din Hero.
     */

    public void receive(final Backstab backstab) {
        multiplier = Constants.PYROMANCER_MODIFIER_BACKSTAB;
        super.receive(backstab);
    }

    /**
     * @param paralysis se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Paralysis paralysis) {
        multiplier = Constants.PYROMANCER_MODIFIER_PARALYSIS;
        super.receive(paralysis);
    }

    /**
     * @return landModifier
     * returneaza modificatorul specific terenului unde are loc lupta
     */

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column)
                == Constants.PYROMANCER_LAND_MODIFIER_CHAR) {
            return Constants.PYROMANCER_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    /**
     * @param out
     * @throws IOException afiseaza stats-urile jucatorului
     */

    public void print(final BufferedWriter out) throws IOException {
        if (this.isDead()) {
            out.write("P " + "dead");
            out.newLine();
        } else {
            out.write("P " + level + " " + currentXP + " " + currentHP + " " + row + " " + column);
            out.newLine();
        }
    }

    @Override
    public void registerObserver(Observer observer) {

    }
}


