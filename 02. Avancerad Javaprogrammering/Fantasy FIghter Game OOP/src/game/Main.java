/*
EXERCISE BRIEF
Skapa ett spel där:

Spelaren väljer en karaktär (minst 3 olika typer)
Ett slumpmässigt monster dyker upp (minst 3 olika typer)
De slåss turbaserat tills någon vinner
Spelet avslutas med ett meddelande om vem som vann

SPELET BEHÖVER:
- Character huvudklass
-- attribut: hp, mp, speed, attack power
-- metoder: attack,
- Itemklass
--
*/

package game;

import static game.Game.runGame;

public class Main {
    public static void main(String[] args) {
        runGame();
    }
}
