import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_12_33_SearchWeb {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");  // documentation
        String word = input.nextLine();

        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url, word); // Traverse the web from a starting url
    }

    public static void crawler(String startingURl, String word) throws Exception {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURl);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            String urlString = listOfPendingURLs.remove(0);
            //Simplify the code
            listOfTraversedURLs.add(urlString);
            if (containsTheWord(urlString, word)) {
                System.out.println("The page that contains the word " + word + " is " +
                        listOfTraversedURLs.get(listOfTraversedURLs.size() - 1));
                System.exit(1);

            }

            for (String s : getSubURls(urlString)) {
                if (!listOfTraversedURLs.contains(s) &&
                        !listOfPendingURLs.contains(s)) //Simplify the code
                    listOfPendingURLs.add(s);
            }


           /*
           if(!listOfTraversedURLs.contains(urlString)){
               listOfTraversedURLs.add(urlString);
               System.out.println("Crawl " + urlString);

               for (String s: getSubURls(urlString)) {
                   if(!listOfTraversedURLs.contains(s))
                       listOfPendingURLs.add(s);
               }
           }

            */


        }
    }

    public static ArrayList<String> getSubURls(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());


            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                //System.out.println(line);
                current = line.indexOf("http:", current);

                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { //Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else
                        current = -1;
                }


            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;
    }

    public static boolean containsTheWord(String urlString, String word) throws Exception {

        URL url = new URL(urlString);
        boolean ans = false;

        try (
                Scanner input = new Scanner(url.openStream())
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();

                if (s1.contains(word)) {
                    ans = true;
                    break;
                }


            }
        }

        return ans;
    }
}
