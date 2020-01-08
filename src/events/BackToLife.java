package events;


public class BackToLife implements Event {
    private String heroType;
    private int heroID;

    public BackToLife(final String heroType, final int heroID) {
        this.heroType = heroType;
        this.heroID = heroID;
    }

    /**
     * returneaza mesajul specific evenimentului BackToLife.
     *
     * @return
     */

    @Override
    public String toString() {
        return "Player" + " " + heroType + " " + heroID + " " + "was brought to life "
                + "by an angel" + "\n";
    }

}
