import java.util.Date;
import java.util.Scanner;

public class Ejercicio_12_4_IllegalArgumentException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an annual interest rate: ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter a number of years: ");
        int numberOfYears = input.nextInt();

        System.out.print("Enter a loan amount: ");
        double loanAmount = input.nextDouble();

        try {
            Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);

            System.out.printf("The loan was created on %s\n " +
                            "The monthly payment is %.2f\nThe total payment is %.2f\n",
                    loan.getLoanDate().toString(), loan.getMonthlyPayment(), loan.getTotalPayment());

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("End of program :)");

    }
}

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    /**
     * Default constructor
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate,
     * number of years, and loan amount
     */

    public Loan(double annualInterestRate, int numberOfYear,
                double loanAmount) {
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYear);
        setLoanAmount(loanAmount);
        loanDate = new Date();
    }

    /**
     * Return annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     */

    public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException {
        if (annualInterestRate <= 0)
            throw new IllegalArgumentException(
                    "Annual Interest Rate cannot be less or equal to zero"
            );
        else
            this.annualInterestRate = annualInterestRate;
    }


    /**
     * Return numberOfYears
     */
    public double getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     */

    public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException(
                    "Number Of Years cannot be less or equal to zero"
            );
        } else
            this.numberOfYears = numberOfYears;

    }


    /**
     * Return loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set new loanAmount
     */

    public void setLoanAmount(double loanAmount) throws IllegalArgumentException {
        if(loanAmount <= 0){
            throw new IllegalArgumentException(
                    "Loan Amount cannot be lees or equal to zero"
            );
        }else
            this.loanAmount = loanAmount;
    }


    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /**
     * Return loan date
     */
    public Date getLoanDate() {
        return loanDate;
    }
}
