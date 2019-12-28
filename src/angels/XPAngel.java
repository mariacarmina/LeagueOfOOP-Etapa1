package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel extends Angel {
    public XPAngel(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentXP(knight.getCurrentXP() + 45);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentXP(pyromancer.getCurrentXP() + 50);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentXP(rogue.getCurrentXP() + 40);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentXP(wizard.getCurrentXP() + 60);
    }
}
