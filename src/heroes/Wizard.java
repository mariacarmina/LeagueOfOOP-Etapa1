package heroes;


import abilities.*;
import common.Constants;
import main.Map;

import java.io.BufferedWriter;
import java.io.IOException;

public class Wizard extends Hero {
    public Wizard(int row, int column) {
        super(row, column, Constants.WIZARD_HP, Constants.WIZARD_EXTRA_HP);
        abilities.add(new Drain());
        abilities.add(new Deflect());
    }

    public void receive(Fireblast fireblast) {
        multiplier = 1.05f;
        super.receive(fireblast);
    }

    public void receive(Ignite ignite) {
        multiplier = 1.05f;
        super.receive(ignite);
    }

    public void receive(Execute execute) {
        multiplier = 0.8f;
        super.receive(execute);
    }

    public void receive(Slam slam) {
        multiplier = 1.05f;
        super.receive(slam);
    }

    public void receive(Drain drain) {
        multiplier = 1.05f;
        super.receive(drain);
    }

    public void receive(Deflect deflect) {
    }

    public void receive(Backstab backstab) {
        multiplier = 1.25f;
        super.receive(backstab);
    }

    public void receive(Paralysis paralysis) {
        multiplier = 1.25f;
        super.receive(paralysis);
    }

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column) == Constants.WIZARD_LAND_MODIFIER_CHAR) {
            return Constants.WIZARD_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    public void print(BufferedWriter out) throws IOException {
        if (this.isDead()) {
            out.write("W " + "dead");
            out.newLine();
        } else {
            out.write("W " + level + " " + currentXP + " " + currentHP + " " + row + " " + column);
            out.newLine();
        }
    }

}



