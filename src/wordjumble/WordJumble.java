/*
 * WordJumble.java
 * ICS4U
 */
package wordjumble;

// Import Scanner to make scanning for user input possible.
import java.util.Scanner;

/**
 *
 * @author cogid4775
 */
public class WordJumble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create scanner to scan the user's input
        Scanner scan = new Scanner(System.in);
        
        // Instruction to tell the user to enter a word
        System.out.println("Please enter a word");
        
        // Variable String letters to hold the user's input
        // Use the Scanner scan to get the user's input
        // Convert the word to all uppercase letters for consistant case
        String letters = scan.nextLine().toUpperCase();
        
        // Line break so there is whitespace between scrambled words and the user's input
        System.out.println("");
        
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
            System.out.println(jumbLet + word);
        } else {
            for (pos = 0; pos < origWord.length(); pos++) {
                remainingLetters = origWord.substring(0, pos) + origWord.substring(pos + 1, origWord.length());
                // Recursive call to possibleWords()
                possibleWords(remainingLetters, origJumbledLetters + origWord.charAt(pos));
            }
        }
    }
    
}
