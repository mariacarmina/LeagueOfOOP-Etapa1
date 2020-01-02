package angels;

import events.Event;
import events.KilledByAngel;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentHP(0);
        knight.kill();
        Event killedByAngel = new KilledByAngel(knight.getHeroType(), knight.getID());
        updateObserver(killedByAngel);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentHP(0);
        pyromancer.kill();
        Event killedByAngel = new KilledByAngel(pyromancer.getHeroType(), pyromancer.getID());
        updateObserver(killedByAngel);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentHP(0);
        rogue.kill();
        Event killedByAngel = new KilledByAngel(rogue.getHeroType(), rogue.getID());
        updateObserver(killedByAngel);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentHP(0);
        wizard.kill();
        Event killedByAngel = new KilledByAngel(wizard.getHeroType(), wizard.getID());
        updateObserver(killedByAngel);
    }
}
