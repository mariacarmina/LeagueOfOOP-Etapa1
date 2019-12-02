package heroes;


import abilities.Ability;
import abilities.Backstab;
import abilities.Deflect;
import abilities.Drain;
import abilities.Execute;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Paralysis;
import abilities.Slam;
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

    public Hero(final int row, final int column, final int baseHP, final int perLevelHP) {
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

    /**
     * @param move aceasta metoda realizeaza mutarea jucatorului pe harta
     */


    public void moveHero(final char move) {
        if (move == Constants.UP) {
            row--;
        } else if (move == Constants.DOWN) {
            row++;
        } else if (move == Constants.LEFT) {
            column--;
        } else if (move == Constants.RIGHT) {
            column++;
        }
    }

    /**
     * @param remainingRounds
     * @param damageOvertime
     * @param stunned         setter pentru abilitatile cu efect de overtime
     */

    public void setEffect(final int remainingRounds, final int damageOvertime,
                          final boolean stunned) {
        this.remainingRounds = remainingRounds;
        this.damageOvertime = damageOvertime;
        this.stunned = stunned;
    }

    /**
     * in cazul in care avem abilitate cu efect overtime, numarul rundelor se vor scadea,
     * iar HP-ul victimei va scadea odata cu damage-ul specific abilitatii overtime.
     * in schimb, daca victima moare, am ales sa folosesc o variabila care imi indica
     * daca a murit sau nu (dead).
     */

    public void sufferEffect() {
        if (remainingRounds != 0) {
            currentHP -= damageOvertime;
            if (currentHP <= 0) {
                dead = true;
            }
            remainingRounds--;
        }
    }

    /**
     * @return maxHP
     * reinnoieste valoarea de HP cand acesta trece la un nou nivel, aplicandu-se bonusul
     * specific pentru HP-ul fiecarui jucator.
     * pentru nivelul 0, aceasta metoda va returna HP-ul de baza (baseHP) pentru fiecare jucator
     */

    public int getMaxHP() {
        return baseHP + level * perLevelHP;
    }

    /**
     * @return dead
     * verifica daca un jucator a murit
     */

    public boolean isDead() {
        return dead;
    }

    /**
     * @return stunned && remainingRounds > 0
     * verifica daca victima este imobilizata pentru mai multe runde
     */

    public boolean isStunned() {
        return stunned && remainingRounds > 0;
    }

    /**
     * @return pragXP
     * aceasta retuneaza pragul de XP de care are nevoie un jucator sa avanseze in nivel
     */

    public int needToLevel() {
        return Constants.XP_LVL_1 + level * Constants.PER_LEVEL_XP;
    }

    /**
     * se incrementeaza nivelul si se actualizeaza HP-ul jucatorului la maxim.
     */

    public void levelUp() {
        level++;
        currentHP = getMaxHP();
    }

    /**
     * @param defeatedLevel se reactualizeaza XP-ul invingatorului
     *                      daca acesta depaseste pragul, va avansa direct la nivelul
     *                      corespunzator XP-ului sau
     */

    public void gainXP(final int defeatedLevel) {
        currentXP += Math.max(0,
                Constants.XP_WINNER - (level - defeatedLevel) * Constants.MULTIPLIER_XP_WINNER);
        while (currentXP >= needToLevel()) {
            levelUp();
        }
    }

    /**
     * @param fireblast primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                  calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                  se actualizeaza damage-ul calculat anterior in functie
     *                  si de amplificatorul de rasa
     *                  (takenDamage)
     */

    public void receive(final Fireblast fireblast) {
        baseTakenDamage += Math.round(fireblast.getDamage());
        takenDamage += Math.round(multiplier * fireblast.getDamage());
    }

    /**
     * @param ignite primeste ca paramentru abilitatea cu care victima a fost atacata,
     *               calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *               se actualizeaza damage-ul calculat anterior in functie
     *               si de amplificatorul de rasa(takenDamage).
     *               se seteaza efectul de overtime specific abilitatii Ignite,
     *               specificandu-se numarul rundelor si damage-ul per runda amplificat
     *               si de modificatorul de rasa.
     */

    public void receive(final Ignite ignite) {
        baseTakenDamage += Math.round(ignite.getDamage());
        takenDamage += Math.round(multiplier * ignite.getDamage());
        setEffect(2, Math.round(multiplier * ignite.getRoundDamage()), false);
    }

    /**
     * @param execute daca HP-ul victimei este cel mult egal cu limita de viata
     *                impusa abilitatii Execute,atunci damage-ul este egal cu HP-ul victimei,
     *                pentru ca aceast asa fie omorata.
     *                altfel, se calculeaza damage-ul fara modificatori de rasa (baseTakenDamage)
     *                se actualizeaza damage-ul calculat anterior in functie si
     *                de amplificatorul de rasa(takenDamage)
     */
    public void receive(final Execute execute) {
        if (currentHP <= (int) execute.getHPLimit()) {
            baseTakenDamage += currentHP;
            takenDamage += currentHP;
        } else {
            baseTakenDamage += Math.round(execute.getDamage());
            takenDamage += Math.round(multiplier * execute.getDamage());
        }
    }

    /**
     * @param slam primeste ca paramentru abilitatea cu care victima a fost atacata,
     *             calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *             se actualizeaza damage-ul calculat anterior in functie si de
     *             amplificatorul de rasa(takenDamage)
     *             se seteaza efectul de overtime specific abilitatii Slam,
     *             specificandu-se numarul rundelor si incapacitatea miscarii adversarului
     */

    public void receive(final Slam slam) {
        baseTakenDamage += Math.round(slam.getDamage());
        takenDamage += Math.round(multiplier * slam.getDamage());
        setEffect(1, 0, true);
    }

    /**
     * @param drain se calculeaza HP-ul de baza al victimei conform cerintei si
     *              apoi se calculeaza damage-ul fara modificatori de rasa (baseTakenDamage)
     *              se actualizeaza damage-ul calculat anterior in functie si
     *              de amplificatorul de rasa(takenDamage)
     */
    public void receive(final Drain drain) {
        float drainHP = Math.min(Constants.MULTIPLIER_HP_DRAIN * getMaxHP(), currentHP);
        baseTakenDamage += Math.round(drain.getDamage(drainHP));
        takenDamage += Math.round(multiplier * drain.getDamage(drainHP));
    }

    /**
     * @param deflect primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                se actualizeaza damage-ul calculat anterior in functie si
     *                de amplificatorul de rasa(takenDamage)
     */

    public void receive(final Deflect deflect) {
        baseTakenDamage += Math.round(deflect.getDamage());
        takenDamage += Math.round(multiplier * deflect.getDamage());
    }

    /**
     * @param backstab primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                 calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                 se actualizeaza damage-ul calculat anterior in functie si
     *                 de amplificatorul de rasa(takenDamage)
     */

    public void receive(final Backstab backstab) {
        baseTakenDamage += Math.round(backstab.getDamage());
        takenDamage += Math.round(multiplier * backstab.getDamage());
    }

    /**
     * @param paralysis primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                  calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                  se actualizeaza damage-ul calculat anterior in functie si
     *                  de amplificatorul de rasa(takenDamage)
     *                  se seteaza efectul de overtime specific abilitatii Paralysis,
     *                  specificandu-se numarul rundelor si damage-ul per runda amplificat
     *                  si de modificatorul de rasa si incapacitatea miscarii adversarului
     */

    public void receive(final Paralysis paralysis) {
        baseTakenDamage += Math.round(paralysis.getDamage());
        takenDamage += Math.round(multiplier * paralysis.getDamage());
        setEffect(paralysis.getRounds(), Math.round(multiplier * paralysis.getRoundDamage()),
                true);
    }

    /**
     * se reseteaza damage-urile la 0.
     */

    public void resetFight() {
        takenDamage = 0;
        baseTakenDamage = 0;
    }

    /**
     * actualizeaza HP-ul in functie de damage-ul primit in urma unei lupte.
     * daca HP-ul devine mai mic sau egal cu 0, atunci victima a murit.
     */

    public void takeDamage() {
        currentHP -= takenDamage;
        if (currentHP <= 0) {
            dead = true;
        }
    }

    /**
     * @return level
     * getter pentru nivel
     */

    public int getLevel() {
        return level;
    }

    /**
     * @param h1
     * @return verifica daca doi eroi se afla pe acelasi teren
     */

    public boolean isHere(final heroes.Hero h1) {
        return (this.row == h1.row) && (this.column == h1.column);
    }

    /**
     * @return landModifier
     * aceasta metoda este suprascrisa in fiecare clasa ce mosteneste Hero
     * daca o lupta se desfasoara pe un anumit teren ce poate oferi un bonus
     * in aplicarea abilitatilor pentru un anumit jucator,
     * atunci se returneaza amplificatorul respectiv
     * daca insa, se desfasoara pe un teren ce nu ofera niciunuia dintre jucatori,
     * atunci se va returna valoarea default care este 1f.
     */
    public float getLandModifier() {
        return Constants.STANDARD_LAND_MODIFIER_BONUS;
    }

    /**
     * @return abilities
     * getter pentru vectorul de abilitati
     */

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    /**
     * @return baseTakenDamage
     * getter pentru damage-ul fara modificatori de rasa
     */

    public int getBaseTakenDamage() {
        return baseTakenDamage;
    }

    /**
     * @return row
     * getter pentru linie
     */

    public int getRow() {
        return row;
    }

    /**
     * @return column
     * getter pentru coloana
     */

    public int getColumn() {
        return column;
    }

    /**
     * @param out
     * @throws IOException afisarea stats-urilor atribuita fiecarui jucator
     */
    public abstract void print(BufferedWriter out) throws IOException;
}

