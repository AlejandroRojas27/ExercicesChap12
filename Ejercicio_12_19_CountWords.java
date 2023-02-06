import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_19_CountWords {
    public static void main(String[] args) throws Exception {
        Scanner inputSystem = new Scanner(System.in);
        System.out.print("Enter the URL: " );

        String urlString = inputSystem.nextLine(); //"http://liveexample.pearsoncmg.com/data/Scores.txt";
        URL url = new URL(urlString);

        try (
                Scanner input = new Scanner(url.openStream());
                ){
            int countWords = 0;
            while (input.hasNext()){
                String word = input.next();
                countWords++;
            }

            System.out.println("Webside has " + countWords + " words" );

        }finally {
            Date date = new Date();
            System.out.println("Done at " + date);
        }



    }
}
