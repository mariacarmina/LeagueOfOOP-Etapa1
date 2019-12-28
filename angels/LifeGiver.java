package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel {
    public LifeGiver(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentHP(knight.getCurrentHP() + 100);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() + 80);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentHP(rogue.getCurrentHP() + 90);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentHP(wizard.getCurrentHP() + 120);
    }
}
