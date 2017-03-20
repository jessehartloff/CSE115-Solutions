public class YourClass {

	// 1 point
	// Create 2 ints as instance variables named 'a' and 'b'
	private int a;
	private int b;

	// 1 point
	// Write a constructor that takes 2 ints as parameters and sets the values
	// of the parameters to the instance
	// variables. The first parameter is stored in 'a' and the second parameter
	// is stored in 'b'
	public YourClass(int input1, int input2) {
		this.a = input1;
		this.b = input2;
	}

	// 1 points
	// Write getter methods for 'a' and 'b' named "getA" and "getB"
	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

	// 1 points
	// Write setter methods for 'a' and 'b' named "setA" and "setB"
	public void setA(int input) {
		this.a = input;
	}

	public void setB(int input) {
		this.b = input;
	}

	// 1 point
	// Write a method named difference that takes no parameters and returns the
	// subtraction of 'a' minus 'b' as an int
	public int difference() {
		return this.a - this.b;
	}
	
	 // 2 point
    // Override the toString method to return a String in the format "(a, b)"
	@Override
	public String toString(){
		return "("  + this.a + ", " + this.b + ")";
	}



    /* Static method */

    // 3 points
    public static void decrement(YourClass instance){
        // Subtract 1 from both 'a' and 'b' in the given instance of YourClass
    	instance.a = instance.a - 1;
    	instance.b = instance.b - 1;  

    }

}