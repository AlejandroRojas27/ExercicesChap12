public class Ejercicio_12_10_OutOfMemoryError {
    public static void main(String[] args) {
        try {
            int[] array = new int[100000 * 100000];
        }catch (OutOfMemoryError ex){
            ex.printStackTrace();
            System.out.println("\n" + ex.getMessage());
            System.out.println("\n" + ex.toString());

            System.out.println("\nTrance Info Obtained from getStackTrance");
            StackTraceElement[] traceElements = ex.getStackTrace();
            for (int i = 0; i < traceElements.length; i++) {
                System.out.print("method " + traceElements[i].getMethodName());
                System.out.print("(" + traceElements[i].getClassName() + ":");
                System.out.println(traceElements[i].getLineNumber() + ")");
            }
        }

        System.out.println("Done :)");

    }
}
