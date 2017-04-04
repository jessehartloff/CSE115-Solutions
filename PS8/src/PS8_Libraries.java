import java.util.ArrayList;

import cse115.math.NormalDistribution;
import cse115.math.Polynomial;
import cse115.words.Words;

public class PS8_Libraries {

	static double Q1(NormalDistribution distro, double x) {
		// return the z-score of x in the given distribution

		return distro.zScore(x);
	}

	static Polynomial Q2() {
		// return a new Polynomial representing "8x^2 + 5x - 6"

		return new Polynomial(-6.0, 5.0, 8.0);
	}

	static Polynomial Q3(ArrayList<Double> coefficients) {
		// return a new Polynomial with the provided coefficients

		return new Polynomial(coefficients);
	}

	static double Q4(Polynomial equation, double x) {
		// return the evaluation of the input polynomial at x
		return equation.evaluate(x);
	}

	static Polynomial Q5(Polynomial equation) {
		// return the derivative of the input polynomial

		return equation.getDerivative();
	}

	static int Q6(String word) {
		// return the number of syllable in the input word

		return Words.numberOfSyllables(word);
	}

	static boolean Q7(String word1, String word2) {
		// return true if the two input words rhyme at least 1 syllable, false
		// otherwise
		//
		// Words rhyme if they end with the same syllable

		return Words.rhymeLength(word1, word2) > 0;
	}

	static boolean Q8(String word1, String word2, String word3) {
		// return true if the three input words all rhyme at least 1 syllable,
		// false otherwise
		return Q7(word1, word2) && Q7(word1, word3);
	}

	static boolean Q9(String word1, String word2) {
		// return true if the two input words alliterate with at least 1 sound,
		// false otherwise.
		//
		// Words alliterate if they start with the same sound

		return Words.alliterationLength(word1, word2) > 0;
	}

	static boolean Q10(String word1, String word2, String word3) {
		// return true if the three input words all alliterate with at least 1
		// sound, false otherwise

		return Q9(word1, word2) && Q9(word1, word3);
	}

	static int Q11(String sentence) {
		// return the number of syllables in the given sentence. The input is
		// sentence with each word separated by
		// spaces and no punctuation.

		int total = 0;
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; ++i) {
			total += Words.numberOfSyllables(words[i]);
		}

		return total;
	}

	static ArrayList<String> Q12(String word) {
		// return all possible parts of speech of the given word

		return Words.getPartsOfSpeech(word);
	}

	static int Q13(String sentence, String partOfSpeech) {
		// return the maximum possible number of words in the input sentence
		// that can have the given part of speech.
		int total = 0;
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; ++i) {
			if (Words.getPartsOfSpeech(words[i]).contains(partOfSpeech)) {
				total++;
			}
		}

		return total;
	}

	static boolean Q14(String sentence1, String sentence2) {
		// return true if the two input sentences rhyme at one syllable. The
		// sentences rhyme if their last words rhyme.
		String[] word1 = sentence1.split(" ");
		String[] word2 = sentence2.split(" ");
		return Words.rhymeLength(word1[word1.length - 1], word2[word2.length - 1]) > 0;
	}

	static boolean Q15(ArrayList<String> words) {
		// return true if all the words in the input list alliterate with at
		// least 1 sound, false otherwise
        for(int i = 1; i < words.size(); ++i){
            if(Words.alliterationLength(words.get(0), words.get(i)) < 1){
                return false;
            }
        }
        return true;
	}

	public static void main(String[] args) {

	}

}
