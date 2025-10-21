package game.managers;

import game.models.GameState;

public class StateManager {
    private static Enum<GameState> state = GameState.GAME_START;

    public static Enum<GameState> getState() {
        return StateManager.state;
    }
    public static void setState(Enum<GameState> state) {
        StateManager.state = state;
    }
}

/*
        Scanner sc = new Scanner(System.in);

        // menu
        System.out.println("-------- MENU --------");
        System.out.println();
        System.out.println("Warrior | Wizard | Rogue");
        System.out.print("Pick a character: ");

        // pick character
        while (true) {
            String userCharacterChoice = sc.nextLine();

            if (userCharacterChoice.equalsIgnoreCase("warrior")) {
                System.out.println("Picked warrior!");
                break;
            } else if (userCharacterChoice.equalsIgnoreCase("wizard")) {
                System.out.println("Picked wizard!");
                break;
            } else if (userCharacterChoice.equalsIgnoreCase("rogue")) {
                System.out.println("Picked rogue!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
*/
