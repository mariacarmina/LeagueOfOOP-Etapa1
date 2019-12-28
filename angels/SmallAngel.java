package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel {
    public SmallAngel(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier() + 0.1f);
        knight.setCurrentHP(knight.getCurrentHP() + 10);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() + 0.15f);
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() + 15);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() + 0.05f);
        rogue.setCurrentHP(rogue.getCurrentHP() + 20);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() + 0.1f);
        wizard.setCurrentHP(wizard.getCurrentHP() + 25);
    }
}
