import java.io.File;
import java.util.Scanner;

public class Exist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("File exist? ");
        String str = input.nextLine();
        File file = new File(str);
        System.out.print(file.exists());
    }
}
