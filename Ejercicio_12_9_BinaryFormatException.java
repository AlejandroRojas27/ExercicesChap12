import java.util.Scanner;

public class Ejercicio_12_9_BinaryFormatException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String bin = input.nextLine();


        try {
            int num = bin2Dec(bin);
            System.out.println(bin + " to decimal: " + num);

        } catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {

        boolean test = true;
        char ch = ' ';

        for (int i = 0; i < binaryString.length(); i++) {

            if (!Character.isDigit(binaryString.charAt(i)) &&
                    binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1') {
                test = false;
                ch = binaryString.charAt(i);
                break;
            }
        }

        if (test) {
            int answer = 0;
            for (int i = binaryString.length() - 1, j = 0; i >= 0; i--, j++) {
                int x = Integer.parseInt(String.valueOf(binaryString.charAt(j)));
                answer += x * Math.pow(2, i);
            }
            return answer;
        } else
            throw new BinaryFormatException(ch);
    }
}

class BinaryFormatException extends Exception {
    private char bin;

    public BinaryFormatException(char ch) {
        super("Not a binary number " + ch);
        this.bin = ch;
    }
}
