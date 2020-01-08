package angels;

import common.Constants;
import events.Event;
import events.Helped;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel {
    public SmallAngel(final int row, final int column) {
        super(row, column);
        this.setAngelType("SmallAngel");
    }

    /**
     * .
     * returneaza minimul dintre bonusul de HP primit si
     * diferenta dintre HP-ul curent al eroului si cel maxim per nivel,
     * astfel incat bonusul capatat sa nu depaseasca valoarea maxima a
     * HP-ului specifica fiecarui erou
     *
     * @param increasedAmount - bonusul capatat
     * @param hero            - eroul caruia i se va aplica bonusul
     * @return
     */

    public int heal(final int increasedAmount, final Hero hero) {
        return Math.min(increasedAmount, hero.getMaxHP() - hero.getCurrentHP());
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * SmallAngel ofera un boost al modificatorilor de damage si unul pentru
     * HP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     *
     * @param knight - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier()
                + Constants.KNIGHT_SMALL_ANGEL_MULTIPLIER);
        int increaseHP = heal(Constants.KNIGHT_SMALL_ANGEL_HP, knight);
        knight.setCurrentHP(knight.getCurrentHP() + increaseHP);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(),
                knight.getId());
        updateObserver(helped);
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * SmallAngel ofera un boost al modificatorilor de damage si unul pentru
     * HP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * @param pyromancer - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier()
                + Constants.PYROMANCER_SMALL_ANGEL_MULTIPLIER);
        int increaseHP = heal(Constants.PYROMANCER_SMALL_ANGEL_HP, pyromancer);
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() + increaseHP);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(),
                pyromancer.getId());
        updateObserver(helped);
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * SmallAngel ofera un boost al modificatorilor de damage si unul pentru
     * HP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * @param rogue - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier()
                + Constants.ROGUE_SMALL_ANGEL_MULTIPLIER);
        int increaseHP = heal(Constants.ROGUE_SMALL_ANGEL_HP, rogue);
        rogue.setCurrentHP(rogue.getCurrentHP() + increaseHP);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(),
                rogue.getId());
        updateObserver(helped);
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * SmallAngel ofera un boost al modificatorilor de damage si unul pentru
     * HP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * @param wizard - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier()
                + Constants.WIZARD_SMALL_ANGEL_MULTIPLIER);
        int increaseHP = heal(Constants.WIZARD_SMALL_ANGEL_HP, wizard);
        wizard.setCurrentHP(wizard.getCurrentHP() + increaseHP);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(),
                wizard.getId());
        updateObserver(helped);
    }
}
