package events;

public class Hit implements Event {
    private String angelType;
    private String heroType;
    private int heroID;


    public Hit(String angelType, String heroType, int heroID) {
        this.angelType = angelType;
        this.heroType = heroType;
        this.heroID = heroID;
    }


    @Override
    public String toString() {
        return angelType + " helped " + heroType + " " + heroID;
    }
}
