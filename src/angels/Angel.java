package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public abstract class Angel {
    protected int row;
    protected int column;

    public Angel(int row, int column) {
        this.row = row;
        this.column = column;
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
}
