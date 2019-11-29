package main;

import java.util.ArrayList;

public class Map {

    private static Map instance = null;
    private ArrayList<String> map;

    private Map() {
        map = null;
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public void setMap(ArrayList<String> map) {
        this.map = map;
    }

    public char getField(int row, int column) {
        return map.get(row).charAt(column);
    }
}
