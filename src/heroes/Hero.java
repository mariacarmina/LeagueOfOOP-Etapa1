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
import angels.Angel;
import common.Constants;
import events.Event;
import events.Kill;
import events.LevelUp;
import observer.Observer;
import observer.Subject;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Hero implements Subject {
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
    protected boolean unmodified;
    protected float angelMultiplier;
    protected float strategyMultiplier;
    protected HeroStrategy heroStrategy;
    protected String heroType;
    protected int id;
    protected Observer observer;

    public Hero(final int row, final int column, final int baseHP, final int perLevelHP,
                final String heroType, final int id) {
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
        this.angelMultiplier = 0f;
        this.strategyMultiplier = 0f;
        this.heroType = heroType;
        this.id = id;
        this.unmodified = true;
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
        Event levelUp = new LevelUp(heroType, id, level);
        updateObserver(levelUp);
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
     *                  si de amplificatorul de rasa , modificatorul dat de inger(daca exista) si
     *                  modificatorul de strategie(daca exista)
     *                  (takenDamage)
     */

    public void receive(final Fireblast fireblast) {
        baseTakenDamage += Math.round(fireblast.getDamage());
        takenDamage += Math.round((multiplier + fireblast.strategyMultiplier
                + fireblast.angelMultiplier) * Math.round(fireblast.getDamage()));

    }

    /**
     * @param ignite primeste ca paramentru abilitatea cu care victima a fost atacata,
     *               calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *               se actualizeaza damage-ul calculat anterior in functie
     *               si de amplificatorul de rasa(takenDamage).
     *               se seteaza efectul de overtime specific abilitatii Ignite,
     *               specificandu-se numarul rundelor si damage-ul per runda amplificat
     *               si de modificatorul de rasa, modificatorul dat de inger(daca exista) si
     *               modificatorul de strategie(daca exista)(takenDamage)
     */

    public void receive(final Ignite ignite) {
        baseTakenDamage += Math.round(ignite.getDamage());
        takenDamage += Math.round(Math.round(ignite.getDamage()) * (multiplier
                + ignite.strategyMultiplier + ignite.angelMultiplier));
        setEffect(2, Math.round(Math.round(ignite.getRoundDamage())
                * (multiplier + ignite.strategyMultiplier
                + ignite.angelMultiplier)), false);
    }

    /**
     * @param execute daca HP-ul victimei este cel mult egal cu limita de viata
     *                impusa abilitatii Execute,atunci damage-ul este egal cu HP-ul victimei,
     *                pentru ca aceast asa fie omorata.
     *                altfel, se calculeaza damage-ul fara modificatori de rasa (baseTakenDamage)
     *                se actualizeaza damage-ul calculat anterior in functie si
     *                de amplificatorul de rasa, modificatorul dat de inger(daca exista) si
     *                modificatorul de strategie(daca exista)(takenDamage)
     */
    public void receive(final Execute execute) {
        if (currentHP <= (int) execute.getHPLimit()) {
            baseTakenDamage += currentHP;
            takenDamage += currentHP;
        } else {
            float newAngelMultiplier = (unmodified
                    ? execute.strategyMultiplier + execute.angelMultiplier : 0.0f);
            baseTakenDamage += Math.round(execute.getDamage());
            takenDamage += Math.round((multiplier
                    + newAngelMultiplier) * execute.getDamage());
        }
    }

    /**
     * @param slam primeste ca paramentru abilitatea cu care victima a fost atacata,
     *             calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *             se actualizeaza damage-ul calculat anterior in functie si de
     *             amplificatorul de rasa, modificatorul dat de inger(daca exista) si
     *             modificatorul de strategie(daca exista)(takenDamage)
     *             se seteaza efectul de overtime specific abilitatii Slam,
     *             specificandu-se numarul rundelor si incapacitatea miscarii adversarului
     */

    public void receive(final Slam slam) {
        baseTakenDamage += Math.round(slam.getDamage());
        takenDamage += Math.round(
                (multiplier + slam.strategyMultiplier + slam.angelMultiplier) * slam.getDamage());
        setEffect(1, 0, true);
    }

    /**
     * @param drain se calculeaza HP-ul de baza al victimei conform cerintei si
     *              apoi se calculeaza damage-ul fara modificatori de rasa (baseTakenDamage)
     *              se actualizeaza damage-ul calculat anterior in functie si
     *              de amplificatorul de rasa, modificatorul dat de inger(daca exista) si
     *              modificatorul de strategie(daca exista)(takenDamage)
     */
    public void receive(final Drain drain) {
        float drainHP = getDrainHP();
        baseTakenDamage += Math.round(drain.getDamage(drainHP));
        float effectivePercent = (multiplier + drain.strategyMultiplier + drain.angelMultiplier);
        takenDamage += Math.round(drain.getDamagePercent(drainHP, effectivePercent));
    }

    /**
     * @param deflect primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                se actualizeaza damage-ul calculat anterior in functie si
     *                de amplificatorul de rasa, modificatorul dat de inger(daca exista) si
     *                modificatorul de strategie(daca exista)(takenDamage)
     */

    public void receive(final Deflect deflect) {
        baseTakenDamage += Math.round(deflect.getDamage());
        takenDamage += Math.round((multiplier + deflect.strategyMultiplier
                + deflect.angelMultiplier) * deflect.getDamage());
    }

    /**
     * @param backstab primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                 calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                 se actualizeaza damage-ul calculat anterior in functie si
     *                 de amplificatorul de rasa, modificatorul dat de inger(daca exista) si
     *                 modificatorul de strategie(daca exista)(takenDamage)
     */

    public void receive(final Backstab backstab) {
        baseTakenDamage += Math.round(backstab.getDamage());
        takenDamage += Math.round((multiplier - Constants.ESTIMATION + backstab.strategyMultiplier
                + backstab.angelMultiplier) * backstab.getDamage());
    }

    /**
     * @param paralysis primeste ca paramentru abilitatea cu care victima a fost atacata,
     *                  calculandu-se damage-ul fara modificatori de rasa (baseTakenDamage)
     *                  se actualizeaza damage-ul calculat anterior in functie si
     *                  de amplificatorul de rasa, modificatorul dat de inger(daca exista) si
     *                  modificatorul de strategie(daca exista)(takenDamage)
     *                  se seteaza efectul de overtime specific abilitatii Paralysis,
     *                  specificandu-se numarul rundelor si damage-ul per runda amplificat
     *                  si de modificatorul de rasa si incapacitatea miscarii adversarului
     */

    public void receive(final Paralysis paralysis) {
        baseTakenDamage += Math.round(paralysis.getDamage());
        takenDamage += Math.round((multiplier - Constants.ESTIMATION + paralysis.strategyMultiplier
                + paralysis.angelMultiplier) * paralysis.getDamage());
        setEffect(paralysis.getRounds(), Math.round(
                (multiplier - Constants.ESTIMATION + paralysis.strategyMultiplier
                        + paralysis.angelMultiplier) * paralysis.getRoundDamage()),
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
     * .
     * informeaza observer-ul in privinta unui nou eveniment
     *
     * @param event
     */

    @Override
    public void updateObserver(final Event event) {
        observer.update(event);
    }

    /**
     * actualizeaza HP-ul in functie de damage-ul primit in urma unei lupte.
     * daca HP-ul devine mai mic sau egal cu 0, atunci victima a murit.
     */
    public void takeDamage(final Hero killer) {
        currentHP -= takenDamage;
        if (currentHP <= 0) {
            Event kill = new Kill(this.getHeroType(), this.getId(),
                    killer.getHeroType(), killer.getId());
            updateObserver(kill);
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
     * @return verifica daca doi eroi se afla pe acelasi teren.
     */

    public boolean isHere(final Hero h1) {
        return (this.row == h1.row) && (this.column == h1.column);
    }

    /**
     * verifica daca un inger se afla la aceleasi coordonate cu un erou.
     * @param angel - ingerul
     * @return
     */

    public boolean isAngelHere(final Angel angel) {
        return (this.row == angel.getRow()) && (this.column == angel.getColumn());
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
     * getter pentru coloana.
     */

    public int getColumn() {
        return column;
    }

    /**
     * returneaza HP-ul necesar metodei receive specifica abilitatii.
     * Drain
     * @return
     */

    public float getDrainHP() {
        return Math.min(Constants.MULTIPLIER_HP_DRAIN * getMaxHP(), currentHP);
    }

    /**.
     * @throws IOException afisarea stats-urilor atribuita fiecarui jucator
     */
    public abstract void print() throws IOException;

    /**.
     * getter pentru angelMultiplier.
     * @return
     */

    public float getAngelMultiplier() {
        return angelMultiplier;
    }

    /**
     * .
     * setter pentru angelMultiplier
     *
     * @param angelMultiplier
     */

    public void setAngelMultiplier(final float angelMultiplier) {
        this.angelMultiplier = angelMultiplier;
    }

    /**
     * getter pentru HP-ul curent.
     * @return
     */

    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * setter pentru HP-ul curent.
     *
     * @param currentHP
     */

    public void setCurrentHP(final int currentHP) {
        this.currentHP = currentHP;
        if (currentHP > 0) {
            dead = false;
        }
    }

    /**.
     * metoda kill() declara eroul ca fiind mort
     */

    public void kill() {
        this.dead = true;
    }

    /**
     * getter pentru XP curent.
     * @return
     */

    public int getCurrentXP() {
        return currentXP;
    }

    /**
     * setter pentru XP curent.
     *
     * @param currentXP
     */

    public void setCurrentXP(final int currentXP) {
        this.currentXP = currentXP;
    }

    /**
     * aplicarea lui Visitor Pattern in toate subclasele.
     *
     * @param angel - ingerul care viziteaza eroul
     * @throws IOException
     */

    public abstract void accept(Angel angel) throws IOException;

    /**
     * getter pentru multiplicatorul de strategie.
     * @return
     */

    public float getStrategyMultiplier() {
        return strategyMultiplier;
    }

    /**
     * setter pentru multiplicatorul de strategie.
     *
     * @param strategyMultiplier
     */

    public void setStrategyMultiplier(final float strategyMultiplier) {
        this.strategyMultiplier = strategyMultiplier;
    }

    /**
     * heroStrategy este de tip HeroStrategy si reprezinta strategia aleasa.
     */

    public void chooseStrategy() {
        heroStrategy.choose(this);
    }

    /**
     * getter pentru tipul de erou.
     * @return
     */

    public String getHeroType() {
        return heroType;
    }

    /**
     * getter pentru id-ul eroului.
     * @return
     */

    public int getId() {
        return id;
    }

    /**
     * setter pentru observer.
     * metoda existenta in interfata Subject
     * @param observer
     */

    @Override
    public void registerObserver(final Observer observer) {
        this.observer = observer;
    }
}

