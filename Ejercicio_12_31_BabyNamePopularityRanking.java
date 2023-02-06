import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_31_BabyNamePopularityRanking {
    public static void main(String[] args) throws Exception {
        Scanner systemInput = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = systemInput.nextInt();
        String fileName = "babynameranking" + year + ".txt";
        String path = "src/" + fileName;

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("The file " + fileName + " does not exist");
            System.exit(1);
        }

        System.out.print("Enter the gender: ");
        char gender = systemInput.next().charAt(0);

        System.out.print("Enter name: ");
        String name = systemInput.next();

        int index = 0;

        try (
                Scanner input = new Scanner(file)
        ) {

            while (input.hasNext()) {

                String s1 = input.nextLine();
                String[] split = s1.split(" ");

                if (gender == 'M') {

                    if (name.equals(split[2])) {
                        index = Integer.parseInt(split[0]);
                        break;
                    }

                } else if (gender == 'F') {

                    if (name.equals(split[5])) {
                        index = Integer.parseInt(split[0]);
                        break;
                    }

                }
            }

        }

        if (index > 0) {
            System.out.println(name + " is ranked in #" + index + " in year " + year);
        } else {
            //The name ABC is not ranked in year 2010
            System.out.println("The name " + name + " is not in the year " + year);
        }


    }
}
