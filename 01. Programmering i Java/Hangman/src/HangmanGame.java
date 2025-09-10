import java.util.ArrayList;

public class HangmanGame {
    public static int maxGuesses;
    public static int guessesRemaining;
    public static ArrayList<Character> gameWord;
    public static ArrayList<Character> lettersGuessedOn;

    public static int getMaxGuesses() {
        return maxGuesses;
    }

    public static int getGuessesRemaining() {
        return guessesRemaining;
    }

    public static ArrayList<Character> getLettersGuessedOn() {
        return lettersGuessedOn;
    }

    public static ArrayList<Character> getGameWord() {
        return gameWord;
    }

    public void generateWord() {
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

        this.gameWord = word;
    }
}
