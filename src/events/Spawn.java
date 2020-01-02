package events;

public class Spawn implements Event {
    private String angelType;
    private int row;
    private int column;

    public Spawn(String angelType, int row, int column) {
        this.angelType = angelType;
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Angel " + angelType + " was spawned at " + row + " " + column;
    }
}
