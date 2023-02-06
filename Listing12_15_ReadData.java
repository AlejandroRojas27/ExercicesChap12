import java.io.File;
import java.util.Scanner;

public class Listing12_15_ReadData {
    public static void main(String[] args) throws Exception {
        //We declare an Exception in main method to avoid
        //I/O Exceptions

        // Create a file instance
        File file = new File("scores.txt");

        //Create a Scanner for the file
        Scanner input = new Scanner(file);

        //Read data from a file
        while (input.hasNext()){
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName + " " + mi + " " + lastName + " " + score);

        }

        //Close the file
        input.close();

        //It is not necessary to close the input file,
        // but it is a good practice to do so to release
        //the resources occupied by the file.



        //Autoclose

        /*
        try (Scanner input = new Scanner(file);){
            while (input.hasNext()){
                String firstName = input.next();
                String mi = input.next();
                String lastName = input.next();
                int score = input.nextInt();
                System.out.println(firstName + " " + mi + " " + lastName + " " + score);

            }
        }

         */

    }
}
