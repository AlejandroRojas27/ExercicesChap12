import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_15_WriteReadData {
    public static void main(String[] args) throws Exception {

        File file = new File("src/Exercise_12_15.txt");

        if (file.exists()) {
            file.delete();
        }

        try (
                PrintWriter output = new PrintWriter(file);
        ) {
            for (int i = 0; i < 100; i++) {
                int num = (int) (Math.random() * 20);
                output.print(num + " ");
            }
        } finally {
            Date date = new Date();
            System.out.println("File created and filled with 100 randomly integers at\n" + date);
        }


        ArrayList<Integer> list = new ArrayList<>();
        try (
                Scanner input = new Scanner(file)
        ) {

            while (input.hasNext()) {
                int num = input.nextInt();
                list.add(input.nextInt());
            }

            Collections.sort(list);

            for (int i = 1, j = 0; i <= list.size(); i++, j++) {
                if(i % 10 == 0){
                    System.out.println(list.get(j));
                }else {
                    System.out.print(list.get(j) + " ");
                }
            }

        } finally {
            Date date = new Date();
            System.out.println("Data read and display the data in increasing order at\n" + date);
        }

    }
}
