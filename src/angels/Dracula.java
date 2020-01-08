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


public class Dracula extends Angel {
    public Dracula(final int row, final int column) {
        super(row, column);
        this.setAngelType("Dracula");
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
        Event hit = new Hit(this.getAngelType(), hero.getHeroType(), hero.getId());
        updateObserver(hit);
        if (hero.getCurrentHP() <= 0) {
            hero.kill();
            Event killedByAngel = new KilledByAngel(hero.getHeroType(), hero.getId());
            updateObserver(killedByAngel);
        }
    }

    /**
     * scad coeficientii de damage si HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param knight - eroul vizitat de Dracula
     */
    @Override
    public void visit(final Knight knight) {
        knight.setAngelMultiplier(knight.getAngelMultiplier()
                - Constants.KNIGHT_DRACULA_MULTIPLIER);
        knight.setCurrentHP(knight.getCurrentHP() - Constants.KNIGHT_DRACULA_HP);
        deadOrAlive(knight);
    }

    /**
     * scad coeficientii de damage si HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param pyromancer - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelMultiplier(pyromancer.getAngelMultiplier()
                - Constants.PYROMANCER_DRACULA_MULTIPLIER);
        pyromancer.setCurrentHP(pyromancer.getCurrentHP() - Constants.PYROMANCER_DRACULA_HP);
        deadOrAlive(pyromancer);
    }

    /**
     * scad coeficientii de damage si HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param rogue - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelMultiplier(rogue.getAngelMultiplier()
                - Constants.ROGUE_DRACULA_MULTIPLIER);
        rogue.setCurrentHP(rogue.getCurrentHP() - Constants.ROGUE_DRACULA_HP);
        deadOrAlive(rogue);
    }

    /**
     * scad coeficientii de damage si HP-ul eroului
     * apoi apelez metoda de mai sus pentru a stabili
     * notificarile.
     * @param wizard - eroul vizitat de Dracula
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelMultiplier(wizard.getAngelMultiplier()
                - Constants.WIZARD_DRACULA_MULTIPLIER);
        wizard.setCurrentHP(wizard.getCurrentHP() - Constants.WIZARD_DRACULA_HP);
        deadOrAlive(wizard);
    }

}
