import java.util.ArrayList;
import java.util.Scanner;

public class Listing12_18_WebCrawler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Traverse the web from a starting url
    }

    public static void crawler(String startingURl){
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();

        listOfPendingURLs.add(startingURl);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100){
           String urlString = listOfPendingURLs.remove(0);
           //Simplify the code
           listOfTraversedURLs.add(urlString);
           System.out.println("Crawl " + urlString);

           for (String s: getSubURls(urlString)) {
               if(!listOfTraversedURLs.contains(s) &&
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

    public static ArrayList<String> getSubURls(String urlString){
        ArrayList<String> list = new ArrayList<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()){
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0){
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0){ //Ensure that a correct URL is found
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }

        return list;
    }

}
