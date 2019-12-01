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
        multiplier = Constants.KNIGHT_MODIFIER_FIREBLAST;
        super.receive(fireblast);
    }

    public void receive(Ignite ignite) {
        multiplier = Constants.KNIGHT_MODIFIER_IGNITE;
        super.receive(ignite);
    }

    public void receive(Execute execute) {
        multiplier = Constants.KNIGHT_MODIFIER_EXECUTE;
        super.receive(execute);
    }

    public void receive(Slam slam) {
        multiplier = Constants.KNIGHT_MODIFIER_SLAM;
        super.receive(slam);
    }

    public void receive(Drain drain) {
        multiplier = Constants.KNIGHT_MODIFIER_DRAIN;
        super.receive(drain);
    }

    public void receive(Deflect deflect) {
        multiplier = Constants.KNIGHT_MODIFIER_DEFLECT;
        super.receive(deflect);
    }

    public void receive(Backstab backstab) {
        multiplier = Constants.KNIGHT_MODIFIER_BACKSTAB;
        super.receive(backstab);
    }

    public void receive(Paralysis paralysis) {
        multiplier = Constants.KNIGHT_MODIFIER_PARALYSIS;
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
