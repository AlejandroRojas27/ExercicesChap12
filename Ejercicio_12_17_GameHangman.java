import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_12_17_GameHangman {
    public static void main(String[] args) throws Exception {

        File sourceFile = new File("src/hangman.txt");

        String wordToLower = readWord(sourceFile);

        String wordSelected = readWord(sourceFile);

        Scanner input = new Scanner(System.in);


        int lengthWord = wordSelected.length();

        char[] toPlay = new char[lengthWord];
        char[] toPlayWord = new char[lengthWord];

        for (int i = 0; i < toPlay.length; i++) {
            toPlay[i] = '*';
            toPlayWord[i] = wordSelected.charAt(i);
        }


        int count = 0;
        int mistake = 0;
        char answer = ' ';

        char sentinel = 'y';

        while (sentinel == 'y') {

            //-----***** Back to 0 *****-----
            if (count > 0) {

                //Back to 0

                wordSelected = readWord(sourceFile);
                lengthWord = wordSelected.length();

                toPlay = new char[lengthWord];
                toPlayWord = new char[lengthWord];

                for (int i = 0; i < toPlay.length; i++) {
                    toPlay[i] = '*';
                    toPlayWord[i] = wordSelected.charAt(i);
                }

                count = 0;
                mistake = 0;

            }

            //-----***** Game *****-----
            while (count < toPlay.length + 1) {
                System.out.print("(Guess) Enter a letter in word ");
                for (int i = 0; i < toPlay.length; i++) {
                    System.out.print(toPlay[i] + " ");
                }
                System.out.print(" > ");
                answer = input.next().charAt(0);
                char ansLower = Character.toLowerCase(answer);

                //Cheark if answer is in the word
                int x = 0;
                for (int j = 0; j < 1; j++) {


                    for (int i = 0; i < toPlay.length; i++) {

                        if (toPlayWord[i] == answer &&
                                toPlay[i] != answer) {
                            toPlay[i] = answer;
                            count++;
                            x++;
                        } else if (toPlay[i] == answer) {
                            x++;
                            if (x == 1) {
                                System.out.println("    " + answer + " is already in the word");
                            }
                        }

                    }
                    if (x == 0) {
                        mistake++;
                        System.out.println("    " + answer + " is not in the word");
                    }

                    if (count == toPlay.length) {
                        System.out.println("The word is " + wordSelected + ". You missed " + mistake + " times");
                        count++;
                    }


                }


            }

            //-----***** Sentinel *****-----
            System.out.println("Do you want to guess another word? Enter y or n>");
            sentinel = input.next().charAt(0);

        }

    }

    public static String readWord(File sourceFile) throws Exception {

        ArrayList<String> list = new ArrayList<>();

        try (
                Scanner input = new Scanner(sourceFile)
        ) {
            while (input.hasNext()) {
                String s = input.next();
                list.add(s);
            }
        }

        int n = (int) (Math.random() * list.size());

        String st = list.get(n);
        String ans = "";

        for (int i = 0; i < st.length(); i++) {
            String lower = String.valueOf(Character.toLowerCase(st.charAt(i)));
            ans += lower;
        }

        return ans;
    }

}
