package main;

import angels.Angel;
import heroes.Hero;

import java.util.ArrayList;

public class GameInput {
    private ArrayList<String> map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> moves;
    private ArrayList<Angel> angels;
    private ArrayList<Integer> angelsSizes;

    public GameInput(final ArrayList<String> map, final ArrayList<Hero> heroes,
                     final ArrayList<String> moves, final ArrayList<Angel> angels,
                     final ArrayList<Integer> angelsSizes) {
        this.map = map;
        this.heroes = heroes;
        this.moves = moves;
        this.angels = angels;
        this.angelsSizes = angelsSizes;
    }

    /**
     * @return map
     * getter pentru harta
     */

    public ArrayList<String> getMap() {
        return map;
    }

    /**
     *
     * @param map
     * setter pentru harta
     */

    public void setMap(final ArrayList<String> map) {
        this.map = map;
    }

    /**
     *
     * @return heroes
     * getter pentru vectorul de eroi
     */

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    /**
     *
     * @param heroes
     * setter pentru vectorul de eroi
     */

    public void setHeroes(final ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    /**
     *
     * @return moves
     * getter pentru vectorul de miscari
     */

    public ArrayList<String> getMoves() {
        return moves;
    }

    /**
     *
     * @param moves
     * setter pentru vectorul de miscari
     */

    public void setMoves(final ArrayList<String> moves) {
        this.moves = moves;
    }

    /**
     * .
     * getter pentru lista de ingeri
     *
     * @return
     */

    public ArrayList<Angel> getAngels() {
        return angels;
    }

    /**
     * .
     * setter pentru lista de ingeri
     *
     * @param angels - ingerii care sunt descrisi de tip si coordonate
     */

    public void setAngels(final ArrayList<Angel> angels) {
        this.angels = angels;
    }

    /**.
     * getter pentru lista de numere de ingeri per runda
     * @return
     */

    public ArrayList<Integer> getAngelsSizes() {
        return angelsSizes;
    }

}
