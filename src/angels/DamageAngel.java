package angels;

import events.Event;
import events.Helped;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel {

    public DamageAngel(int row, int column) {
        super(row, column);
        this.setAngelType("DamageAngel");
    }

    @Override
    public void visit(Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier() + 0.15f);
        Event helped = new Helped(this.getAngelType(), knight.getHeroType(), knight.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier() + 0.2f);
        Event helped = new Helped(this.getAngelType(), pyromancer.getHeroType(), pyromancer.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier() + 0.3f);
        Event helped = new Helped(this.getAngelType(), rogue.getHeroType(), rogue.getID());
        updateObserver(helped);
    }

    @Override
    public void visit(Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier() + 0.4f);
        Event helped = new Helped(this.getAngelType(), wizard.getHeroType(), wizard.getID());
        updateObserver(helped);
    }

//    @Override
//    public void updateHelped(Helped helped) {
//        //TheGreatestMagician.getInstance().update(helped);
//        observer.update(helped);
//    }

}
