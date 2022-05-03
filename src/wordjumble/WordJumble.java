/*
 * WordJumble.java
 * ICS4U
 */
package wordjumble;

// Being used to get user input without a Scanner
import javax.swing.*;

/**
 *
 * @author cogid4775
 */
public class WordJumble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // String letters is used to hold the user's input
        // Convert the word to all lowercase letters for consistant case, although not required
        String letters = JOptionPane.showInputDialog("Please enter a word").toLowerCase();
        
        // Call the recursive method possibleWords()
        possibleWords(letters, ""); 
    }
    
    /**
     * Scrambles the letters passed into String word to create all possible arrangements of the letters
     * @param word the letters that have not yet been used (use the original word e.g. "COPY" for the first call)
     * @param jumbLet the letters that have already been used (use a blank String "" for the first call)
     */
    public static void possibleWords(String word, String jumbLet) {
        int pos;
        String remainingLetters;
        String origWord = word;
        String origJumbledLetters = jumbLet;
        if (word.length() == 1) {
            // Print scrambled word
            System.out.println(jumbLet + word);
        } else {
            for (pos = 0; pos < origWord.length(); pos++) {
                // Get the remaining letters
                remainingLetters = origWord.substring(0, pos) + origWord.substring(pos + 1, origWord.length());
                // Recursive call
                possibleWords(remainingLetters, origJumbledLetters + origWord.charAt(pos));
            }
        }
    }
    
}
