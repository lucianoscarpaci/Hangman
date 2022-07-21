import java.io.FileNotFoundException; //import java file class
import java.util.Scanner; //import scanner class
public class hangman {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new java.io.File("./words_alpha.txt"));

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}