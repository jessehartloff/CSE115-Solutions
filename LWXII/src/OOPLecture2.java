public class OOPLecture2 {

    /*** Note: We are abusing inner classes in this assignment by defining multiple classes inside the
     * OOPLecture1 class. In most cases it is better practice to define each class in a separate file ***/

    // Q1: Create an interface named "Boilable" containing an abstract method named boil() that takes no parameters and
    //     has return type void.
	
	public interface Boilable{
		public abstract void boil();
	}

    // Q2: Create a concrete class named "Egg" that implements Boilable. The Egg class should have 1 instance variable
    //     that is a String named "state" that is initialized to "raw" in the default constructor. Override its boil
    //     to set the value of state to "hard boiled"
	
	public class Egg implements Boilable{
		String state = "raw";
		@Override
		public void boil() {
			state = "hard Boiled";
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String toString(){
			return (state.equals("raw")) ?"this egg is raw" : "this egg is hard boiled";
		}
		
	}

    // Q3: Override Egg's toString method to print "this egg is raw" or "this egg is hard boiled" depending on the
    //     state of the egg.

    // Q4: Create a concrete class named "Potato" that implements Boilable. The Potato class should have 1 instance
    //     variable that is a boolean named "soft" that is initialized to false in the default constructor. Override
    //     its boil method to set the value of soft to true.
	
	public class Potato implements Boilable{
		public Boolean soft = false;

		@Override
		public void boil() {
			soft = true;
			// TODO Auto-generated method stub
			
		}
		 @Override
		 public String toString(){
			 return (soft) ?"this potato is soft" : "this potato is hard";
		 }
	}

    // Q5: Override Potato's toString method to return "this potato is hard" if soft is false and "this potato is soft"
    //     if soft is true.



    public static void main(String[] args) {
        // The following code is an example of testing these inner classes
        // Uncomment this code to test your classes

        OOPLecture2 outerInstance = new OOPLecture2();

        Boilable egg = outerInstance.new Egg();
        Boilable potato = outerInstance.new Potato();

        System.out.println(egg);
        System.out.println(potato);

        System.out.println("\nboiling...\n");
        egg.boil();
        potato.boil();

        System.out.println(egg);
        System.out.println(potato);

    }

}