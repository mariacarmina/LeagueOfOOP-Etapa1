package observer;

import events.Event;

public interface Subject {
    void registerObserver(Observer observer);

    void updateObserver(Event event);
}
