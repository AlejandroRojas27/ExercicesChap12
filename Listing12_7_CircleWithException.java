public class Listing12_7_CircleWithException {
    /** The radius of the circle */
    private double radius;

    /** The number of the objects created */
    private static int numberOfObjects = 0;

    /** Construct a circle with radius 1 */
    public Listing12_7_CircleWithException(){
        this(1.0);
    }

    /** Construct a circle with a specified radius */
    public Listing12_7_CircleWithException(double newRadius){
        setRadius(newRadius);
        numberOfObjects++;
    }

    /** Return radius */
    public double getRadius(){
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double newRadius)
            throws IllegalArgumentException {
        if(newRadius >= 0)
            radius = newRadius;
        else
            throw new IllegalArgumentException(
                    "Radius cannot be negative");
    }

    /** Return numberOfObjects */
    public static int getNumberOfObjects(){
        return numberOfObjects;
    }

    /** Return the area of this circle */
    public double findArea(){
        return radius * radius * 3.14159;
    }
}
