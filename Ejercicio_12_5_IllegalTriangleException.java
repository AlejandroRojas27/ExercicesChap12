import java.util.Scanner;

public class Ejercicio_12_5_IllegalTriangleException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side 3: ");
        double side3 = input.nextDouble();


        try {
            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.print(triangle.toString());

        } catch (IllegalTriangleException e) {
            throw new RuntimeException(e);
        }


    }
}

class Triangle extends GeometricObject {
    /**
     * Three double data fields named side1, side2, and side3 with
     * default values 1.0 to denote three sides of a triangle.
     */
    private double side1;
    private double side2;
    private double side3;

    /**
     * A no-arg constructor that creates a default triangle.
     */
    public Triangle() throws IllegalTriangleException {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    /**
     * ■ A constructor that creates a triangle with the specified side1, side2, and side3.
     * The accessor methods for all three data fields.
     */

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {

        if((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }else
            throw new IllegalTriangleException(side1, side2, side3);

    }

    /**
     * A method named getArea() that returns the area of this triangle.
     */
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.pow((s - side1) * (s - side2) * (s - side3) * s, 0.5);
    }

    /**
     * A method named getPerimeter() that returns the perimeter of this triangle.
     */
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /**
     * A method named toString() that returns a string description for the triangle.
     */
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 +
                " side3 = " + side3;
    }

    /**
     * Getters
     */

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    private double getSide3() {
        return side3;
    }

}

class IllegalTriangleException extends Exception {
    private double side1 = 1.0;

    private double side2 = 1.0;

    private double side3 = 1.0;

    public IllegalTriangleException(double side1, double side2, double side3){
        super("The sides does not adhere to the rule\n(the sum of any two sides is greater than the other side).");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with the specified color
     * and filled value
     */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean its,
     * getter method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dataCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     */
    @Override
    public String toString() {
        return "crated on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }


}
