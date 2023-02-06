import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio_12_25_ProcessLargeDataset {
    public static void main(String[] args) throws Exception {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter an URL: ");
        String urlString = input1.nextLine(); //http://liveexample.pearsoncmg.com/data/Salary.txt


        URL url = new URL(urlString);

        try (
                Scanner input = new Scanner(url.openStream())
        ) {

            ArrayList<Double> assistantSalary = new ArrayList<>();
            ArrayList<Double> associateSalary = new ArrayList<>();
            ArrayList<Double> fullSalary = new ArrayList<>();
            ArrayList<Double> facultySalary = new ArrayList<>();


            while (input.hasNext()) {

                String s1 = input.nextLine();
                String[] split = s1.split(" ");
                double salary = Double.parseDouble(split[3]);
                facultySalary.add(salary);

                if (s1.contains("assistant")) {
                    assistantSalary.add(salary);
                } else if (s1.contains("associate")) {
                    associateSalary.add(salary);
                } else if (s1.contains("full")) {
                    fullSalary.add(salary);
                }


            }


            double totalAssistantSalary = computeTotal(assistantSalary);
            double totalAssociateSalary = computeTotal(associateSalary);
            double totalFullSalary = computeTotal(fullSalary);
            double totalFacultySalary = computeTotal(facultySalary);

            System.out.printf("Total salary of Assistant professors: %.2f\n", totalAssistantSalary);
            System.out.printf("Average salary of Assistant professors: %.2f\n\n", (totalAssistantSalary / assistantSalary.size()));

            System.out.printf("Total salary of Associate professors: %.2f\n", totalAssociateSalary);
            System.out.printf("Average salary of Associate professors: %.2f\n\n", (totalAssociateSalary / associateSalary.size()));

            System.out.printf("Total salary of Full professors: %.2f\n", totalFullSalary);
            System.out.printf("Average salary of Full professors: %.2f\n\n", (totalFullSalary / fullSalary.size()));

            System.out.printf("Total salary of the faculty: %.2f\n", totalFacultySalary);
            System.out.printf("Average salary of the faculty: %.2f\n", (totalFacultySalary / facultySalary.size()));


        }


    }

    public static double computeTotal(ArrayList<Double> list) {

        double sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }
}
