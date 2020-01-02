package angels;

import events.BackToLife;
import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel {
    public Spawner(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        if (knight.isDead()) {
            knight.setCurrentHP(200);
            Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getID());
            updateObserver(helped);
            Event backToLife = new BackToLife(knight.getHeroType(), knight.getID());
            updateObserver(backToLife);
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            pyromancer.setCurrentHP(150);
            Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(), pyromancer.getID());
            updateObserver(helped);
            Event backToLife = new BackToLife(pyromancer.getHeroType(), pyromancer.getID());
            updateObserver(backToLife);
        }
    }

    @Override
    public void visit(Rogue rogue) {
        if (rogue.isDead()) {
            rogue.setCurrentHP(180);
            Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getID());
            updateObserver(helped);
            Event backToLife = new BackToLife(rogue.getHeroType(), rogue.getID());
            updateObserver(backToLife);
        }
    }

    @Override
    public void visit(Wizard wizard) {
        if (wizard.isDead()) {
            wizard.setCurrentHP(120);
            Event helped = new Helped(this.getAngelType(), wizard.getHeroType(), wizard.getID());
            updateObserver(helped);
            Event backToLife = new BackToLife(wizard.getHeroType(), wizard.getID());
            updateObserver(backToLife);
        }
    }
}
