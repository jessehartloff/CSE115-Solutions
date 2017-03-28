import cse115.math.NormalDistribution;

public class LibrariesLecture1 {


    // 5 points
    static cse115.math.NormalDistribution Q1(double mean, double standardDeviation) {
        // return a new normal distribution with the provided mean and standard deviation.
        // Use the NormalDistribution class in the provided library
        return new NormalDistribution(standardDeviation, mean);
    }


    public static void main(String[] args) {

    }

}
