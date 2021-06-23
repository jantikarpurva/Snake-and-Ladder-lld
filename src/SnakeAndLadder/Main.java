package SnakeAndLadder;
import SnakeAndLadder.entities.*;
import SnakeAndLadder.services.DiceService;

public class Main {

    public static void main(String[] args) {

        Game g = new Game(10,2);
        g.addPlayers(new Player("Purva"));
        g.addPlayers(new Player("Praveen"));
        g.launchGame();

    }
}
