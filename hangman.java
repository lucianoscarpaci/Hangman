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
    }
}