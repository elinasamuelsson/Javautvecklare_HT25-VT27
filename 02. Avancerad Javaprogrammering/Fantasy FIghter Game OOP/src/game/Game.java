package game;

import game.managers.StateManager;
import game.models.GameState;

public class Game {
    public static void runGame() {
        if (StateManager.getState() == GameState.GAME_START) {
            System.out.println("Welcome to this turn-based Fantasy Fight Simulator!");
            System.out.println("Written to practice object oriented Java programming.");

            StateManager.setState(GameState.MAIN_MENU);
        }
    }
}
