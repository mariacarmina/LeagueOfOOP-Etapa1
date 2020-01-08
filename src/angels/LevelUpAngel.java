package angels;

import common.Constants;
import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(final int row, final int column) {
        super(row, column);
        this.setAngelType("LevelUpAngel");
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * LevelUpAngel ofera un boost al modificatorilor de damage si unul pentru
     * XP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si LevelUp prezent in metoda levelUp()
     * din clasa abstracta Hero.
     *
     * @param knight - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Knight knight) {
        knight.setCurrentXP(knight.getCurrentXP() + (knight.needToLevel()
                - knight.getCurrentXP()));
        knight.setStrategyMultiplier(knight.getStrategyMultiplier()
                + Constants.KNIGHT_LEVELUP_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getId());
        updateObserver(helped);
        knight.levelUp();
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * LevelUpAngel ofera un boost al modificatorilor de damage si unul pentru
     * XP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si LevelUp prezent in metoda levelUp()
     * din clasa abstracta Hero.
     * @param pyromancer - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setCurrentXP(pyromancer.getCurrentXP()
                + (pyromancer.needToLevel() - pyromancer.getCurrentXP()));
        pyromancer.setStrategyMultiplier(pyromancer.getStrategyMultiplier()
                + Constants.PYROMANCER_LEVELUP_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(),
                pyromancer.getId());
        updateObserver(helped);
        pyromancer.levelUp();
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * LevelUpAngel ofera un boost al modificatorilor de damage si unul pentru
     * XP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si LevelUp prezent in metoda levelUp()
     * din clasa abstracta Hero.
     * @param rogue - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setCurrentXP(rogue.getCurrentXP()
                + (rogue.needToLevel() - rogue.getCurrentXP()));
        rogue.setStrategyMultiplier(rogue.getStrategyMultiplier()
                + Constants.ROGUE_LEVELUP_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(),
                rogue.getId());
        updateObserver(helped);
        rogue.levelUp();
    }

    /**
     * pentru a realiza Visitor Pattern, metoda visit e
     * supraincarcata in fiecare tip de inger si sunt
     * implementate particularitatile ingerului pentru
     * fiecare tip de erou impreuna cu evenimentele specifice
     * ingerului.
     * LevelUpAngel ofera un boost al modificatorilor de damage si unul pentru
     * XP, deci adminul va fi notificat cand acest inger va ajuta un erou, prin
     * intermediul event-urilor helped si LevelUp prezent in metoda levelUp()
     * din clasa abstracta Hero.
     * @param wizard - eroul pe care il viziteaza
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setCurrentXP(wizard.getCurrentXP()
                + (wizard.needToLevel() - wizard.getCurrentXP()));
        wizard.setStrategyMultiplier(wizard.getStrategyMultiplier()
                + Constants.WIZARD_LEVELUP_MULTIPLIER);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(),
                wizard.getId());
        updateObserver(helped);
        wizard.levelUp();
    }
}
