import cse115.words.Words;

public class LibrariesLecture3{


    // 5 points
    static int Q1(String word1, String word2) {
        // return the number of rhyming syllables between the two input words. We will define nthe number of rhyming
        // syllables as the number of syllables in the largest matching suffix of sounds between the words. This
        // is the same definition used by the provided library.
        //
        // Note: The cse115 library has been included in this project, but none of the classes have been imported.


        return Words.rhymeLength(word1, word2);
    }


    public static void main(String[] args) {
    	
    }

}