package angels;

import common.Constants;
import events.BackToLife;
import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel {
    public Spawner(final int row, final int column) {
        super(row, column);
        this.setAngelType("Spawner");
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * Spawner ofera sansa unui jucator de a se intoarce inapoi in joc daca acesta e mort
     * deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si backToLife.
     *
     * @param knight - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Knight knight) {
        if (knight.isDead()) {
            knight.setCurrentHP(Constants.KNIGHT_SPAWNER_HP);
            Event helped = new Helped(this.getAngelType(), knight.getHeroType(),
                    knight.getId());
            updateObserver(helped);
            Event backToLife = new BackToLife(knight.getHeroType(), knight.getId());
            updateObserver(backToLife);
        }
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * Spawner ofera sansa unui jucator de a se intoarce inapoi in joc daca acesta e mort
     * deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si backToLife.
     * @param pyromancer- eroul pe care il viziteaza
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            pyromancer.setCurrentHP(Constants.PYROMANCER_SPAWNER_HP);
            Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(),
                    pyromancer.getId());
            updateObserver(helped);
            Event backToLife = new BackToLife(pyromancer.getHeroType(),
                    pyromancer.getId());
            updateObserver(backToLife);
        }
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * Spawner ofera sansa unui jucator de a se intoarce inapoi in joc daca acesta e mort
     * deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si backToLife.
     * @param rogue - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Rogue rogue) {
        if (rogue.isDead()) {
            rogue.setCurrentHP(Constants.ROGUE_SPAWNER_HP);
            Event helped = new Helped(this.getAngelType(), rogue.getHeroType(),
                    rogue.getId());
            updateObserver(helped);
            Event backToLife = new BackToLife(rogue.getHeroType(), rogue.getId());
            updateObserver(backToLife);
        }
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * Spawner ofera sansa unui jucator de a se intoarce inapoi in joc daca acesta e mort
     * deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si backToLife.
     * @param wizard- eroul pe care il viziteaza
     */

    @Override
    public void visit(final Wizard wizard) {
        if (wizard.isDead()) {
            wizard.setCurrentHP(Constants.WIZARD_SPAWNER_HP);
            Event helped = new Helped(this.getAngelType(), wizard.getHeroType(),
                    wizard.getId());
            updateObserver(helped);
            Event backToLife = new BackToLife(wizard.getHeroType(), wizard.getId());
            updateObserver(backToLife);
        }
    }
}
