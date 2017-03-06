import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class PS5_Files {




    static ArrayList<String> Q1(String filename){
        // Return all lines of the file in an ArrayList with 1 String for each line in the file
    	ArrayList<String> al = new ArrayList<String>();
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){
				al.add(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return al;
    }


    static int Q2(String filename){
        // return the number of lines in the input file
    	int lines = 0;
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){
				lines++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return lines;
    }


    static double Q3(String number){
        // Return the double represented by the input String. You can assume the String contains a well-formed double.
    	

        return new Double(number);
    }


    static int Q4(String filename, char letter){
        // return the number of times letter appears in the input file
    	int times = 0;
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){
				for(int i = 0; i < s.length(); i++){
					if(s.charAt(i) == letter){
						times++;
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return times;
    }


    static boolean Q5(String filename){
        // return true if the file can be successfully opened, false otherwise. Hint: If the file cannot be opened, an
        // IOException will be thrown.
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){				
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}

    }


    static String Q6(String line){
        // Given a line containing comma-separated values, return the second value.

    	//can be done right in the return statement like so
    	//return line.split(",")[1];
    	String [] data = line.split(",");
    	//remember arrays are 0 indexed meaning that the 1st index is the 2nd value
    	return data[1];
    }


    static int Q7(String line){
        // Given a line containing comma-separated values, return the second value as an int. You can assume the second
        // value is a well-formed integer.
    	//can be done right in the return statement like so
//    	return new Integer(line.split(",")[1]);
    	String [] data = line.split(",");
    	//remember arrays are 0 indexed meaning that the 1st index is the 2nd value
    	return new Integer(data[1]);
    }


    static ArrayList<Integer> Q8(String filename){
        // Read the file to populate an ArrayList of Integers and return the ArrayList. Each line of the file will
        // contain a well-formed integer.
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){	
				list.add(new Integer(s));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }


    static ArrayList<String> Q9(String line){
        // Given a line containing comma-separated values, return an ArrayList of Strings containing each value in the
        // line separately. Example: Given "comma,separated,values" return ["comma","separated","values"] as 3 entries
        // in an ArrayList.
    	
    	String [] data = line.split(",");
    	ArrayList<String> list = new ArrayList<String>();
    	for(String s : data){
    		list.add(s);
    	}

        return list;
    }


    static HashMap<String, Integer> Q10(String filename){
        // Read the input file and add an entry into a HashMap for each line. The lines will contain comma separated
        // values with a String then an int (ex: "text,5"). For each line enter the String as the key and the int as
        // a value into the map and return the map.4
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){	
				String[] data = s.split(",");
				map.put(data[0], new Integer(data[1]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return map;
    }


    static ArrayList<String> Q11(String filename){
        // Read the file to populate an ArrayList of Strings and return the ArrayList. The file will be comma separated
        // and only the 2nd value (index 1) is to be added into the ArrayList
    	ArrayList<String> list = new ArrayList<String>();
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){	
				String[] data =s.split(",");
				list.add(data[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }


    static ArrayList<Integer> Q12(String filename){
        // Read the file to populate an ArrayList of Integers and return the ArrayList. Each line of the file will
        // contain comma separated data and only the 3rd value (index 2) is to be added into the ArrayList as Integers.
        // You can assume the 3rd value on each line is a well-formed Integer.
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	try {
			for(String s : Files.readAllLines(Paths.get(filename))){	
				String[] data =s.split(",");
				list.add(new Integer(data[2]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }


    static void Q13(String filename, String data){
        // create a new file named filename and write the contents of data into it
    	try {
			Files.write(Paths.get(filename), data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


    static void Q14(String filename, String data){
        // append the contents of data to the end of filename. You can assume a file named filename already exists
    	try {
			Files.write(Paths.get(filename), data.getBytes(),StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


    static void Q15(String inputFilename, String outputFilename){
        // read every line in inputFilename and write it to a file named outputFilename (make a copy of the file)
    	String data = "";
    	try {
			for(String s :Files.readAllLines(Paths.get(inputFilename))){
				data = data + s;
			}
			Files.write(Paths.get(outputFilename), data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }



    public static void main(String[] args) {
        // sample usage
        System.out.println(Q1("data/test0.txt"));
    }

}
