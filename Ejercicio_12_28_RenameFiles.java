import java.io.File;
import java.util.Date;

public class Ejercicio_12_28_RenameFiles {
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

            String modifiedName = modifyName(listOfFiles[i].getName());
            listOfFiles[i].renameTo(new File(modifiedName));

        }

        System.out.println("Done at " + new Date());


    }

    public static String modifyName(String name) {

        StringBuilder modifiedName = new StringBuilder();

        for (int j = 0; j < name.length(); j++) {

            if (!Character.isDigit(name.charAt(j))) {
                modifiedName.append(name.charAt(j));

            } else {
                modifiedName.append("0" + name.charAt(j));
            }

        }

        return String.valueOf(modifiedName);
    }

}
