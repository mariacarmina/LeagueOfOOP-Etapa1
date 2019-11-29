package heroes;


import abilities.*;
import common.Constants;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Hero {
    protected int row;
    protected int column;
    protected int currentHP;
    protected int baseHP;
    protected int level;
    protected int perLevelHP;
    protected int remainingRounds;
    protected int damageOvertime;
    protected boolean stunned;
    protected boolean dead;
    protected int currentXP;
    protected int takenDamage;
    protected int baseTakenDamage;
    protected ArrayList<Ability> abilities;
    protected float multiplier;

    public Hero(int row, int column, int baseHP, int perLevelHP) {
        this.row = row;
        this.column = column;
        this.baseHP = baseHP;
        this.perLevelHP = perLevelHP;
        this.remainingRounds = 0;
        this.damageOvertime = 0;
        this.stunned = false;
        this.currentXP = 0;
        this.currentHP = this.getMaxHP();
        this.level = 0;
        this.dead = false;
        this.takenDamage = 0;
        this.baseTakenDamage = 0;
        this.abilities = new ArrayList<Ability>();
    }


    public void moveHero(char move) {
        if (move == 'U') {
            row--;
        } else if (move == 'D') {
            row++;
        } else if (move == 'L') {
            column--;
        } else if (move == 'R') {
            column++;
        }
    }

    public void setEffect(int remainingRounds, int damageOvertime, boolean stunned) {
        this.remainingRounds = remainingRounds;
        this.damageOvertime = damageOvertime;
        this.stunned = stunned;
    }

    public void sufferEffect() {
        if (remainingRounds != 0) {
            currentHP -= damageOvertime;
            if (currentHP <= 0) {
                dead = true;
            }
            remainingRounds--;
        }
    }

    public int getMaxHP() {
        return baseHP + level * perLevelHP;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isStunned() {
        return stunned && remainingRounds > 0;
    }

    public int needToLevel() {
        return 250 + level * 50;
    }

    public void levelUp() {
        level++;
        currentHP = getMaxHP();
    }

    public void gainXP(int defeatedLevel) {
        currentXP += Math.max(0, 200 - (level - defeatedLevel) * 40);
        while (currentXP >= needToLevel()) {
            levelUp();
        }
    }

    public void receive(Fireblast fireblast) {
        baseTakenDamage += Math.round(fireblast.getDamage());
        takenDamage += Math.round(multiplier * fireblast.getDamage());
    }

    public void receive(Ignite ignite) {
        baseTakenDamage += Math.round(ignite.getDamage());
        takenDamage += Math.round(multiplier * ignite.getDamage());
        setEffect(2, Math.round(multiplier * ignite.getRoundDamage()), false);
    }
    public void receive(Execute execute) {
        if (currentHP <= (int) execute.getHPLimit()) {
            baseTakenDamage += currentHP;
            takenDamage += currentHP;
        } else {
            baseTakenDamage += Math.round(execute.getDamage());
            takenDamage += Math.round(multiplier * execute.getDamage());
        }
    }

    public void receive(Slam slam) {
        baseTakenDamage += Math.round(slam.getDamage());
        takenDamage += Math.round(multiplier * slam.getDamage());
        setEffect(1, 0, true);
    }

    public void receive(Drain drain) {
        float drainHP = Math.min(0.3f * getMaxHP(), currentHP);
        baseTakenDamage += Math.round(drain.getDamage(drainHP));
        takenDamage += Math.round(multiplier * drain.getDamage(drainHP));
    }

    public void receive(Deflect deflect) {
        baseTakenDamage += Math.round(deflect.getDamage());
        takenDamage += Math.round(multiplier * deflect.getDamage());
    }

    public void receive(Backstab backstab) {
        baseTakenDamage += Math.round(backstab.getDamage());
        takenDamage += Math.round(multiplier * backstab.getDamage());
    }

    public void receive(Paralysis paralysis) {
        baseTakenDamage += Math.round(paralysis.getDamage());
        takenDamage += Math.round(multiplier * paralysis.getDamage());
        setEffect(paralysis.getRounds(), Math.round(multiplier * paralysis.getRoundDamage()), true);
    }

    public void resetFight() {
        takenDamage = 0;
        baseTakenDamage = 0;
    }

    public void takeDamage() {
        currentHP -= takenDamage;
        if (currentHP <= 0)
            dead = true;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHere(Hero h1) {
        return (this.row == h1.row) && (this.column == h1.column);
    }

    public float getLandModifier() {
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public int getBaseTakenDamage() {
        return baseTakenDamage;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public abstract void print(BufferedWriter out) throws IOException;
}

