/*
EXERCISE BRIEF
Skapa ett spel där:

Spelaren väljer en karaktär (minst 3 olika typer)
Ett slumpmässigt monster dyker upp (minst 3 olika typer)
De slåss turbaserat tills någon vinner
Spelet avslutas med ett meddelande om vem som vann
*/

package game;

import game.managers.CommandManager;

public class Main {
    public static void main(String[] args) {
        CommandManager.run();
    }
}
