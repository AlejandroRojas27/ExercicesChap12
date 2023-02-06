import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_20_RemovePackageStatement {
    public static void main(String[] args) throws Exception {
        //PATH: C:\Users\juan\IdeaProjects\EjercicioCAP12\src


        if (args.length != 1) {
            System.out.println("Usage: java Ejercicio_12_20_RemovePackageStatement srcRootDirectory");
            System.exit(1);
        }


        File currentDir = new File(args[0]);
        if (!currentDir.exists()) {
            System.out.println("Directory " + args[0] + " does not exist");
            System.exit(2);
        }

        if (!currentDir.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            System.exit(3);
        } else {
            File[] listOfFiles = currentDir.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {

                if (listOfFiles[i].isDirectory() && listOfFiles[i].getName().startsWith("chapter")) {
                    String str = "//package " + listOfFiles[i].getName() + ";\r\n";

                    File[] directory = listOfFiles[i].listFiles();

                    for (int j = 0; j < directory.length; j++) {
                        String fileName = directory[j].getName();

                        File currentFile = directory[j];

                        modifyClass(currentFile, str);

                    }

                }

            }

        }

        Date date = new Date();
        System.out.println("Done at " + date);


    }

    public static void modifyClass(File file, String topStr) throws Exception {

        ArrayList<String> list = new ArrayList<>();

        try (
                Scanner input = new Scanner(file);
        ) {
            while (input.hasNext()) {
                String s = input.nextLine();
                list.add(s);
            }

        }

        if(list.contains(topStr.trim())){
            list.remove(topStr.trim());
            try (
                    PrintWriter output = new PrintWriter(file);
            ) {
                for (int i = 0; i < list.size(); i++) {
                    output.println(list.get(i));
                }
            }

        }






    }
}
