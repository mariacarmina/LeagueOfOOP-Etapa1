package events;

public class LevelUp implements Event {
    private String heroType;
    private int heroID;
    private int level;

    public LevelUp(String heroType, int heroID, int level) {
        this.heroType = heroType;
        this.heroID = heroID;
        this.level = level;
    }

    @Override
    public String toString() {
        return heroType + " " + heroID + " reached level" + " " + level;
    }
}
