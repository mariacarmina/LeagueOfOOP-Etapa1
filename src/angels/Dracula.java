package angels;

import events.Event;
import events.Helped;
import events.KilledByAngel;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula extends Angel {
    public Dracula(int row, int column) {
        super(row, column);
        this.setAngelType("Dracula");
    }

    public void deadOrAlive(Hero hero) {
        if (hero.getCurrentHP() <= 0) {
            hero.kill();
            Event killedByAngel = new KilledByAngel(hero.getHeroType(), hero.getID());
            updateObserver(killedByAngel);
        } else {
            Event hit = new Helped(this.getAngelType(), hero.getHeroType(), hero.getID());
            updateObserver(hit);
        }
    }


    @Override
    public void visit(Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier() - 0.2f);
        knight.setCurrentHP(knight.getCurrentHP() - 60);
        deadOrAlive(knight);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() - 0.3f);
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() - 40);
        deadOrAlive(pyromancer);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() - 0.1f);
        rogue.setCurrentHP(rogue.getCurrentHP() - 35);
        deadOrAlive(rogue);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() - 0.4f);
        wizard.setCurrentHP(wizard.getCurrentHP() - 20);
        deadOrAlive(wizard);
    }
}
