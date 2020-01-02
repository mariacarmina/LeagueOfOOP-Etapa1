package observer;


import events.Event;


public interface Observer {
    void update(Event event);
}
