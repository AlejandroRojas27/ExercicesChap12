import java.util.Scanner;

public class Ejercicio_12_2_InputMismatchException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean sentinel = false;
        System.out.println("Enter two an integer: ");

        do {
            try {

                int num1 = input.nextInt();

                int num2 = input.nextInt();

                System.out.println("Sum: " + (num1 + num2));
                sentinel = true;

            }catch (Exception ex){
                System.out.println("Incorrect input, prompt again");
                input.nextLine();
            }

        }while (!sentinel);


    }
}
