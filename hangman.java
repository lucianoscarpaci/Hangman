import java.util.List;
import java.io.FileNotFoundException; //import java file class
import java.util.Scanner; //import scanner class
import java.util.ArrayList;
import java.util.Random;

public class hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new java.io.File("./words_alpha.txt"));
        Scanner keyboard = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size())); //random number between 0 and list of words

        System.out.println(word);


        List<Character> userGuesses = new ArrayList<>();

    int wrongCount = 0;    
    while(true) {

        printHangMan(wrongCount);

        if(wrongCount >= 6) {
            System.out.println("You Loose the game");
            break;
        }

        printWordState(word, userGuesses);
        if (!getThePlayerGuess(keyboard, word, userGuesses)) {
            wrongCount++;
        }

        System.out.println(" --------");
        System.out.println(" |      |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            }
            else {
                System.out.println("");
            }
        }
        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            }
            else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");

        
        

        if(printWordState(word, userGuesses)) {
            System.out.println("You Win!!");
            break;
        }
        System.out.println("Please enter your guess for the word:");
        if(keyboard.nextLine().equals(word)) {
            System.out.println("You Win!!");
            break;
        }
        else {
            System.out.println("No! wrong character.");
        }
    }
    
    }

    private static void printHangMan(Integer wrongCount) {
        System.out.println(" --------");
        System.out.println(" |      |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            }
            else {
                System.out.println("");
            }
        }
        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            }
            else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static boolean getThePlayerGuess(Scanner keyboard, String word, List<Character> userGuesses) {
        System.out.println("Please enter a letter");
        String guessLetter = keyboard.nextLine();
        /* take first character add it to the list */
        userGuesses.add(guessLetter.charAt(0));
        /* print the game state whereever the letter appears,
        it should replace the real letter */

        return word.contains(guessLetter);
        
    }
        
        private static boolean printWordState(String word, List<Character> userGuesses) {
            int trueCount = 0;
            for (int i=0; i < word.length(); i++) {
                if (userGuesses.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i));
                    trueCount++;
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return (word.length() == trueCount);
        }

        
}