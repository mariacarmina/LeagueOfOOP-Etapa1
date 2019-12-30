package heroes;


import abilities.Backstab;
import abilities.Deflect;
import abilities.Drain;
import abilities.Execute;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Paralysis;
import abilities.Slam;
import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;
import common.Constants;
import main.Map;

import java.io.BufferedWriter;
import java.io.IOException;

public class Wizard extends Hero {
    public Wizard(final int row, final int column) {
        super(row, column, Constants.WIZARD_HP, Constants.WIZARD_EXTRA_HP);
        abilities.add(new Drain());
        abilities.add(new Deflect());
        heroStrategy = new WizardStrategy();
    }

    @Override
    public void accept(DamageAngel damageAngel) {
        damageAngel.visit(this);
    }

    @Override
    public void accept(DarkAngel darkAngel) {
        darkAngel.visit(this);
    }

    @Override
    public void accept(Dracula dracula) {
        dracula.visit(this);
    }

    @Override
    public void accept(GoodBoy goodBoy) {
        goodBoy.visit(this);
    }

    @Override
    public void accept(LevelUpAngel levelUpAngel) {
        levelUpAngel.visit(this);
    }

    @Override
    public void accept(LifeGiver lifeGiver) {
        lifeGiver.visit(this);
    }

    @Override
    public void accept(SmallAngel smallAngel) {
        smallAngel.visit(this);
    }

    @Override
    public void accept(Spawner spawner) {
        spawner.visit(this);
    }

    @Override
    public void accept(TheDoomer theDoomer) {
        theDoomer.visit(this);
    }

    @Override
    public void accept(XPAngel xpAngel) {
        xpAngel.visit(this);
    }

    /**
     * @param fireblast se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Fireblast fireblast) {
        multiplier = Constants.WIZARD_MODIFIER_FIREBLAST;
        super.receive(fireblast);
    }

    /**
     * @param ignite se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *               se apeleaza metoda de receive din Hero.
     */

    public void receive(final Ignite ignite) {
        multiplier = Constants.WIZARD_MODIFIER_IGNITE;
        super.receive(ignite);
    }

    /**
     * @param execute se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                se apeleaza metoda de receive din Hero.
     */

    public void receive(final Execute execute) {
        multiplier = Constants.WIZARD_MODIFIER_EXECUTE;
        super.receive(execute);
    }

    /**
     * @param slam se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *             se apeleaza metoda de receive din Hero.
     */

    public void receive(final Slam slam) {
        multiplier = Constants.WIZARD_MODIFIER_SLAM;
        super.receive(slam);
    }

    /**
     * @param drain se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *              se apeleaza metoda de receive din Hero.
     */

    public void receive(final Drain drain) {
        multiplier = Constants.WIZARD_MODIFIER_DRAIN;
        super.receive(drain);
    }

    /**
     * @param deflect nu se aplica jucatorului de tip Wizard
     */

    public void receive(final Deflect deflect) {
    }

    /**
     * @param backstab se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                 se apeleaza metoda de receive din Hero.
     */

    public void receive(final Backstab backstab) {
        multiplier = Constants.WIZARD_MODIFIER_BACKSTAB;
        super.receive(backstab);
    }

    /**
     * @param paralysis se da amplificatorul de rasa, multiplier, pentru aceasta abilitate
     *                  se apeleaza metoda de receive din Hero.
     */

    public void receive(final Paralysis paralysis) {
        multiplier = Constants.WIZARD_MODIFIER_PARALYSIS;
        super.receive(paralysis);
    }

    /**
     * @return landModifier
     * returneaza modificatorul specific terenului unde are loc lupta
     */

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column)
                == Constants.WIZARD_LAND_MODIFIER_CHAR) {
            return Constants.WIZARD_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    /**
     * @param out
     * @throws IOException afiseaza stats-urile jucatorului
     */

    public void print(final BufferedWriter out) throws IOException {
        if (this.isDead()) {
            out.write("W " + "dead");
            out.newLine();
        } else {
            out.write("W " + level + " " + currentXP + " " + currentHP + " " + row + " " + column);
            out.newLine();
        }
    }

}



