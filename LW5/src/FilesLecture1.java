import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesLecture1 {


    // 5 points
    static String Q1(String filename) {

        // TODO: Read the input file and return its contents as a single String containing all lines of the file
        //       Concatenated together.
    	String ans = "";
    	try {
			for(String line : Files.readAllLines(Paths.get(filename))){
				ans = ans  + line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        return ans;
    }


    public static void main(String[] args) {
        String result = Q1("src/testFile.txt");
        System.out.println(result);
    }

}