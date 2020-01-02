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
    protected boolean isSpawned;

    public Angel(int row, int column) {
        this.row = row;
        this.column = column;
        this.isSpawned = false;
    }

    public abstract void visit(Knight knight);

    public abstract void visit(Pyromancer pyromancer);

    public abstract void visit(Rogue rogue);

    public abstract void visit(Wizard wizard);

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

//    //public Observer getObserver() {
//        return observer;
//    }

//    //public void setObserver(Observer observer) {
//        this.observer = observer;
//    }

    public String getAngelType() {
        return angelType;
    }

    public void setAngelType(String angelType) {
        this.angelType = angelType;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void updateObserver(Event event) {
        observer.update(event);
    }

    public void spawned() {
        Spawn spawn = new Spawn(angelType, row, column);
        updateObserver(spawn);
    }


//    @Override
//    public void updateSpawned() {
//        if (!isSpawned) {
//            Spawn spawn = new Spawn(angelType, row, column);
//            observer.update(spawn);
//        }
//    }
//
//    public void updateHelped(Helped helped) {
//        throw new UnsupportedOperationException("Not implemented yet.");
//    }
//
//
//    public void updateHit(Hit hit) {
//        throw new UnsupportedOperationException("Not implemented yet.");
//    }
}
