import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_23_ProcessScoresInATextFileOnTheWeb {
    public static void main(String[] args) throws Exception {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter an URL: ");

        String urlString = input1.nextLine();//"http://liveexample.pearsoncmg.com/data/Scores.txt";

        URL url = new URL(urlString);

        try (
                Scanner input = new Scanner(url.openStream())
                ){
            int sum = 0;
            int count = 0;
            while (input.hasNext()){
                int num = input.nextInt();
                sum += num;
                count++;

            }

            System.out.println("Total: " + sum);
            System.out.println("Average: " + (sum / count));

        }finally {
            System.out.println("Done at " + new Date());
        }

    }
}
