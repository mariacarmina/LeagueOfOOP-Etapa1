package angels;

import events.Event;
import events.Hit;
import events.KilledByAngel;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer(final int row, final int column) {
        super(row, column);
        this.setAngelType("TheDoomer");
    }

    /**
     * pentru a omori un erou, HP-ul sau trebuie setat
     * la 0 si declarat "dead" prin intermediul metodei
     * kill().
     * fiind un inger rau, evenimentul prioritar este hit,
     * iar apoi se notifica faptul ca a fost omorat de un inger
     * prin killedByAngel
     *
     * @param hero - eroul care moare in urma ingerului TheDoomer
     */

    public void killedHero(final Hero hero) {
        hero.setCurrentHP(0);
        hero.kill();
        Event hit = new Hit(this.getAngelType(), hero.getHeroType(), hero.getId());
        updateObserver(hit);
        Event killedByAngel = new KilledByAngel(hero.getHeroType(), hero.getId());
        updateObserver(killedByAngel);
    }

    /**.
     * am ales sa implementez separat logica din fiecare
     * visit si sa o restrang in metoda de mai sus pentru
     * a evita duplicarea codului
     * @param knight - eroul care moare in urma ingerului TheDoomer
     */

    @Override
    public void visit(final Knight knight) {
        killedHero(knight);
    }

    /**
     * .
     * am ales sa implementez separat logica din fiecare
     * visit si sa o restrang in metoda de mai sus pentru
     * a evita duplicarea codului
     *
     * @param pyromancer - eroul care moare in urma ingerului TheDoomer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        killedHero(pyromancer);
    }

    /**.
     * am ales sa implementez separat logica din fiecare
     * visit si sa o restrang in metoda de mai sus pentru
     * a evita duplicarea codului
     * @param rogue- eroul care moare in urma ingerului TheDoomer
     */

    @Override
    public void visit(final Rogue rogue) {
        killedHero(rogue);
    }

    /**.
     * am ales sa implementez separat logica din fiecare
     * visit si sa o restrang in metoda de mai sus pentru
     * a evita duplicarea codului
     * @param wizard - eroul care moare in urma ingerului TheDoomer
     */

    @Override
    public void visit(final Wizard wizard) {
        killedHero(wizard);
    }
}
