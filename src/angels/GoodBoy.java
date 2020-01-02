package angels;

import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoy extends Angel {
    public GoodBoy(int row, int column) {
        super(row, column);
        this.setAngelType("GooedBoy");
    }

    @Override
    public void visit(Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier() + 0.4f);
        knight.setCurrentHP(knight.getCurrentHP() + 20);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getID());
        updateObserver(helped);

    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() + 0.5f);
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() + 30);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(), pyromancer.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() + 0.4f);
        rogue.setCurrentHP(rogue.getCurrentHP() + 40);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() + 0.3f);
        wizard.setCurrentHP(wizard.getCurrentHP() + 50);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(), wizard.getID());
        updateObserver(helped);
    }
}
