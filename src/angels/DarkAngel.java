package angels;

import events.Event;
import events.Helped;
import events.KilledByAngel;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public class DarkAngel extends Angel {
    public DarkAngel(int row, int column) {
        super(row, column);
        this.setAngelType("DarkAngel");
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
        knight.setCurrentHP(knight.getCurrentHP() - 40);
        deadOrAlive(knight);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() - 30);
        deadOrAlive(pyromancer);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentHP(rogue.getCurrentHP() - 10);
        deadOrAlive(rogue);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentHP(wizard.getCurrentHP() - 20);
        deadOrAlive(wizard);
    }
}
