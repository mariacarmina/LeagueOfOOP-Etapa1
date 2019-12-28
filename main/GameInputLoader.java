package main;

import angels.Angel;
import angels.AngelFactory;
import heroes.Hero;
import heroes.HeroFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInputLoader {

    private File inputFile;

    public GameInputLoader(final String inputFileName) {
        inputFile = new File(inputFileName);
    }

    /**
     * @return
     * @throws FileNotFoundException se realizeaza citirea datelor in fisier
     */

    public GameInput load() throws FileNotFoundException {
        int rows;
        int columns;
        ArrayList<String> map = new ArrayList<String>();
        int numHeroes;
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        int numRounds;
        ArrayList<String> moves = new ArrayList<String>();
        ArrayList<Angel> angels = new ArrayList<Angel>();
        Scanner input = new Scanner(inputFile);
        input.useDelimiter(", * \n \r");

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
        for (int i = 0; i < numRounds; ++i) {
            int numAngels = input.nextInt();
            String angelType = input.next();
            int positionRow = input.nextInt();
            int positionColumn = input.nextInt();
            for (int j = 0; j < numAngels; ++j) {
                angels.add(AngelFactory.getInstance().getAngelByType(angelType, positionRow, positionColumn));
            }
        }
        return new GameInput(map, heroes, moves, angels);
    }
}
