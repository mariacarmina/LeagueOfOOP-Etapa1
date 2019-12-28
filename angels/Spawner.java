package angels;

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
        }
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        if (pyromancer.isDead()) {
            pyromancer.setCurrentHP(150);
        }
    }

    @Override
    public void visit(Rogue rogue) {
        if (rogue.isDead()) {
            rogue.setCurrentHP(180);
        }
    }

    @Override
    public void visit(Wizard wizard) {
        if (wizard.isDead()) {
            wizard.setCurrentHP(120);
        }
    }
}
