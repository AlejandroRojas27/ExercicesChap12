import java.util.Scanner;

public class Ejercicio_7_35_GameHangman {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] words = {"blur", "thecure", "korn", "bowie", "ghost", "pixies", "pulp", "filter", "blondie", "jesu"};

        int num = (int) (Math.random() * words.length);

        String wordSelect = words[num];
        int lengthWord = wordSelect.length();


        char[] toPlay = new char[lengthWord];
        char[] toPlayWord = new char[lengthWord];

        for (int i = 0; i < toPlay.length;i++){
            toPlay[i] = '*';
            toPlayWord[i] = wordSelect.charAt(i);
        }


        int count = 0;
        int mistake = 0;
        char answer = ' ';

        char sentinel = 'y';

        while (sentinel == 'y'){

            //-----***** Back to 0 *****-----
            if(count > 0){

                //Back to 0
                num = (int) (Math.random() * words.length);

                wordSelect = words[num];
                lengthWord = wordSelect.length();


                toPlay = new char[lengthWord];
                toPlayWord = new char[lengthWord];

                for (int i = 0; i < toPlay.length;i++){
                    toPlay[i] = '*';
                    toPlayWord[i] = wordSelect.charAt(i);
                }

                count = 0;
                mistake = 0;

            }

            //-----***** Game *****-----
            while (count < toPlay.length+1) {
                System.out.print("(Guess) Enter a letter in word ");
                for (int i = 0; i < toPlay.length; i++) {
                    System.out.print(toPlay[i] + " ");
                }
                System.out.print(" > ");
                answer = input.next().charAt(0);

                //Cheark if answer is in the word
                int x = 0;
                for (int j = 0; j < 1; j++) {


                    for (int i = 0; i < toPlay.length; i++) {

                        if (toPlayWord[i] == answer && toPlay[i] != answer) {
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
                        System.out.println("The word is " + wordSelect + ". You missed " + mistake + " times");
                        count++;
                    }


                }


            }

            //-----***** Sentinel *****-----
            System.out.println("Do you want to guess another word? Enter y or n>");
            sentinel = input.next().charAt(0);

        }

    }
}
