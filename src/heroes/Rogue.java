package heroes;

import abilities.*;
import common.Constants;
import main.Map;

import java.io.BufferedWriter;
import java.io.IOException;


public class Rogue extends Hero {
    public Rogue(int row, int column) {
        super(row, column, Constants.ROGUE_HP, Constants.ROGUE_EXTRA_HP);
        abilities.add(new Backstab());
        abilities.add(new Paralysis());
    }

    public void receive(Fireblast fireblast) {
        multiplier = 0.8f;
        super.receive(fireblast);
    }

    public void receive(Ignite ignite) {
        multiplier = 0.8f;
        super.receive(ignite);
    }

    public void receive(Execute execute) {
        multiplier = 1.15f;
        super.receive(execute);
    }

    public void receive(Slam slam) {
        multiplier = 0.8f;
        super.receive(slam);
    }

    public void receive(Drain drain) {
        multiplier = 0.8f;
        super.receive(drain);
    }

    public void receive(Deflect deflect) {
        multiplier = 1.2f;
        super.receive(deflect);
    }

    public void receive(Backstab backstab) {
        multiplier = 1.2f;
        super.receive(backstab);
    }

    public void receive(Paralysis paralysis) {
        multiplier = 0.9f;
        super.receive(paralysis);
    }


    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column) == Constants.ROGUE_LAND_MODIFIER_CHAR) {
            return Constants.ROGUE_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    public void print(BufferedWriter out) throws IOException {
        if (this.isDead()) {
            out.write("R " + "dead");
            out.newLine();
        } else {
            out.write("R " + level + " " + currentXP + " " + currentHP + " " + row + " " + column);
            out.newLine();
        }
    }

}
