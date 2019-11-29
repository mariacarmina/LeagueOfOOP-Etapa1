package com.heroes;

import com.abilities.*;
import com.common.Constants;
import com.main.Map;

public class Pyromancer extends Hero {

    public Pyromancer(int row, int column) {
        super(row, column, Constants.PYROMANCER_HP, Constants.PYROMANCER_EXTRA_HP);
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }

    public void receive(Fireblast fireblast) {
        multiplier = 0.9f;
        super.receive(fireblast);
    }

    public void receive(Ignite ignite) {
        multiplier = 0.9f;
        super.receive(ignite);
    }

    public void receive(Execute execute) {
        multiplier = 1.1f;
        super.receive(execute);
    }

    public void receive(Slam slam) {
        multiplier = 0.9f;
        super.receive(slam);
    }

    public void receive(Drain drain) {
        multiplier = 0.9f;
        super.receive(drain);
    }

    public void receive(Deflect deflect) {
        multiplier = 1.3f;
        super.receive(deflect);
    }

    public void receive(Backstab backstab) {
        multiplier = 1.25f;
        super.receive(backstab);
    }

    public void receive(Paralysis paralysis) {
        multiplier = 1.2f;
        super.receive(paralysis);
    }

    public float getLandModifier() {
        if (Map.getInstance().getField(this.row, this.column) == Constants.PYROMANCER_LAND_MODIFIER_CHAR) {
            return Constants.PYROMANCER_LAND_MODIFIER_BONUS;
        }
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }
}


