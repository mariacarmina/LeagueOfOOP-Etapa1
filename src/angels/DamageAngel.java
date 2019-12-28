package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel {

    public DamageAngel(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier() + 0.15f);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() + 0.2f);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() + 0.3f);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() + 0.4f);
    }

}
