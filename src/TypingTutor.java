import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TypingTutor implements KeyListener {
	char currentLetter = generateRandomLetter();
	JLabel label;
	int keyCounter = 0;

	public static void main(String[] args) {
		new TypingTutor();
	}

	public TypingTutor() {

		JFrame frame = new JFrame("Typing Tutor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel(String.valueOf(currentLetter));
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);

		frame.addKeyListener(this);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}

	static char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar() == currentLetter) {
			label.setBackground(Color.GREEN);
			System.out.println("You typed: " + arg0.getKeyChar() + " ...correct!");
			keyCounter++;
			if (keyCounter > 30) {
				showTypingSpeed(keyCounter);
				System.exit(0);
			}
		} else {
			label.setBackground(Color.RED);
			System.out.println("You typed: " + arg0.getKeyChar() + " ...WRONG");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		currentLetter = generateRandomLetter();
		label.setText(String.valueOf(currentLetter));
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	Date timeAtStart = new Date();
	
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
		Date timeAtEnd = new Date();
		long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
		long gameInSeconds = (gameDuration / 1000) % 60;
		double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
		int charactersPerMinute = (int) (charactersPerSecond * 60);
		System.out.println("Game duration: " + gameInSeconds + ", Character Typed: " + numberOfCorrectCharactersTyped);
		JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	}
}
