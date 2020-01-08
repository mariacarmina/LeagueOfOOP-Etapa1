package events;


public class Kill implements Event {
    private String sourceType;
    private int sourceID;
    private String targetType;
    private int targetID;

    public Kill(final String targetType, final int targetID,
                final String sourceType, final int sourceID) {
        this.sourceType = sourceType;
        this.sourceID = sourceID;
        this.targetType = targetType;
        this.targetID = targetID;
    }

    /**
     * returneaza mesajul specific evenimentului Kill.
     *
     * @return
     */

    @Override
    public String toString() {
        return "Player" + " " + targetType + " " + targetID + " was killed by" + " " + sourceType
                + " " + sourceID + "\n";
    }
}

