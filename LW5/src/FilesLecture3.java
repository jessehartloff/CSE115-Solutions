import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilesLecture3 {


    // 5 points
    static void Q1(String filename, ArrayList<String> lines) {

        // TODO: Write all elements of the ArrayList into a new file with a name provided by the filename variable.
        //       The data can be written on separate lines or all on the same line.
    	
    	String writeOneLine = "";
    	String writeMultiLine = "";
    	
    	
    	// writes all data to one line
    	for(String data : lines){
    		writeOneLine = writeOneLine + data;
    		
    	}
    	
    	// writes all data to multiple lines
    	for(String data : lines){
    		writeMultiLine = writeMultiLine + data + "\n";
    		
    	}
    	
    	
    	
    	
    	try {
			Files.write(Paths.get(filename), writeOneLine.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	



    }


    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("You are");
        lines.add("writing this text");
        lines.add("to");
        lines.add("a");
        lines.add("file");

        Q1("src/outputFile.txt", lines);
    }

}