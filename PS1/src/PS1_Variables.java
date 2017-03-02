public class PS1_Variables {


    static void Q1() {
         System.out.println("hello world!"); 

    }


    static void Q2() {
        System.out.println("115");

    }


    static void Q3() {
        int number = 5;
        // TODO: print the value of number times 2 (do not change the value of number)
        System.out.println(number * 2);

    }


    static int Q4() {
        int y = 0;
        // TODO: set the value of y to 12
        y = 12;


        return y;

    }


    static int Q5() {
        int x = 7;
        int y = 12;
        int z = 0;
        // TODO: Set the value of z to the multiplication of x and y (do not change the values of x or y)
        z = x*y;

        return z;
    }


    static void Q6() {
        String name = "Joe";
        // TODO: print "hello " followed by the value of name
        System.out.println("hello " + name);
    }


    static void Q7() {
        // TODO: print the number 3.14
    	System.out.println("3.14");

    }


    static double Q8() {
        double number = 0.0;
        // TODO: set the value of number to 0.08
        number = 0.08;


        return number;
    }


    static String Q9() {
        String text = "CSE191";
        // TODO: change the value of text to "CSE115"
        text = "CSE115";

        return text;
    }


    static void Q10() {
        String text = "The value of number is: ";
        int number = 6;
        // TODO: print "The value of number is: " followed by the value of number on the same line
        // Do not change the value of number
        System.out.println(text  + number);
    }


    static double Q11() {
        double x = 7.0;
        double y = 1.2;
        double z = 0.0;
        // TODO: set the value of z equal to the division of x divided by y (do not change the values of x or y)
        z = x/y;

        return z;
    }


    static int Q12() {
        int number = 56;
        // TODO: change the value of number to 65
        number = 65;

        return number;
    }


    static double Q13() {
        double number = 56.0;
        // TODO: change the value of number to 5.6
        number = number /10;

        return number;
    }


    static String Q14() {
        String x = "Expressions and";
        String y = "variables";
        String z = "";
        // TODO: set z equal to the concatenation of x and y separated by a space (do not change the values of x or y)
        z = x + " " + y;

        return z;
    }


    static double Q15() {
        int intNumber = 700;
        double doubleNumber = 0.0;
        // TODO: set the value of doubleNumber to the value of intNumber (do not change the value of intNumber)
        // Note that the value is the same, but the type is changing from int to double

        doubleNumber = (double)intNumber;
        return doubleNumber;
    }



}
