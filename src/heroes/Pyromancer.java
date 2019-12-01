package heroes;

import abilities.*;
import common.Constants;
import main.Map;

import java.io.BufferedWriter;
import java.io.IOException;

public class Pyromancer extends Hero {

    public Pyromancer(int row, int column) {
        super(row, column, Constants.PYROMANCER_HP, Constants.PYROMANCER_EXTRA_HP);
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }

    public void receive(Fireblast fireblast) {
        multiplier = Constants.PYROMANCER_MODIFIER_FIREBLAST;
        super.receive(fireblast);
    }

    public void receive(Ignite ignite) {
        multiplier = Constants.PYROMANCER_MODIFIER_IGNITE;
        super.receive(ignite);
    }

    public void receive(Execute execute) {
        multiplier = Constants.PYROMANCER_MODIFIER_EXECUTE;
        super.receive(execute);
    }

    public void receive(Slam slam) {
        multiplier = Constants.PYROMANCER_MODIFIER_SLAM;
        super.receive(slam);
    }

    public void receive(Drain drain) {
        multiplier = Constants.PYROMANCER_MODIFIER_DRAIN;
        super.receive(drain);
    }

    public void receive(Deflect deflect) {
        multiplier = Constants.PYROMANCER_MODIFIER_DEFLECT;
        super.receive(deflect);
    }

    public void receive(Backstab backstab) {
        multiplier = Constants.PYROMANCER_MODIFIER_BACKSTAB;
        super.receive(backstab);
    }

    public void receive(Paralysis paralysis) {
        multiplier = Constants.PYROMANCER_MODIFIER_PARALYSIS;
        super.receive(paralysis);
    }

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column) == Constants.PYROMANCER_LAND_MODIFIER_CHAR) {
            return Constants.PYROMANCER_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    public void print(BufferedWriter out) throws IOException {
        if (this.isDead()) {
            out.write("P " + "dead");
            out.newLine();
        } else {
            out.write("P " + level + " " + currentXP + " " + currentHP + " " + row + " " + column);
            out.newLine();
        }
    }
}


