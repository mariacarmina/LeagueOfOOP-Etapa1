package angels;

import common.Constants;
import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel extends Angel {
    public XPAngel(final int row, final int column) {
        super(row, column);
        this.setAngelType("XPAngel");
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * XPAngel ofera un boost pentru XP, deci adminul
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * daca, in urma boost-ului primit, eroul avanseaza la un nou nivel
     * se va mai adauga evenimentul de LevelUp, prezent in metoda levelUp()
     * din clasa abstracta Hero.
     *
     * @param knight - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Knight knight) {
        knight.setCurrentXP(knight.getCurrentXP() + Constants.KNIGHT_BONUS_XP);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(),
                knight.getId());
        updateObserver(helped);
        while (knight.getCurrentXP() >= knight.needToLevel()) {
            knight.levelUp();
        }
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * XPAngel ofera un boost pentru XP, deci adminul
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * daca, in urma boost-ului primit, eroul avanseaza la un nou nivel
     * se va mai adauga evenimentul de LevelUp, prezent in metoda levelUp()
     * din clasa abstracta Hero.
     * @param pyromancer - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setCurrentXP(pyromancer.getCurrentXP() + Constants.PYROMANCER_BONUS_XP);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(),
                pyromancer.getId());
        updateObserver(helped);
        while (pyromancer.getCurrentXP() >= pyromancer.needToLevel()) {
            pyromancer.levelUp();
        }
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * XPAngel ofera un boost pentru XP, deci adminul
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * daca, in urma boost-ului primit, eroul avanseaza la un nou nivel
     * se va mai adauga evenimentul de LevelUp, prezent in metoda levelUp()
     * din clasa abstracta Hero.
     * @param rogue - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setCurrentXP(rogue.getCurrentXP() + Constants.ROGUE_BONUS_XP);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getId());
        updateObserver(helped);
        while (rogue.getCurrentXP() >= rogue.needToLevel()) {
            rogue.levelUp();
        }
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * XPAngel ofera un boost pentru XP, deci adminul
     * adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-ului helped.
     * daca, in urma boost-ului primit, eroul avanseaza la un nou nivel
     * se va mai adauga evenimentul de LevelUp, prezent in metoda levelUp()
     * din clasa abstracta Hero.
     * @param wizard - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setCurrentXP(wizard.getCurrentXP() + Constants.WIZARD_BONUS_XP);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(),
                wizard.getId());
        updateObserver(helped);
        while (wizard.getCurrentXP() >= wizard.needToLevel()) {
            wizard.levelUp();
        }
    }
}
