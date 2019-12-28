package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula extends Angel {
    public Dracula(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier() - 0.2f);
        knight.setCurrentHP(knight.getCurrentHP() - 60);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() - 0.3f);
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() - 40);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() - 0.1f);
        rogue.setCurrentHP(rogue.getCurrentHP() - 35);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() - 0.4f);
        wizard.setCurrentHP(wizard.getCurrentHP() - 20);
    }
}
