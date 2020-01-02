package events;

public class BackToLife implements Event {
    private String heroType;
    private int heroID;

    public BackToLife(String heroType, int heroID) {
        this.heroType = heroType;
        this.heroID = heroID;
    }

    @Override
    public String toString() {
        return "Player" + " " + heroType + " " + heroID + " " + "was brought to life by an angel";
    }
}
