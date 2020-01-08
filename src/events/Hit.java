package events;


public class Hit implements Event {
    private String angelType;
    private String heroType;
    private int heroID;


    public Hit(final String angelType, final String heroType, final int heroID) {
        this.angelType = angelType;
        this.heroType = heroType;
        this.heroID = heroID;
    }

    /**
     * returneaza mesajul specific evenimentului Hit.
     *
     * @return
     */

    @Override
    public String toString() {
        return angelType + " hit " + heroType + " " + heroID + "\n";
    }

}
