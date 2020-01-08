package angels;

import common.Constants;
import events.Event;
import events.Hit;
import events.KilledByAngel;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;


public class DarkAngel extends Angel {
    public DarkAngel(final int row, final int column) {
        super(row, column);
        this.setAngelType("DarkAngel");
    }

    /**
     * aceasta metoda decide daca un erou
     * mai traieste in urma scaderii
     * HP-ului de catre Dracula (deadOrAlive).
     * in functie de aceasta metoda stabilesc cate notificari
     * va primi Marele Magician in legatura cu starea eroului.
     * am folosit aceasta metoda pentru a preveni duplicarea codului
     *
     * @param hero - eroul vizitat de Dracula
     */

    public void deadOrAlive(final Hero hero) {
        if (hero.getCurrentHP() <= 0) {
            hero.kill();
            Event hit = new Hit(this.getAngelType(), hero.getHeroType(), hero.getId());
            updateObserver(hit);
            Event killedByAngel = new KilledByAngel(hero.getHeroType(), hero.getId());
            updateObserver(killedByAngel);
        } else {
            Event hit = new Hit(this.getAngelType(), hero.getHeroType(), hero.getId());
            updateObserver(hit);
        }
    }

    /**
     * scad HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param knight - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Knight knight) {
        knight.setCurrentHP(knight.getCurrentHP() - Constants.KNIGHT_DARK_ANGEL_HP);
        deadOrAlive(knight);
    }

    /**
     * scad HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param pyromancer - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() - Constants.PYROMANCER_DARK_ANGEL_HP);
        deadOrAlive(pyromancer);
    }

    /**
     * scad HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param rogue - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setCurrentHP(rogue.getCurrentHP() - Constants.ROGUE_DARK_ANGEL_HP);
        deadOrAlive(rogue);
    }

    /**
     * scad HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param wizard - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setCurrentHP(wizard.getCurrentHP() - Constants.WIZARD_DARK_ANGEL_HP);
        deadOrAlive(wizard);
    }
}
