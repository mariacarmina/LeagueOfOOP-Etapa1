package observer;

import events.Event;

public class TheGreatestMagician implements Observer {

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
    public void update(Event event) {
        System.out.println(event);
    }


    //private Subject subject;

//    @Override
//    public void update(Spawn spawn) {
//        System.out.println(spawn);
//    }
//
//    @Override
//    public void update(Helped helped) {
//        System.out.println(helped);
//    }
//
//    @Override
//    public void update(Hit hit) {
//        System.out.println(hit);
//    }

//    public void update(Hero hero, String angelType) {
//        if (angelType.equals("DamageAngel") || angelType.equals("GoodBoy") || angelType.equals("LevelUpAngel") || angelType.equals("LifeGiver") || angelType.equals("SmallAngel") || angelType.equals("Spawner") || angelType.equals("XPAngel")) {
//            System.out.println(angelType + " helped" + hero.getHeroType() + " " + hero.getID());
//        } else if (angelType.equals("DarkAngel") || angelType.equals("Dracula") || angelType.equals("TheDoomer")) {
//            System.out.println(angelType + " hit" + hero.getHeroType() + " " + hero.getID());
//        }
//    }
//
//    public void update() {}

//    public Subject getSubject() {
//        return subject;
//    }
//
//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }
}
