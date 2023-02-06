import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_24_CreateLargeDataset {
    public static void main(String[] args) throws Exception {

        File file = new File("src/Salary.txt");
        if (file.exists()) {
            file.delete();
        }

        File firstNamesFile = new File("src/FirstNames.txt");
        File lasttNamesFiles = new File("src/LastNames.txt");

        try (
                PrintWriter output = new PrintWriter(file)
        ) {

            for (int i = 1; i <= 1000; i++) {

                //Generate randomly rank
                //0 for Assistant
                //1 for Associate
                //2 for Full.
                int rank = (int) (Math.random() * 3);

                //Generate randomly first and last names
                String firstName = randomName(firstNamesFile);
                String lastName = randomName(lasttNamesFiles);

                if (rank == 0) {
                    Assistant assistant = new Assistant(firstName, lastName);
                    output.println(i + ".- " + assistant);
                } else if (rank == 1) {
                    Associate associate = new Associate(firstName, lastName);
                    output.println(i + ".- " + associate);
                } else if (rank == 2) {
                    Full full = new Full(firstName, lastName);
                    output.println(i + ".- " + full);
                }

            }

        }finally {
            System.out.println("Done at " + new Date());
        }

    }

    public static String randomName(File file) throws Exception {

        ArrayList<String> list = new ArrayList<>();


        try (
                Scanner input = new Scanner(file)
        ) {

            while (input.hasNext()) {
                list.add(input.next());
            }

        }

        int randomIndex = (int) (Math.random() * list.size());


        return list.get(randomIndex);
    }

}

class FacultyMember {
    private String firstName;
    private String lastName;
    private double salary;

    public FacultyMember() {
    }

    public FacultyMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Assistant extends FacultyMember {

    public Assistant() {
    }

    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
        setSalary();
    }

    public void setSalary() {
        double salary = Math.round((50000 + (Math.random() * 30000)) * 100.0) / 100.0;
        super.setSalary(salary);

    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " assistant " + String.format("%.2f", getSalary());
    }

}

class Associate extends FacultyMember {

    public Associate() {
    }

    public Associate(String firstName, String lastName) {
        super(firstName, lastName);
        setSalary();
    }

    public void setSalary() {
        double salary = Math.round((60000 + (Math.random() * 50000)) * 100.0) / 100.0;
        super.setSalary(salary);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " associate " + String.format("%.2f", getSalary());
    }

}

class Full extends FacultyMember {

    public Full() {
    }

    public Full(String firstName, String lastName) {
        super(firstName, lastName);
        setSalary();
    }

    public void setSalary() {
        double salary = Math.round((75000 + (Math.random() * 55000)) * 100.0) / 100.0;
        super.setSalary(salary);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " full " + String.format("%.2f", getSalary());
    }

}