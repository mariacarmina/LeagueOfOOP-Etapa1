package main;

import abilities.Ability;
import angels.Angel;
import heroes.Hero;
import heroes.Wizard;
import observer.Observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine {
    private ArrayList<Hero> heroes;
    private ArrayList<String> moves;
    private ArrayList<Angel> angels;
    private ArrayList<Integer> angelsSizes;
    private Observer observer;

    public GameEngine(final GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        moves = gameInput.getMoves();
        angels = gameInput.getAngels();
        angelsSizes = gameInput.getAngelsSizes();
    }

    /**
     * @param hero1
     * @param hero2 aceasta metoda reda lupta dintre doi jucatori
     *              daca primul jucator care se lupta este Wizard, il interschimbam cu cel
     *              de-al doilea jucator pentru a putea prelua damage-ul primit de la acesta
     *              apoi se reseteaza damage-urile fiecaruia la 0
     *              se parcurg listele de abilitati ale fiecarui jucator si se aplica
     *              fiecare abilitate prin metoda cast() din clasele specifice
     *              abilitatilor folosite, practic cei doi oponenti se lupta
     *              folosindu-si fiecare abilitatile
     *              daca unul dintre acestia moare, celalalt devine invingator si primeste XP
     */

    public void battle(Hero hero1, Hero hero2) {
        if (hero1 instanceof Wizard) {
            Hero temp = hero1;
            hero1 = hero2;
            hero2 = temp;
        }
        hero1.resetFight();
        hero2.resetFight();
        for (Ability ability : hero1.getAbilities()) {
            ability.cast(hero1, hero2);
        }
        hero2.takeDamage(hero1);
        for (Ability ability : hero2.getAbilities()) {
            ability.cast(hero2, hero1);
        }
        hero1.takeDamage(hero2);
        if (!hero1.isDead() && hero2.isDead()) {
            hero1.gainXP(hero2.getLevel());
        }
        if (!hero2.isDead() && hero1.isDead()) {
            hero2.gainXP(hero1.getLevel());
        }
    }

    /**
     * se implementeaza logica jocului.
     * jucatorii fac simultan o mutare atata timp cat nu sunt imobilizati sau morti.
     * se stabilesc efectele overtime.
     * atata timp cat ambii jucatorii sunt vii si cat timp se afla pe acelasi teren, se lupta.
     */

    public void playGame() {
        int angelOffset = 0;
        for (int i = 0; i < moves.size(); ++i) {
            for (int j = 0; j < heroes.size(); ++j) {
                if (!heroes.get(j).isStunned() && !heroes.get(j).isDead()) {
                    heroes.get(j).chooseStrategy();
                    heroes.get(j).moveHero(moves.get(i).charAt(j));
                }
                heroes.get(j).sufferEffect();
            }
            for (int j = 0; j < heroes.size(); ++j) {
                for (int k = 0; k < j; ++k) {
                    if (!heroes.get(j).isDead() && !heroes.get(k).isDead()) {
                        if (heroes.get(j).isHere(heroes.get(k))) {
                            battle(heroes.get(j), heroes.get(k));
                        }
                    }
                }
            }
            for (int j = angelOffset; j < angelOffset + angelsSizes.get(i); ++j) {
                angels.get(j).spawned();
                for (int k = 0; k < heroes.size(); ++k) {
                    if (!heroes.get(k).isDead() && heroes.get(k).isAngelHere(angels.get(j))) {
                        heroes.get(k).accept(angels.get(j));
                    } else if (angels.get(j).getAngelType().equals("Spawner")
                            && heroes.get(k).isAngelHere(angels.get(j))) {
                        heroes.get(k).accept(angels.get(j));
                    }
                }
            }
            angelOffset += angelsSizes.get(i);
        }
    }

    /**
     * @param outputFile
     * @throws IOException afiseaza stats-urile jucatorilor
     */

    public void print(final String outputFile) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
        for (Hero hero : heroes) {
            hero.print(out);
        }
        out.newLine();
        out.flush();
        out.close();
    }

}
