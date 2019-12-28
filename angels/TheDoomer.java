package angels;

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
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentHP(0);
        pyromancer.kill();
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentHP(0);
        rogue.kill();
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentHP(0);
        wizard.kill();
    }
}
