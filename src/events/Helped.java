package events;

public class Helped implements Event {
    private String angelType;
    private String heroType;
    private int heroID;


    public Helped(final String angelType, final String heroType, final int heroID) {
        this.angelType = angelType;
        this.heroType = heroType;
        this.heroID = heroID;
    }

    /**
     * returneaza mesajul specific evenimentului Helped.
     *
     * @return
     */

    @Override
    public String toString() {
        return angelType + " helped " + heroType + " " + heroID + "\n";
    }

}
