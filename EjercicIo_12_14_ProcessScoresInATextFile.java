import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class EjercicIo_12_14_ProcessScoresInATextFile {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter name of the file: ");
        Scanner inputSystem = new Scanner(System.in);
        String fileName = inputSystem.nextLine();  // file name src/Text.txt

        File sourceFile = new File(fileName);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + fileName + " does not exist");
            System.exit(2);
        }

        int sum = 0;
        int count = 0;


        try (
                Scanner input = new Scanner(sourceFile)
        ) {
            while (input.hasNext()) {
                int num = input.nextInt();
                sum += num;
                count++;
            }


            System.out.println("Total: " + sum);
            System.out.println("Averange: " + (sum / count));
        }finally {
            Date date = new Date();
            System.out.println("Done at " + date);
        }


    }
}
