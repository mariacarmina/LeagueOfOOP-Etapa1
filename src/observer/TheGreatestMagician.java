package observer;

import common.FileLogger;
import events.Event;


public final class TheGreatestMagician implements Observer {

    private static TheGreatestMagician instance = null;

    private TheGreatestMagician() {
    }

    public static TheGreatestMagician getInstance() {
        if (instance == null) {
            instance = new TheGreatestMagician();
        }
        return instance;
    }

    @Override
    public void update(final Event event) {
        FileLogger.getLogger().write(String.valueOf(event));
    }
}
