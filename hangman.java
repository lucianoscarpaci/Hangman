import java.util.List;
import java.io.FileNotFoundException; //import java file class
import java.util.Scanner; //import scanner class
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new java.io.File("./words_alpha.txt"));

        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size())); //random number between 0 and list of words

        System.out.println(word);

        List<Character> userGuesses = new ArrayList<>();

        printWordState(word, userGuesses);

        System.out.println("Please enter a number");

    }
        
        private static void printWordState(String word, List<Character> userGuesses) {
            for (int i=0; i < word.length(); i++) {
                if (userGuesses.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i));
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
}
