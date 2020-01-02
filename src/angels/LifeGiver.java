package angels;

import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel {
    public LifeGiver(int row, int column) {
        super(row, column);
        this.setAngelType("LifeGiver");
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentHP(knight.getCurrentHP() + 100);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() + 80);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(), pyromancer.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentHP(rogue.getCurrentHP() + 90);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentHP(wizard.getCurrentHP() + 120);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(), wizard.getID());
        updateObserver(helped);
    }
}
