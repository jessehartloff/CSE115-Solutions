import java.util.ArrayList;

public class OOPLecture3 {


    // 2 points
    public static ArrayList<Boilable> Q1(){
        // Return an ArrayList containing 1 Egg and 3 Potatoes
    	 ArrayList<Boilable> done = new ArrayList<Boilable>();
    	 done.add(new Egg());
    	 done.add(new Potato());done.add(new Potato());done.add(new Potato());

        return done;
    }


    // 2 points
    public static void Q2(ArrayList<Boilable> input){
        // Boil each element in the input list
    	for(Boilable b : input){
    		b.boil();
    	}

    }


    // 1 point
    public static String Q3(ArrayList input){
        // Return a single String containing the output of toString() from every element in the input list separated
        // by new line characters '\n'
        //
        // Note: This ArrayList does not specify a type. While this is not something you would want to do outside
        //       the classroom, we do it here to show a feature of polymorphism in java. Since the type is not
        //       specified this is not a very useful data structure, but since every class in java extends Object
        //       and ArrayLists must contain objects (recall we can use primitives like int with an ArrayList)
        //       we can assume that this ArrayList contains elements of type Object and we can treat it as an
        //       ArrayList of Objects. As such, we can call the methods associated with the Object class,
        //       including toString().

    	String ans = "";
    	for(Object o : input){
    		ans += o.toString() + "\n";
    	}
        return ans;
    }



    public static void main(String[] args) {

        // testing
        ArrayList<Boilable> breakfast = Q1();
        System.out.println(Q3(breakfast));
        Q2(breakfast);
        System.out.println(Q3(breakfast));

    }

}