package events;


public class KilledByAngel implements Event {
    private String heroType;
    private int heroID;

    public KilledByAngel(final String heroType, final int heroID) {
        this.heroType = heroType;
        this.heroID = heroID;
    }

    /**
     * returneaza mesajul specific evenimentului KilledByAngel.
     *
     * @return
     */

    @Override
    public String toString() {
        return "Player" + " " + heroType + " " + heroID + " was killed by an angel" + "\n";
    }

}
