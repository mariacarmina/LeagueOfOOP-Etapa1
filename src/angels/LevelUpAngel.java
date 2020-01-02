package angels;

import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int row, int column) {
        super(row, column);
        this.setAngelType("LevelUpAngel");
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentXP(knight.getCurrentXP() + (knight.needToLevel() - knight.getCurrentXP()));
        knight.levelUp();
        knight.setAngelMultiplier(knight.getAngelMultiplier() + 0.1f);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentXP(
                pyromancer.getCurrentXP() + (pyromancer.needToLevel() - pyromancer.getCurrentXP()));
        pyromancer.levelUp();
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() + 0.2f);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(), pyromancer.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentXP(rogue.getCurrentXP() + (rogue.needToLevel() - rogue.getCurrentXP()));
        rogue.levelUp();
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() + 0.15f);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentXP(wizard.getCurrentXP() + (wizard.needToLevel() - wizard.getCurrentXP()));
        wizard.levelUp();
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() + 0.25f);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(), wizard.getID());
        updateObserver(helped);
    }
}
