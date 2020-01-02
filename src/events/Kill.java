package events;

public class Kill implements Event {
    private String sourceType;
    private int sourceID;
    private String targetType;
    private int targetID;

    public Kill(String targetType, int targetID, String sourceType, int sourceID) {
        this.sourceType = sourceType;
        this.sourceID = sourceID;
        this.targetType = targetType;
        this.targetID = targetID;
    }


    @Override
    public String toString() {
        return "Player" + " " + targetType + " " + targetID + " was killed by" + " " + sourceType
                + " " + sourceID;
    }
}

