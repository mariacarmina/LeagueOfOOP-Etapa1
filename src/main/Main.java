package main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        GameInput gameInput = gameInputLoader.load();
        GameEngine gameEngine = new GameEngine(gameInput);
        gameEngine.playGame();
        gameEngine.print(args[1]);
    }
}
