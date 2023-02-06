import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_12_ReformatJavaSourceCode {

    public static void main(String[] args) throws Exception {
        //Check command line parameter usage
        if (args.length != 1) {
            System.out.println("java Exercise12_12 Test.java");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        //File tempFile = new File("TempClass.txt");

        StringBuilder stringBuilder = new StringBuilder();

        try (
                Scanner input = new Scanner(sourceFile);
        ) {
            while (input.hasNext()) {
                String s = input.nextLine();
                String s1 = s.trim();
                if (s1.charAt(0) == '{') {
                    stringBuilder.append(" {");
                } else {
                    stringBuilder.append("\r\n" + s);
                }

            }
        }

        try (
                PrintWriter output = new PrintWriter(sourceFile);
        ) {
            output.println(stringBuilder);
        } finally {
            Date date = new Date();
            System.out.println("Done at " + date);
        }

    }


}
