import java.io.File;
import java.util.Date;

public class Ejercicio_12_29_RenameFiles {
    public static void main(String[] args) {

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

            if(listOfFiles[i].getName().contains("Exercice")) {
                String modifiedName = modifyText(listOfFiles[i].getName());
                listOfFiles[i].renameTo(new File(modifiedName));
            }

        }

        System.out.println("Done at " + new Date());


    }

    public static String modifyText(String name){

        int index = 0;
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == '_'){
                index = i;
            }
        }

        StringBuilder strBulider = new StringBuilder(name);

        strBulider.insert((index + 1),'0');

        return String.valueOf(strBulider);

    }
}
