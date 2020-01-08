package events;

public class Spawn implements Event {
    private String angelType;
    private int row;
    private int column;

    public Spawn(final String angelType, final int row, final int column) {
        this.angelType = angelType;
        this.row = row;
        this.column = column;
    }

    /**
     * returneaza mesajul specific evenimentului Spawn.
     *
     * @return
     */

    @Override
    public String toString() {
        return "Angel " + angelType + " was spawned at " + row + " " + column + "\n";
    }
}
