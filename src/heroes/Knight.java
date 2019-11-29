package heroes;

import abilities.*;
import common.Constants;
import main.Map;

import java.io.BufferedWriter;
import java.io.IOException;

public class Knight extends Hero {
    public Knight(int row, int column) {
        super(row, column, Constants.KNIGHT_HP, Constants.KNIGHT_EXTRA_HP);
        abilities.add(new Execute());
        abilities.add(new Slam());
    }

    public void receive(Fireblast fireblast) {
        multiplier = 1.2f;
        super.receive(fireblast);
    }

    public void receive(Ignite ignite) {
        multiplier = 1.2f;
        super.receive(ignite);
    }

    public void receive(Execute execute) {
        multiplier = 1f;
        super.receive(execute);
    }

    public void receive(Slam slam) {
        multiplier = 1.2f;
        super.receive(slam);
    }

    public void receive(Drain drain) {
        multiplier = 1.2f;
        super.receive(drain);
    }

    public void receive(Deflect deflect) {
        multiplier = 1.4f;
        super.receive(deflect);
    }

    public void receive(Backstab backstab) {
        multiplier = 0.9f;
        super.receive(backstab);
    }

    public void receive(Paralysis paralysis) {
        multiplier = 0.8f;
        super.receive(paralysis);
    }

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column) == Constants.KNIGHT_LAND_MODIFIER_CHAR) {
            return Constants.KNIGHT_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    public void print(BufferedWriter out) throws IOException {
        if (this.isDead()) {
            out.write("K " + "dead");
            out.newLine();
        } else {
            out.write("K " + level + " " + currentXP + " " + currentHP + " " + row + " " + column);
            out.newLine();
        }
    }
}
