import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_27_ReplaceWords {
    public static void main(String[] args) throws Exception {


        File directory = new File(args[0]);

        if (!directory.exists()) {
            System.out.println("Directory " + args[0] + " does not exist");
            System.exit(2);
        }

        if (!directory.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            System.exit(3);
        }

        File[] listOfFiles = directory.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            ArrayList<String> listOfContent = scanFile(listOfFiles[i]);

            modifyFile(listOfContent, listOfFiles[i]);

        }

        System.out.println("Done at " + new Date());

    }

    public static ArrayList<String> scanFile(File file) throws Exception {

        ArrayList<String> content = new ArrayList<>();

        try (
                Scanner input = new Scanner(file)
        ) {

            while (input.hasNext()) {

                String str = input.nextLine();

                if (str.contains("E1_1")) {
                    String modifiedText = Ejercicio_12_28_RenameFiles.modifyName(str);
                    content.add(modifiedText);

                } else {
                    content.add(str);
                }

            }

        }

        return content;
    }

    public static void modifyFile(ArrayList<String> content, File file) throws Exception {

        try (
                PrintWriter output = new PrintWriter(file)
        ) {

            for (int i = 0; i < content.size(); i++) {
                output.println(content.get(i));
            }

        }

    }

}
