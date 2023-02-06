import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_13_CountCharactersWordsAndLinesInAFile {
    public static void main(String[] args) throws Exception {
        //Check command line parameter usage
        if (args.length != 1) {
            System.out.println("java Ejercicio_12_13_CountCharactersWordsAndLinesInAFile Test.java");
            System.exit(1);
        }

        //Create file object
        File sourceFile = new File(args[0]);

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }


        int countChars = 0;

        ArrayList<String> strList = new ArrayList<>();
        ArrayList<String> strList2 = new ArrayList<>();

        try (
                Scanner input = new Scanner(sourceFile);
                Scanner input2 = new Scanner(sourceFile).useDelimiter("\n")
        ) {

            while (input.hasNext()) {
                String str = input.next();
                String s1 = str.trim();
                strList.add(s1); //count Words
                countChars += s1.length(); // count characters
            }

            while (input2.hasNext()) {
                String str = input2.nextLine();
                strList2.add(str);

            }

        } finally {
            Date date = new Date();
            System.out.println("Done at " + date);
            System.out.println("Source file " + args[0] + " has " + countChars + " characters");
            System.out.println("Source file " + args[0] + " has " + strList.size() + " words");
            System.out.println("Source file " + args[0] + " has " + strList2.size() + " lines");
        }

    }
}
