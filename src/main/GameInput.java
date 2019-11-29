package main;

import heroes.Hero;

import java.util.ArrayList;

public class GameInput {
    private ArrayList<String> map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> moves;

    public GameInput(ArrayList<String> map, ArrayList<Hero> heroes, ArrayList<String> moves) {
        this.map = map;
        this.heroes = heroes;
        this.moves = moves;
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public void setMap(ArrayList<String> map) {
        this.map = map;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }
}
