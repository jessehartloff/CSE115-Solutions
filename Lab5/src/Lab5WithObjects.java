import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lab5WithObjects {

    public static Location getLocation(City city){
        // Directory may need to be changed depending on where the cities files are stored
        String directory = "cities/";
        String filename = directory + city.getCountryCode() + ".csv";
        try {
            for (String line : Files.readAllLines(Paths.get(filename))) {
                String[] splits = line.split(",");
                if(splits[1].equals(city.getCityName()) && splits[2].equals(city.getRegion())){
                	
                	// found city
                	double latitude = new Double(splits[3]);
                	double longitude = new Double(splits[4]);
                	Location cityLocation = new Location(latitude, longitude);
                return cityLocation;
                    
                    // more compact:
                    // return new Location(new Double(splits[3]), new Double(splits[4]));
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Error reading file: " + filename);
            return null;
        }
        System.out.println("City not found");
        return null;
    }
    
   
    public static double getDistance(City city0, City city1){
    	
    	Location locationCity0 = getLocation(city0);
    	Location locationCity1 = getLocation(city1);
    	return LabLibrary.greaterCircleDistance(locationCity0, locationCity1);
    	
    	// more compact:
    	// return LabLibrary.greaterCircleDistance(getLocation(city0), getLocation(city1));
    }
    
    
    public static void main(String[] args){
    	City buffalo = new City("us","buffalo","ny");
    	City rochester = new City("us","rochester","ny");
    	City newDelhi = new City("in","new delhi","07");
    	
        System.out.println(getLocation(buffalo));
        System.out.println(getLocation(rochester));
        System.out.println();
        System.out.print("Distance between Rochester and Buffalo: ");
        System.out.println(getDistance(rochester, buffalo) + "km");
        System.out.print("Distance between New Delhi and Buffalo: ");
        System.out.println(getDistance(newDelhi, buffalo) + "km");
    }
    
}

