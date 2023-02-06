import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_12_30_OccurrencesOfEachLetter {
    public static void main(String[] args) throws Exception {

        Scanner input1 = new Scanner(System.in);

        System.out.print("Enter a filename: ");
        File file = new File(input1.nextLine()); //"src/Text.txt"

        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
        }

        int[] counter = new int['Z' - 'A' + 1];

        try (
                Scanner input = new Scanner(file)
        ) {

            while (input.hasNext()) {
                String s1 = input.next();

                for (int i = 0; i < s1.length(); i++) {

                    char letter = Character.toUpperCase(s1.charAt(i));

                    if (Character.isLetter(letter)) {
                        counter[letter - 'A'] += 1;
                    }

                }

            }

        }

        for (int i = 0; i < counter.length; i++) {

            char ch = (char) ('A' + i);

            //Number of As: 56
            System.out.printf("Number of %cs: %d\n", ch, counter[i]);

        }

    }
}
