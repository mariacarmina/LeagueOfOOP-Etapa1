package com.main;

import com.heroes.Hero;
import com.heroes.HeroFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInputLoader {

    File inputFile;

    public GameInputLoader(String inputFileName) {
        inputFile = new File(inputFileName);
    }

    public GameInput load() throws FileNotFoundException {
        int rows;
        int columns;
        ArrayList<String> map = new ArrayList<String>();
        int numHeroes;
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        int numRounds;
        ArrayList<String> moves = new ArrayList<String>();
        Scanner input = new Scanner(inputFile);

        rows = input.nextInt();
        columns = input.nextInt();
        for (int i = 0; i < rows; ++i) {
            map.add(input.next());
        }
        numHeroes = input.nextInt();
        for (int i = 0; i < numHeroes; ++i) {
            String type = input.next();
            int positionRow = input.nextInt();
            int positionColumn = input.nextInt();
            heroes.add(HeroFactory.getInstance().getHeroByType(type, positionRow, positionColumn));
        }

        numRounds = input.nextInt();
        for (int i = 0; i < numRounds; ++i) {
            moves.add(input.next());
        }
        return new GameInput(map, heroes, moves);
    }
}
