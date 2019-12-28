package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel extends Angel {
    public DarkAngel(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentHP(knight.getCurrentHP() - 40);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() - 30);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentHP(rogue.getCurrentHP() - 10);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentHP(wizard.getCurrentHP() - 20);
    }
}
