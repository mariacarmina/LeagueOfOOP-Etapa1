package main;

import java.util.ArrayList;

public final class Map {

    private static Map instance = null;
    private ArrayList<String> map;

    private Map() {
        map = null;
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new main.Map();
        }
        return instance;
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public void setMap(final ArrayList<String> map) {
        this.map = map;
    }

    public char getField(final int row, final int column) {
        return map.get(row).charAt(column);
    }
}
