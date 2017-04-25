public class OOPLecture1 {

    /*** Note: We are abusing inner classes in this assignment by defining multiple classes inside the
     * OOPLecture1 class. In most cases it is better practice to define each class in a separate file ***/


    // Q1: Create and abstract class named "SuperClass"

    // Q2: Add an int named "instanceNumber" as a instance variable with getter and setter methods
    //     (getNumber() and setNumber(int)) to SuperClass (Do not define a constructor for SuperClass)

    // Q3: Create an abstract method in SuperClass called "action(int)" that returns an int

    // Q4: Create a concrete class named "Adder" that extends SuperClass and overrides action(int) to return
    //     the addition of the method's input and instanceNumber as an int

    // Q5: Create a concrete class named "Multiplier" that extends SuperClass and overrides action(int) to return
    //     the input multiplied by instanceNumber as an int

	public abstract class SuperClass {
		int instanceNumber;

		public int getInstanceNumber() {
			return instanceNumber;
		}

		public void setInstanceNumber(int instanceNumber) {
			this.instanceNumber = instanceNumber;
		}
		public abstract int action(int input);
	}
	
	public class Adder extends SuperClass{
		public int action(int input){
			return this.getInstanceNumber() + input;
		}
	}
	
	public class Multiplier extends SuperClass{
		public int action(int input){
			return this.getInstanceNumber() * input;
		}
	}


    public static void main(String[] args) {
        // The following code is an example of testing these inner classes


////        // We need an instance of the outer class to use the inner classes
//        OOPLecture1 outerClass = new OOPLecture1();
////
////        // Use the instance of the outer class to create instances of the inner class
//        SuperClass adder = outerClass.new Adder();
//        SuperClass multiplier = outerClass.new Multiplier();
//
//        // Since Adder and Multiplier extend SuperClass they inherit instanceNumber and its getter/setter methods
//        adder.setInstanceNumber(5);
//        multiplier.setInstanceNumber(5);
//
//        // Even though adder and multiplier are both stored in variables of type SuperClass, their action methods
//        // have different behavior.
//        System.out.println(adder.action(10)); // expected: 15
//        System.out.println(multiplier.action(10)); // expected: 50
    }

}
