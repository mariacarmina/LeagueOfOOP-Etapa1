package angels;

import events.Event;
import events.Spawn;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import observer.Observer;
import observer.Subject;



public abstract class Angel implements Subject {
    protected String angelType;
    protected Observer observer;

    protected int row;
    protected int column;

    public Angel(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public abstract void visit(Knight knight);

    public abstract void visit(Pyromancer pyromancer);

    public abstract void visit(Rogue rogue);

    public abstract void visit(Wizard wizard);

    /**
     * @return row
     * getter pentru linie.
     */

    public int getRow() {
        return row;
    }

    /**
     *
     * @return column
     * getter pentru coloana.
     */

    public int getColumn() {
        return column;
    }

    /**
     *
     * @return angelType
     * getter pentru angelType.
     */

    public String getAngelType() {
        return angelType;
    }

    /**
     *
     * @param angelType setter pentru angelType
     */

    public void setAngelType(final String angelType) {
        this.angelType = angelType;
    }

    /**
     *
     * @param observer setter pentru observer
     */

    @Override
    public void registerObserver(final Observer observer) {
        this.observer = observer;
    }

    /**.
     *metoda suprascrisa din interfata Subject
     * pentru a notifica adminul
     * @param event ce reprezinta evenimentul
     *             ce trebuie notificat
     */

    @Override
    public void updateObserver(final Event event) {
        observer.update(event);
    }

    /**.
     * notifica aparitia unui nou inger
     */

    public void spawned() {
        Spawn spawn = new Spawn(angelType, row, column);
        updateObserver(spawn);
    }
}
