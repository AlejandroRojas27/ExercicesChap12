import java.io.File;
import java.util.Scanner;

public class Ejercicio_12_32_RankingSummary {
    public static void main(String[] args) throws Exception {

        File directory = new File("src");

        File[] listOfFiles = directory.listFiles();

        String top = String.format("%s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s"
                , "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");

        System.out.println(top);

        for (int i = listOfFiles.length - 1; i >= 0; i--) {

            if (listOfFiles[i].getName().contains("babynameranking")) {

                openFile(listOfFiles[i]);

            }

        }

    }

    public static void openFile(File file) throws Exception {

        String year = file.getName().substring(15, 19);
        StringBuilder line = new StringBuilder();
        line.append(year + " ");

        try (
                Scanner input = new Scanner(file);
        ) {

            int count = 0;

            while (count < 5) {

                String str = input.nextLine();
                String[] split = str.split(" ");
                String s1 = String.format("%10s ", split[5]);

                line.append(s1);

                count++;
            }
        }

        try (
                Scanner input = new Scanner(file);
        ) {

            int count = 0;

            while (count < 5) {

                String str = input.nextLine();
                String[] split = str.split(" ");
                String s1 = String.format("%10s ", split[2]);

                line.append(s1);

                count++;
            }
        }


        System.out.println(line);


    }

}
