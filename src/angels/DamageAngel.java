package angels;

import common.Constants;
import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public class DamageAngel extends Angel {
    public DamageAngel(final int row, final int column) {
        super(row, column);
        this.setAngelType("DamageAngel");
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * DamageAngel ofera un boost al modificatorilor de damage, deci
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     *
     * @param knight - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier()
                + Constants.KNIGHT_DAMAGE_ANGEL_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getId());
        updateObserver(helped);
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * DamageAngel ofera un boost al modificatorilor de damage, deci
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     *
     * @param pyromancer - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier()
                + Constants.PYROMANCER_DAMAGE_ANGEL_MULTIPLIER);
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
     * DamageAngel ofera un boost al modificatorilor de damage, deci
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     *
     * @param rogue - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier()
                + Constants.ROGUE_DAMAGE_ANGEL_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getId());
        updateObserver(helped);
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * DamageAngel ofera un boost al modificatorilor de damage, deci
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     *
     * @param wizard - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier()
                + Constants.WIZARD_DAMAGE_ANGEL_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(), wizard.getId());
        updateObserver(helped);
    }

}
