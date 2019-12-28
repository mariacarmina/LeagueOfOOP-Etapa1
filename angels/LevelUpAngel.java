package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int row, int column) {
        super(row, column);
    }

    @Override
    public void visit(Knight knight) {
        knight.setCurrentXP(knight.getCurrentXP() + (knight.needToLevel() - knight.getCurrentXP()));
        knight.levelUp();
        knight.setAngelMultiplier(knight.getAngelMultiplier() + 0.1f);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setCurrentXP(
                pyromancer.getCurrentXP() + (pyromancer.needToLevel() - pyromancer.getCurrentXP()));
        pyromancer.levelUp();
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() + 0.2f);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setCurrentXP(rogue.getCurrentXP() + (rogue.needToLevel() - rogue.getCurrentXP()));
        rogue.levelUp();
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() + 0.15f);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setCurrentXP(wizard.getCurrentXP() + (wizard.needToLevel() - wizard.getCurrentXP()));
        wizard.levelUp();
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() + 0.25f);
    }
}
