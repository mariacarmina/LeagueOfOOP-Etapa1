package events;

public class KilledByAngel implements Event {
    private String heroType;
    private int heroID;

    public KilledByAngel(String heroType, int heroID) {
        this.heroType = heroType;
        this.heroID = heroID;
    }

    @Override
    public String toString() {
        return "Player" + " " + heroType + " " + heroID + " was killed by an angel";
    }
}
