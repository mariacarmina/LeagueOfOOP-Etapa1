package main;

import abilities.Ability;
import heroes.Hero;
import heroes.Wizard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine {
    private ArrayList<Hero> heroes;
    private ArrayList<String> moves;

    public GameEngine(GameInput gameInput) {
        Map.getInstance().setMap(gameInput.getMap());
        heroes = gameInput.getHeroes();
        moves = gameInput.getMoves();
    }

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
        hero2.takeDamage();
        for (Ability ability : hero2.getAbilities()) {
            ability.cast(hero2, hero1);
        }
        hero1.takeDamage();
        if (!hero1.isDead() && hero2.isDead()) {
            hero1.gainXP(hero2.getLevel());
        }
        if (!hero2.isDead() && hero1.isDead()) {
            hero2.gainXP(hero1.getLevel());
        }
    }

    public void playGame() {
        for (int i = 0; i < 22; ++i) {
            for (int j = 0; j < heroes.size(); ++j) {
                if (!heroes.get(j).isStunned() && !heroes.get(j).isDead()) {
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
        }
    }

    public void print(String outputFile) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
        for (Hero hero : heroes) {
            hero.print(out);
        }
        out.newLine();
        out.flush();
        out.close();
    }

}
