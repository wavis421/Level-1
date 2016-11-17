import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class SpellingBee {
	int lines;
	ArrayList<String> words = new ArrayList<>();

	/*
	 * Get a random word using the randomWord() method and ask the user how to
	 * spell it using the speak() method. If the user spells it right move on to
	 * a new word, but if they do not spell it right ask again. The only place
	 * that you need to write code in is the stuffForYouToDo() Method
	 */
	public void stuffForYouToDo() {
		// You write code in here

		// Ask the user how many words to ask and parse it to an int
		int questions = Integer.parseInt(JOptionPane.showInputDialog("How many words do you want", "10"));
		// Make a for loop for the amount of words the user asked for.
		for (int i = 0; i < questions; i++) {
			// get a random word and hold it in a string
			String rightSpelling = randomWord();
			// make a new string to hold the users input (Do not give it a
			// value)
			String input;
			// make a boolean that holds if the user is right or not, set it to
			// false
			boolean right = false;
			// while not right
			while (!right) {
				// print out the right spelling
				System.out.println(rightSpelling);
				// speak to the user to spell the word
				Speak("Spell " + rightSpelling);
				// ask the user how to spell it and set it to the input
				input = JOptionPane.showInputDialog("Spell The word");
				// if the user is right
				if (rightSpelling.equalsIgnoreCase(input)) {
					// set the boolean to true
					right = true;
					// and tell the user they are right
					Speak("Correct");
					// but if the input is null (It means they hit the cancel
					// button)
				} else if (input == null) {
					// Close the program (System.exit(0);)
					System.exit(0);
				}
			}
		}
	}

	public String randomWord() {
		return words.get(new Random().nextInt(lines));
	}

	public SpellingBee() {
		System.out.println(" /--------------------------------------------\\ ");
		System.out.println(" | Warning: Some of the words are super hard! | ");
		System.out.println(" \\--------------------------------------------/ ");
		try {
			// Get the amount of lines
			LineNumberReader lnr = new LineNumberReader(new FileReader(new File("/usr/share/dict/words")));
			lnr.skip(Long.MAX_VALUE);// Skip to the end
			lines = lnr.getLineNumber();// Get last line number
			speakNoWait(lines + " words loaded");
			System.out.println("Number of words: " + lines);
			lnr.close();
			BufferedReader br = new BufferedReader(new FileReader(new File("/usr/share/dict/words")));
			for (int i = 0; i < lines; i++) {
				words.add(br.readLine()); // adds every line to the array
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		stuffForYouToDo();
	}

	public static void main(String[] args) {
		new SpellingBee();
	}

	public void Speak(String text) {
		/*
		try {
			Runtime.getRuntime().exec("say " + text).waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		*/
	}

	public void speakNoWait(String text) {
		try {
			Runtime.getRuntime().exec("say " + text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
