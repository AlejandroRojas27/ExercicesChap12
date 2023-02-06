import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio_12_11_RemoveText {
    public static void main(String[] args) throws Exception {
        //Check command line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java Ejercicio_12_11_RemoveText toBeRemoved fileName");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[1]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[1] + " does not exist");
            System.exit(2);
        }

        File tempFile = new File("Temp.txt");



        try (
                Scanner input = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(tempFile);
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[0],"");
                output.println(s2);
            }
        }


        try (
                Scanner input = new Scanner(tempFile);
                PrintWriter output = new PrintWriter(sourceFile);
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                output.println(s1);

            }
        }

        tempFile.delete();

        System.out.println("Done :)");


    }
}
