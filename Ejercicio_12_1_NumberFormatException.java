public class Ejercicio_12_1_NumberFormatException {

    public static void main(String[] args) {
        String[] operation1 = {"22", "+", "8"};
        calculatorWithExceptionHandler(operation1);
        calculatorWithoutExceptionHandler(operation1);
    }

    public static void calculatorWithExceptionHandler(String[] args) {

        //Check if number of string passed

        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        //The result of the operation
        int result = 0;
        String wrong = "";

        try {
            for (int i = 0; i < args[0].length(); i++) {
                if (!Character.isDigit(args[0].charAt(i))) {
                    wrong = args[0];
                }
            }

            for (int i = 0; i < args[2].length(); i++) {
                if (!Character.isDigit(args[2].charAt(i))) {
                    wrong = args[2];
                }
            }

            //Determine the operator
            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                    break;
            }

            //Display the result
            System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);

        } catch (Exception ex) {
            System.out.println("Wrong Input " + wrong);
        }

    }

    public static void calculatorWithoutExceptionHandler(String[] args) {

        String wrong = null;

        for (int i = 0; i < args[0].length(); i++) {
            if (!Character.isDigit(args[0].charAt(i))) {
                wrong = args[0];
            }
        }

        for (int i = 0; i < args[2].length(); i++) {
            if (!Character.isDigit(args[2].charAt(i))) {
                wrong = args[2];
            }
        }

        if (wrong == null) {

            //Check if number of string passed
            if (args.length != 3) {
                System.out.println("Usage: java Calculator operand1 operator operand2");
                System.exit(1);
            }

            //The result of the operation
            int result = 0;

            //Determine the operator
            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                    break;
            }

            //Display the result
            System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);


        } else {
            System.out.println("Wrong Input " + wrong);
        }


    }
}
