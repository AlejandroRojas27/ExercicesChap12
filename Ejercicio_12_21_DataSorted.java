import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Ejercicio_12_21_DataSorted {
    public static void main(String[] args) throws Exception {

        //Create file object
        File file = new File("src/SortedText.txt");

        //The file exist?
        if (!file.exists()) {
            System.out.println("The file " + file.getName() + " does not exist");
            System.exit(1);
        }

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> listToSort = new ArrayList<>();

        try (
                //Scanner in the file
                Scanner input = new Scanner(file)
        ) {

            while (input.hasNext()) {
                String s1 = input.next();
                list.add(s1);
                listToSort.add(s1);
            }
        }

        //Sort one list
        Collections.sort(listToSort);

        //Check
        if (list.equals(listToSort)) {
            System.out.println("The strings in the files are stored in increasing order.");
            System.exit(2);
        } else {

            System.out.print("The first two strings that are out of the order are: ");

            for (int i = 0, cout = 0; cout < 2; i++) {
                if (!list.get(i).equals(listToSort.get(i))) {
                    System.out.print(list.get(i) + " ");
                    cout++;
                }

            }


        }


    }
}

