import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("ch: ");
        char ch = input.nextLine().charAt(0);

        System.out.print("str: ");
        String str = input.nextLine();

        System.out.print(ch + " " + str);


    }

}
