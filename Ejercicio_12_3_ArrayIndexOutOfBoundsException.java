import java.util.Scanner;

public class Ejercicio_12_3_ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int length = 100;
        int[] array = randomlyChosenIntegers(length);

        System.out.print("Enter an index: ");
        int index = input.nextInt();

        try {
            System.out.println("Corresponding element value: " + array[index]);
        }catch (Exception ex){
            System.out.println("Out of Bounds");
        }

    }

    public static int[] randomlyChosenIntegers(int length){
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random() * 10);
        }

        return array;
    }
}
