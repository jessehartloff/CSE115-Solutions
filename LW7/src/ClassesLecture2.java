public class ClassesLecture2{


    /*** DO NOT SUBMIT THIS FILE!! Submit YourClass.java only ***/


    // 0 points
    public static YourClass Q1(int a, int b){
        // Return an instance of YourClass (an object of type YourClass) with the
        // values of the input for 'a' and 'b'

        return new YourClass(a, b);
    }


    // 0 points
    public static int Q2(YourClass instance){
        // Given an instance of YourClass, return the 'a' minus 'b' where 'a' and 'b' are instance
        // variables in YourClass

        return instance.difference();
    }


    // 0 points
    public static void Q3(YourClass instance1, YourClass instance2){
        // Swap the values of 'a' and 'b' between the 2 instances of YourClass

        int tempA = (int) instance1.getA();
        int tempB = instance1.getB();

        instance1.setA(instance2.getA());
        instance1.setB(instance2.getB());

        instance2.setA(tempA);
        instance2.setB(tempB);
    }


    public static void main(String[] args){

        // All the solutions above need YourClass to be defined to run without errors. Until YourClass is complete,
        // this code will not compile. For a partially complete YourClass you can submit to Autolab and view feedback.

        // Write the class with the right methods to get these tests to compile and run

        YourClass instanceOfYourClass = Q1(4, 7);
        System.out.println("Expect a to be 4");
        System.out.println("Actual a is " + instanceOfYourClass.getA());

        System.out.println("\nExpect b to be 7");
        System.out.println("Actual b is " + instanceOfYourClass.getB());

        int q2Result = Q2(instanceOfYourClass);
        System.out.println("\nExpect difference to be -3");
        System.out.println("Actual difference is " + q2Result);

        YourClass secondInstance = new YourClass(10,-4);

        Q3(instanceOfYourClass, secondInstance);
        System.out.println("\nExpected 10");
        System.out.println("Actual " + instanceOfYourClass.getA());

        System.out.println("\nExpected -4");
        System.out.println("Actual " + instanceOfYourClass.getB());

        System.out.println("\nExpected 4");
        System.out.println("Actual " + secondInstance.getA());

        System.out.println("\nExpected 7");
        System.out.println("Actual " + secondInstance.getB());
    }

}