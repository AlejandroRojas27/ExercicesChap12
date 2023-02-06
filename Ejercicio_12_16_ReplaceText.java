import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_16_ReplaceText {
    public static void main(String[] args) throws Exception {
        //Check command line parameter usage
        if (args.length != 3) {
            System.out.println("Usage: java Exercise12_16 file oldString newString");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        ArrayList<String> strList = new ArrayList<>();

        try (
                //Create input and output files
                Scanner input = new Scanner(sourceFile);

        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);

                strList.add(s2);

            }
        }


        try (
                PrintWriter output = new PrintWriter(sourceFile);
        ) {

            for (int i = 0; i < strList.size(); i++) {
                String s = strList.get(i);
                output.println(s);
            }

        } finally {
            Date date = new Date();
            System.out.println("Done at " + date);
        }


    }
}
