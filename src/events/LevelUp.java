package events;

public class LevelUp implements Event {
    private String heroType;
    private int heroID;
    private int level;

    public LevelUp(final String heroType, final int heroID, final int level) {
        this.heroType = heroType;
        this.heroID = heroID;
        this.level = level;
    }

    /**
     * returneaza mesajul specific evenimentului LevelUp.
     *
     * @return
     */

    @Override
    public String toString() {
        return heroType + " " + heroID + " reached level" + " " + level + "\n";
    }
}
