import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int maxGuesses = 5;
    public static ArrayList<Character> gameWord = new ArrayList<Character>(generateWord());
    public static Character[] unfinishedWord = new Character[gameWord.size()];
    public static ArrayList<Character> lettersGuessedOn = new ArrayList<Character>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Välkommen till hänga gubbe.");
        System.out.println("Datorn kommer slumpa fram ett ord, och du får sedan gissa vad ordet är.");
        System.out.println("Du har " + maxGuesses + " gissningar.");

        for (int i = 0; i < maxGuesses; i++) {
            int blankSpaceCounter = 0;
            for (int y = 0; y < gameWord.size(); y++) {
                if (unfinishedWord[y] == null) {
                    blankSpaceCounter++;
                }
            }

            if (blankSpaceCounter == 0) {
                gameWon();
            }

            System.out.print("\nGör en gissning: ");
            char guessedLetter = s.next().charAt(0);
            guessedLetter = Character.toLowerCase(guessedLetter);

            if (lettersGuessedOn.contains(guessedLetter)) {
                System.out.println("Du har redan gissat på den bokstaven.");
                i--;

                printUnfinishedWord(guessedLetter);
            } else if (!gameWord.contains(guessedLetter)) {
                lettersGuessedOn.add(guessedLetter);
                System.out.println("Bokstaven finns inte i ordet!");

                printUnfinishedWord(guessedLetter);
            } else if (gameWord.contains(guessedLetter)) {
                lettersGuessedOn.add(guessedLetter);
                System.out.println("Bokstaven finns i ordet!");
                i--;

                printUnfinishedWord(guessedLetter);
            }

            if (i == 9) {
                gameLost();
            }
        }
    }

    public static ArrayList<Character> generateWord() {
        String[] hangmanWords = new String[]{
                "elephant",
                "guitar",
                "pizza",
                "mountain",
                "banana",
                "tiger",
                "sweden",
                "ocean",
                "chocolate",
                "pyramid",
                "football",
                "dragon",
                "island",
                "rabbit",
                "coffee",
                "penguin",
                "forest",
                "volcano",
                "castle",
                "desert"};

        int randomNumber = (int) (Math.random() * hangmanWords.length) + 1;
        ArrayList<Character> word = new ArrayList<Character>();

        for (int i = 0; i < hangmanWords[randomNumber].length(); i++) {
            word.add(hangmanWords[randomNumber].charAt(i));
        }

        return word;
    }

    public static void printUnfinishedWord(char guessedLetter) {
        for (int i = 0; i < gameWord.size(); i++) {
            if (gameWord.get(i) == guessedLetter) {
                unfinishedWord[i] = guessedLetter;
            }

            if (unfinishedWord[i] != null) {
                System.out.print(unfinishedWord[i]);
            } else {
                System.out.print("_");
            }
        }
    }

    public static void gameWon() {
        System.out.print("\nDu vann! Rätt ord var ");
        for (int i = 0; i < unfinishedWord.length; i++) {
            System.out.print(unfinishedWord[i]);
        }
        System.out.println(".");
        System.out.println("Starta om programmet och försök igen!");
        System.exit(0);
    }

    public static void gameLost() {
        System.out.print("\nDu förlorade! Rätt ord var ");
        for (int i = 0; i < gameWord.size(); i++) {
            System.out.print(gameWord.get(i));
        }
        System.out.println(". \nStarta om programmet och försök igen!");
        System.exit(0);
    }
}