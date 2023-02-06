import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_22_ReplaceText {
    public static void main(String[] args) throws Exception {
        //PATH: C:\Users\juan\IdeaProjects\EjercicioCAP12\src\chapter1

        //CHECKING THE ARGUMENTS
        if (args.length != 3) {
            System.out.println("Usage: java Exercise12_22 dir oldString newString");
            System.exit(1);
        }

        //CREATING DIRECTORY
        File directory = new File(args[0]);

        //CHECKING IF THE DIRECTORY EXIST
        if (!directory.exists()) {
            System.out.println("Directory " + args[0] + " does not exist");
            System.exit(2);
        }

        //CHECKING IF THE ARG IS A DIRECTORY
        if (!directory.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            System.exit(3);
        }

        File[] filesList = directory.listFiles();
        for (int i = 0; i < filesList.length; i++) {
            repaceTextInFiles(filesList[i], args[1], args[2]);
        }

        System.out.println("Done at " + new Date());



    }

    public static void repaceTextInFiles(File file, String oldString, String newString) throws Exception {

        ArrayList<String> list = new ArrayList<>();

        try (
                Scanner input = new Scanner(file)
        ) {
            while (input.hasNext()) {

                String s1 = input.nextLine();
                String s2 = s1.replaceAll(oldString, newString);

                list.add(s2);
            }

        }

        try (
                PrintWriter output = new PrintWriter(file)
                ){

            for (int i = 0; i < list.size(); i++) {
                output.println(list.get(i));
            }
        }finally {
            System.out.println("Task done in " + file.getName());
        }

    }

}
